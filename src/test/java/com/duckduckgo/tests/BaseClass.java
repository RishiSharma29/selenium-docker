package com.duckduckgo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass
{
    protected WebDriver driver;

    @BeforeTest
    public void SetupDriver() throws MalformedURLException
    {
        String host="localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("Firefox"))
        {
            dc=DesiredCapabilities.firefox();
        }
        else
        {
            dc=DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null)
        {
            host=System.getProperty("HUB_HOST");
        }

        String completeUrl="http://"+host+":4444/wd/hub";
        driver=new RemoteWebDriver(new URL(completeUrl),dc);

        /*System.setProperty("webdriver.chrome.driver","C:\\DockerLearn\\drivers\\chromedriver\\chromedriver.exe");
        driver=new ChromeDriver(); */
    }

    @AfterTest
    public void Quit()
    {
        driver.quit();
    }


}
