package com.selenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.tests.BaseTest;

public class BasePage extends PageGenerator {
    WebDriverWait wait;

    public BasePage() {
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
    }

    public <T> void click(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementAttr)).click();
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr)).click();
        }
    }

    public <T> void writeText(T elementAttr, String text) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementAttr)).sendKeys(text);
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr)).sendKeys(text);
        }
    }

    public <T> String readText(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementAttr)).getText();
        } else {
            return wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr)).getText();
        }
    }

    public void handlePopup(By by) throws InterruptedException {
        List<WebElement> popup = BaseTest.getDriver().findElements(by);
        if (!popup.isEmpty()) {
            popup.get(0).click();
            
            Thread.sleep(200);
        }
    }
}
