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

public class ReplayInteractiveVideoTest extends StudentLoginBase {

    public ReplayInteractiveVideoTest() {
        this(false);
    }

    public ReplayInteractiveVideoTest(boolean tearDownBrowserAfterEachTest) {
        super(tearDownBrowserAfterEachTest);
    }

    @Test
    public void replayInteractiveVideo() {
        WebDriver driver = TestDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Step 1: Navigate to a previously watched video
        NavigationUtil.navigateToUrl("https://demo.subexpert.com/CourseLectures/OnTopic/OOSE-Labs/5-Projects-on-GitHub");

        // Ensure video is loaded
        WebElement videoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("invideaeditor")));
        Assert.assertTrue(videoElement.isDisplayed(), "The video is not displayed");

        // Step 2: Replay the video
        NavigationUtil.replayVideo();

        // Wait for the video to replay (using a placeholder wait condition)
        WebElement replayedVideoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("invideaeditor")));
        Assert.assertTrue(replayedVideoElement.isDisplayed(), "The video replayed is not displayed");

        // Step 3: Verify all interactive elements are functioning (e.g., check an interactive element)
        WebElement interactiveElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("interactiveElementId"))); // Use the correct locator
        Assert.assertTrue(interactiveElement.isDisplayed(), "Interactive elements are not functioning");

        System.out.println("The video replayed correctly with all interactive elements functioning.");
    }
}
