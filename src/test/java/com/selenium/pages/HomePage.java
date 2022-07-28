package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selenium.tests.BaseTest;
import com.selenium.utils.AttachmentUtils;

import io.qameta.allure.Step;
import lombok.SneakyThrows;

public class HomePage extends BasePage {
    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement logLink;

	@Step("Open CRM home page step...")
	public HomePage givenIAmAtHomePage() {
		BaseTest.getDriver().get("https://freecrm.com/");
		
		return this;
	}
	
	@SneakyThrows
	@Step("Go to Login Page step...")
	public LoginPage whenIGoToLoginPage() {
		Thread.sleep(2000);
        
        click(logLink);
        
        new AttachmentUtils().saveScreenshotPNG();
        
        return PageFactory.initElements(BaseTest.getDriver(), LoginPage.class);
	}
}
