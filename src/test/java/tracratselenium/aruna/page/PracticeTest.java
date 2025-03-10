package tracratselenium.aruna.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tracratselenium.aruna.stepdef.Hooks;

public class PracticeTest {

    private WebDriver webDriver;

    public PracticeTest(Hooks hooks){
        webDriver = hooks.getDriver();
    }

    public WebDriver getDriver(){
        return  webDriver;
    }
}
