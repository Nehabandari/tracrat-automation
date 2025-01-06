package tracratselenium.helpers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import tracratselenium.stepdef.BrowserStepDefs;

public class DriverHelper {

    private WebDriver webDriver;

    public DriverHelper(BrowserStepDefs browserstepdefs) {
        webDriver = browserstepdefs.getDriver();
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public void waitForDocumentReady(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigReader.getWaitTimeOut()));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void waitForPageLoad() {
        try {
            pause(500);
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigReader.getWaitTimeOut()));
            // Wait for document ready
            wait.until(driver -> ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").equals("complete"));

            // Wait for network requests to complete using Performance API
            wait.until(driver -> {
                Long pendingRequests = (Long) ((JavascriptExecutor) driver).executeScript(
                        "return window.performance.getEntriesByType('resource')" +
                                ".filter(function(r) {" +
                                "    return !r.responseEnd;" +
                                "}).length;"
                );
                return pendingRequests == 0;
            });
        } catch (TimeoutException e) {
            throw new RuntimeException("Page load timeout", e);
        }
    }

    public void waitForVisible(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofSeconds(ConfigReader.getWaitTimeOut())).until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForClickable(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofSeconds(ConfigReader.getWaitTimeOut())).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForElementNotPresent(By locator) {
        new WebDriverWait(webDriver, Duration.ofSeconds(ConfigReader.getWaitTimeOut())).until(ExpectedConditions.numberOfElementsToBe(locator, 0));
    }

    public void waitForAlert(){
        new WebDriverWait(webDriver, Duration.ofSeconds(ConfigReader.getWaitTimeOut())).until(ExpectedConditions.alertIsPresent());
    }

    public void assertAlert( String expectedAlertText )
    {
        Assert.assertEquals( webDriver.switchTo().alert().getText(), expectedAlertText );
    }

    public void pause(int timeoutInMilliseconds) {
        try {
            Thread.sleep(timeoutInMilliseconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void scrollUsingActions(WebElement element) {
        new Actions(webDriver)
                .scrollToElement(element)
                .perform();
    }

    public void click(WebElement webElement) {
        webElement.click();
    }

    public void chooseOk()
    {
        webDriver.switchTo().alert().accept();
    }

    public void chooseCancel()
    {
        webDriver.switchTo().alert().dismiss();
    }

    public String executeJavascript( String executeJavascript, Object... webElement )
    {
        return (String) ( (JavascriptExecutor) webDriver ).executeScript( executeJavascript, webElement );
    }

    public void scrollIntoView( WebElement webElement )
    {
        executeJavascript( "arguments[0].scrollIntoView(true);", webElement );
    }

    public void selectNgxDropdownOption(WebElement webelement, String value) {
        waitForVisible(webelement);
        click(webelement);
        pause(2000);
        WebElement searchText = webelement.findElement(By.name("search-text"));
        waitForClickable(searchText);
        searchText.sendKeys(value);
        pause(1500);
        List<WebElement> options = webelement.findElements(By.xpath(".//div[@class='available-items']/div"));
        boolean foundOption = false;
        for (WebElement eachOption : options) {
            String optionText = eachOption.getText().trim();
            System.out.println(optionText);
            if (optionText.equals(value)) {
                foundOption = true;
                eachOption.click();
                break;
            }
        }
        Assert.assertTrue(foundOption, value + " Option not found");
        waitForPageLoad();
    }

    public byte[] takeScreenshotAndReturnBytes() {
        byte[] screenshotFile = null;
        try {
            screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenshotFile;
    }

}
