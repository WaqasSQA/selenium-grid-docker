package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            //URL url = new URL("localhost:4444");
            //WebDriver driver = new RemoteWebDriver(url, cap);
            Thread.sleep(5000);
            driver.get("https://www.google.com/");
            System.out.println(driver.getTitle());
            driver.quit();
        }
    }
