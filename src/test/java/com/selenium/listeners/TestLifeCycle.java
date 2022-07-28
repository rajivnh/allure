package com.selenium.listeners;

import com.selenium.utils.AttachmentUtils;
import com.selenium.utils.Log;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class TestLifeCycle implements TestLifecycleListener {
	
    @Override
    public void beforeTestStop(final TestResult result) {
    	Log.info("Finishing step: {}" + result.getStatus() + " *** " + result.getStatusDetails().getMessage());
    	
    	if(result.getStatus().value().equals("failed") || result.getStatus().value().equals("broken")) {
	    	new AttachmentUtils().saveScreenshotPNG();
    	}
    }
}
