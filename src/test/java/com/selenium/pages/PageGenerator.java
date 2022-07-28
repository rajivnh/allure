package com.selenium.pages;

import org.openqa.selenium.support.PageFactory;

import com.selenium.tests.BaseTest;

public class PageGenerator {

    public <TPage extends BasePage> TPage getPage(Class<TPage> pageClass) {
        return PageFactory.initElements(BaseTest.getDriver(), pageClass);
    }
}
