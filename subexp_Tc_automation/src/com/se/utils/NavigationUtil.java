package com.se.utils;

import com.se.TestDriver;
import com.se.config.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.scanner.Constant;


import static com.se.utils.UtilsSet.clickOnElement;

public class NavigationUtil {
    @Step("Opening a subject base on {0}.")
    public static void openSubjectFromLearnMenu(String subName) {
        clickOnElement(By.linkText(subName));
    }

    public static void navigateToUrl(String url) {
        WebDriver driver = TestDriver.getDriver();
        driver.get(url);
    }
}
