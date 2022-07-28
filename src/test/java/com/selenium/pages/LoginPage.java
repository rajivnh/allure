package com.selenium.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.qameta.allure.Step;
import lombok.SneakyThrows;

public class LoginPage extends BasePage {
    @FindBy(how = How.NAME, using = "email")
    public WebElement email;
    
    @FindBy(how = How.NAME, using = "password")
    public WebElement password;
    
    @FindBy(how = How.CLASS_NAME, using = "submit")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "(//p[normalize-space()='Invalid login'])[1]")
    public WebElement invalidLoginMessage;
    
    @SneakyThrows
    @Step("Login to CRM with {0} and {1} step...")
    public LoginPage andILoginToCRM(String email, String password) {  	
        writeText(this.email, email);
        writeText(this.password, password);
        
		Thread.sleep(2000);
                
        click(loginButton);
        
        return this;
    }
    
    @Step("Verify \"{0}\" text displayed step...")
    public LoginPage thenIVerifyLoginFailMessage(String expectedText) {
        assertEquals(readText(invalidLoginMessage), expectedText);
        
        return this;
    }
}
