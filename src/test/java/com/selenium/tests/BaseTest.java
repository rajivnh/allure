package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.selenium.pages.PageGenerator;

public class BaseTest {	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    
    protected WebDriverWait wait;
    
    protected PageGenerator page;

    @BeforeClass
    public void classLevelSetup() {
    	System.setProperty("webdriver.chrome.driver", "c:/aws/chromedriver.exe");
    	
        WebDriver driver = new ChromeDriver();
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        page = new PageGenerator();
        
        tdriver.set(driver);
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }
    
    @AfterClass
    public void teardown() {
    	BaseTest.getDriver().quit();
    }
}
