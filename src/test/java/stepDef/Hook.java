package stepDef;

import base.config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

public class Hook extends config {

    public static String url;
    public static String envType = System.getProperty("env");
    public static String browserType = System.getProperty("browser");


    @Before
    public void beforeEachTest(){
        if (Strings.isNullOrEmpty(envType)){
            envType = "qa";
        }
        if (Strings.isNullOrEmpty(browserType)){
            browserType = "ch";
        }
        driver = setupBrowser(browserType);
        switch (envType){
            case "qa":
                url = "https://www.express.com";
                break;
            case "stage":
                url = "https://www.express.com";
            case "prod":
                url = "https://www.express.com";
                break;
        }
        driver.get(url);

    }

    @After
    public void testComplete(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        //driver.close();
        //driver.quit();

    }
}