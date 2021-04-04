package com.duckduckgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="q")
    private WebElement searchField;

    @FindBy(id="search_button_homepage")
    private WebElement searchBtn;

    public HomePage(WebDriver driver)
    {
       this.driver=driver;
       wait=new WebDriverWait(driver,30);
       PageFactory.initElements(driver,this);
    }

    public void GoTo()
    {
        driver.get("https://duckduckgo.com/");
    }

    public void EnterSearchTerm(String srch)
    {
        this.wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(srch);
    }

    public void ClickSearchBtn()
    {
        searchBtn.click();
    }



}
