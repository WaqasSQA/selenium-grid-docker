package org.example;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;



public class main2 {

    public RemoteWebDriver driver;
    @BeforeClass
            public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
         driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
    }
    @Test
            public void test1() throws InterruptedException {

        Thread.sleep(10000);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
