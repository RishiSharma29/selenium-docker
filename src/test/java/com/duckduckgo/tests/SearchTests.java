package com.duckduckgo.tests;

import com.duckduckgo.pages.HomePage;
import com.duckduckgo.pages.ResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTests extends BaseClass
{
    @Test
    @Parameters({"key","title"})
    public void TestSearchWorks(String key, String title)
    {
        HomePage hp=new HomePage(driver);
        hp.GoTo();
        hp.EnterSearchTerm(key);
        hp.ClickSearchBtn();

        String str = driver.getTitle();
        System.out.println(str);
        Assert.assertEquals(str,title);
    }

    @Test(dependsOnMethods = "TestSearchWorks")
    public void CheckVideoLinksCount()
    {
        ResultsPage rp=new ResultsPage(driver);
        rp.ClickVideos();
        int count=rp.VideoCount();
        Assert.assertTrue(count > 0,"Number of videos listed is more than 0");

    }

}
