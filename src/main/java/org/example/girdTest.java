package org.example;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class girdTest {
    public RemoteWebDriver driver;


   @BeforeSuite
    public void startContainer(){
    CommonMethods.runTerminalCommand("docker-compose up", "Node has been added");
    }

    @BeforeTest
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        URL url = new URL("http://localhost:4444/wd/hub");
        if (browser.equalsIgnoreCase("chrome")){
            cap.setBrowserName("chrome");
            //cap.setCapability("name", "ChromeTest");
            driver = new RemoteWebDriver(url, cap);
            driver.get("https://www.google.com/");
        } else if (browser.equalsIgnoreCase("firefox")) {
            cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
            driver = new RemoteWebDriver(url, cap);
            driver.get("https://www.facebook.com/");
        }
        System.out.println("Opening the Browser ===> "+browser);
    }

    @Test
    public void getTitle(){
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @AfterSuite
    public void stopContainer(){
        CommonMethods.runTerminalCommand("docker-compose down", "Removing");
    }
}
