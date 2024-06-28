package com.se.tests.smoke;

import com.se.TestDriver;
import com.se.rolesbase.TeacherLoginBase;
import com.se.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddInteractiveVideoTest extends TeacherLoginBase {

    public AddInteractiveVideoTest() {
        this(false);
    }

    public AddInteractiveVideoTest(boolean tearDownBrowserAfterEachTest) {
        super(tearDownBrowserAfterEachTest);
    }

    @Test
    public void addVideo() {
        // Navigate to the specified URL
        NavigationUtil.navigateToUrl("https://demo.subexpert.com/CourseLectures/OnTopic/OOSE-Labs/1-Environment-and-OOPs");

        WebDriver driver = TestDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Click on the 3 dots menu
        WebElement threeDotsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div/div/div[2]/span")));
        threeDotsMenu.click();

        // Click on the InVideo text
        WebElement inVideoText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div/div/div[1]/span[2]/a[4]")));
        inVideoText.click();

        // Click on the Add Video button
        WebElement addVideoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='invideadiv']/div/div[1]/div[2]/a")));
        addVideoButton.click();

        // Fill in the form fields
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Title']")));
        titleField.sendKeys("Attendance Mapper" + System.currentTimeMillis());

        WebElement cloudStorageLinkField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CloudSharedLink']")));
        cloudStorageLinkField.sendKeys("https://drive.google.com/file/d/1LM3mvNnSyrdWveK7-w0gDUQsMAUDEcTF/view?usp=sharing");

        // Click the Add button
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addvideoform']/div/div[4]/div/input")));
        addButton.click();

        // Verify success message
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='addvideoform']/div/div[1]/div/h4")));
        Assert.assertEquals(successMessage.getText(), "Success!");

        System.out.println("Video added successfully and verified.");
    }
}
