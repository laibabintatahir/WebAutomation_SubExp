package com.se.tests.smoke;

import com.se.TestDriver;
import com.se.rolesbase.TeacherLoginBase;
import com.se.utils.NavigationUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DeleteInteractiveVideoTest extends TeacherLoginBase {

    public DeleteInteractiveVideoTest() {
        this(false);
    }

    public DeleteInteractiveVideoTest(boolean tearDownBrowserAfterEachTest) {
        super( tearDownBrowserAfterEachTest);
    }
@Test
    public void deleteInteractiveVideo() {
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

        // Click on the delete button for the video
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='videos']/div/div[2]/div[4]/a[3]")));
        deleteButton.click();

        // Handle the alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Verify success message
        WebElement successMessageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='modaldialog']/div/header/h3")));
        Assert.assertEquals(successMessageHeader.getText(), "Done!");

        WebElement successMessageBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='modaldialog']/div/div")));
        Assert.assertEquals(successMessageBody.getText(), "Video deleted successfully.");

        System.out.println("Video deleted successfully and verified.");
    }
}
