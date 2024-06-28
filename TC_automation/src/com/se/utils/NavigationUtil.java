package com.se.utils;

import com.se.config.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.yaml.snakeyaml.scanner.Constant;
import com.se.TestDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.se.utils.UtilsSet.clickOnElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.se.TestDriver;

public class NavigationUtil {
    public static void navigateToUrl(String url) {
        WebDriver driver = TestDriver.getDriver();
        driver.get(url);
    }
    public static void replayVideo() {
        WebDriver driver = TestDriver.getDriver();
        // Assuming the video has a replay button with a specific ID or class
        WebElement replayButton = driver.findElement(By.id("replayButton")); // Use the correct locator
        replayButton.click();
    }

    public static void navigateToProgressSection() {
        WebDriver driver = TestDriver.getDriver();
        // Assume there is a link or button to go to the progress section
        WebElement progressLink = driver.findElement(By.id("progressSectionLink")); // Use the correct locator
        progressLink.click();
    }

    @Step("Opening a subject based on {0}.")
    public static void openSubjectFromLearnMenu(String subName) {
        clickOnElement(By.linkText(subName));
    }
}

