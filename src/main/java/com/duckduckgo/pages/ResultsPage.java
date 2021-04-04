package com.duckduckgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(partialLinkText="Videos")
    private WebElement videosLink;

    @FindBy(className="tile--vid")
    List<WebElement> vidCount;

    public ResultsPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickVideos()
    {
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
    }

    public int VideoCount()
    {
          By by= By.className("tile--vid");
          wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
          int count=vidCount.size();
          return count;
    }

}
