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

public class TrackInteractiveVideoProgressTest extends StudentLoginBase {

    public TrackInteractiveVideoProgressTest() {
        this(false);
    }

    public TrackInteractiveVideoProgressTest(boolean tearDownBrowserAfterEachTest) {
        super(tearDownBrowserAfterEachTest);
    }

    @Test
    public void trackProgressOnInteractiveVideo() {
        WebDriver driver = TestDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Step 1: Navigate to the progress section
        NavigationUtil.navigateToUrl("https://demo.subexpert.com/CourseLectures/OnTopic/OOSE-Labs/5-Projects-on-GitHub");

        // Wait for the progress section to be visible
        WebElement progressSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("progressSection"))); // Use correct locator
        Assert.assertTrue(progressSection.isDisplayed(), "Progress section is not displayed");

        // Step 2: View and verify progress on interactive videos
        WebElement learningProgress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("learningProgress"))); // Use correct locator
        String progressText = learningProgress.getText();
        Assert.assertTrue(progressText.contains("30%"), "Progress is not displayed correctly");

        // Verify additional progress details if needed
        WebElement infoProgress = driver.findElement(By.id("infoProgress")); // Use correct locator
        WebElement confirmProgress = driver.findElement(By.id("confirmProgress")); // Use correct locator
        WebElement questionsProgress = driver.findElement(By.id("questionsProgress")); // Use correct locator

        Assert.assertTrue(infoProgress.getText().contains("0 / 0 / 3"), "Info progress is not correct");
        Assert.assertTrue(confirmProgress.getText().contains("0 / 0 / 3"), "Confirm progress is not correct");
        Assert.assertTrue(questionsProgress.getText().contains("0 / 0 / 3"), "Questions progress is not correct");

        System.out.println("Progress on interactive videos is displayed accurately.");
    }
}
