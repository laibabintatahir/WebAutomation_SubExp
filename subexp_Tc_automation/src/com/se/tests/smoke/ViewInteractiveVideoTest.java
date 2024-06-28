// File: src/com/se/tests/smoke/ViewInteractiveVideoTest.java

package com.se.tests.smoke;

import com.se.TestDriver;
import com.se.rolesbase.StudentLoginBase;
import com.se.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewInteractiveVideoTest extends StudentLoginBase {

    public ViewInteractiveVideoTest() {
        this(false);
    }

    public ViewInteractiveVideoTest(boolean tearDownBrowserAfterEachTest) {
        super( tearDownBrowserAfterEachTest);
    }

    @Test
    public void verifyInteractiveVideoElements() {
        // Navigate to the video section
        NavigationUtil.navigateToUrl("https://demo.subexpert.com/CourseLectures/OnTopic/OOSE-Labs/5-Projects-on-GitHub");

        WebDriver driver = TestDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Wait for the 3 dots menu to be clickable and click it
        WebElement threeDotsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[4]/div[1]/header/div/div/div[2]/span")));
        threeDotsMenu.click();

        // Wait for the InVideo text to be clickable and click it
        WebElement inVideoText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[4]/div[1]/header/div/div/div[1]/span[2]/a[4]")));
        inVideoText.click();

        // Wait for the video element to be visible
        WebElement videoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("invideaeditor")));
        Assert.assertTrue(videoElement.isDisplayed(), "No video element found");

        System.out.println("Interactive video elements are visible and clickable.");
    }
}
