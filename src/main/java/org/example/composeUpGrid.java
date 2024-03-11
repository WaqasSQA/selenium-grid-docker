package org.example;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class composeUpGrid {
    public RemoteWebDriver driver;


        @BeforeTest
        @Parameters({"browser"})
        public void setup(String browser) throws MalformedURLException {
            DesiredCapabilities cap = new DesiredCapabilities();
            URL url = new URL("http://localhost:4444/wd/hub");
            if (browser.equalsIgnoreCase("chrome")){
                cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                cap.setCapability("zal:name", "chrometest");
                //Optional can be removed later
                cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
                driver = new RemoteWebDriver(url, cap);
                driver.get("https://www.google.com/");
            } else if (browser.equalsIgnoreCase("firefox")) {
                cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                cap.setCapability("zal:name", "firefoxtest");
                //Optional can be removed later
                cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
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

    }

