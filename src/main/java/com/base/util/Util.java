package com.base.util;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {
    public static String getTextFromElement(WebDriver webDriver, Target target) {
        WebElement element = target.resolveFor(webDriver);
        return element.getText();
    }
}
