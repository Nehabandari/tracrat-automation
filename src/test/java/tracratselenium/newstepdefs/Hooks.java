package tracratselenium.newstepdefs;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    private WebDriver webDriver;

    @BeforeAll
    public static void beforeTestExecution(){
        System.out.println("i am in before test execution");
    }

    @AfterAll
    public static void afterTestExecution(){
        System.out.println("i am in after test execution");
    }

    @Before
    public void openBrowser(){
        System.out.println("I am in open browser");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://angular15.gotracrat.in/#/login");
    }

    @After
    public void closeBrowser(Scenario scenario){
        System.out.println(scenario.getStatus());
        if(scenario.isFailed()){
            //take screenshot

            System.out.println("test case failed");
        }
        webDriver.quit();
        System.out.println("I am in close browser");
    }

    public WebDriver getDriver(){
        return webDriver;
    }
    /*
    @BeforeStep
    public void beforeStep(){
        System.out.println("i am in before step");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("i am in after step");
    }
    */

}
