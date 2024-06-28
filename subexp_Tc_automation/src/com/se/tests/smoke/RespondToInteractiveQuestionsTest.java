// File: src/com/se/tests/smoke/RespondToInteractiveQuestionsTest.java

package com.se.tests.smoke;

import com.se.TestDriver;
import com.se.rolesbase.StudentLoginBase;
import com.se.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RespondToInteractiveQuestionsTest extends StudentLoginBase {

    public RespondToInteractiveQuestionsTest() {
        this(false);
    }

    public RespondToInteractiveQuestionsTest(boolean tearDownBrowserAfterEachTest) {
        super(tearDownBrowserAfterEachTest);
    }

    @Test
    public void respondToInteractiveQuestions() {
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
        WebElement videoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("invideadiv")));
        Assert.assertTrue(videoElement.isDisplayed(), "No video element found");

        // Select the strict mode video with interactions
        WebElement strictModeVideo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='videos']/div/div[3]/div[4]/a")));
        strictModeVideo.click();

        // Add 5 seconds wait to allow the video to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Switch to the iframe context
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my_video")));
        driver.switchTo().frame(iframe);

        // Add 5 seconds wait to allow the video to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Play the video using JavaScript and wait for it to start playing
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('video').play();");


        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[4]/button")));
        playButton.click();

        // Ensure the video is playing

        // Ensure the video plays for a few seconds
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Skip the video to 2:00 to trigger the modal dialog
        js.executeScript("document.querySelector('video').currentTime = 120;");

        // Switch back to the main content
        driver.switchTo().defaultContent();

        // Wait for the modal dialog to appear
        WebElement modalDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modaldialog")));
        Assert.assertTrue(modalDialog.isDisplayed(), "Modal dialog did not appear");

        // Verify the content of the modal dialog
        WebElement modalContent = modalDialog.findElement(By.xpath("/html/body/div[6]/div/div"));
        Assert.assertTrue(modalContent.getText().contains("LEARNING with 100% is active, Note that forwarding of the video is not allowed."),
                "Modal dialog content is incorrect");

        System.out.println("Interactive questions responded to and video skip restriction verified successfully.");
    }
}
