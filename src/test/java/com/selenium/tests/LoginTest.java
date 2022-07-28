package com.selenium.tests;

import org.testng.annotations.Test;

import com.selenium.pages.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Login Tests Epic")
@Feature("Login Features")
public class LoginTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("User tries to login the system with invalid username and invalid password.")
    @Description("Invalid Login Test with Invalid Username and Invalid Password.")
    public void invalidLoginTestInvalidUserNameInvalidPassword() {
    	page.getPage(HomePage.class)
    		.givenIAmAtHomePage()
    		.whenIGoToLoginPage()
    		.andILoginToCRM("sathish.s@gmail.com", "R@@Tii5672")
    		.thenIVerifyLoginFailMessage("Invalid Login");
    }
}
