package AutomationAssignment;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Q13 {
        WebDriver driver;

        @Before
        public void setup() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.gmail.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
        }

        @Test
        public void gmailScreenshots() throws InterruptedException, IOException {
            driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("qatesting00567@gmail.com");
            TakesScreenshot Sc1 = ((TakesScreenshot) driver);
            File SrcFile = Sc1.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(SrcFile, new File("C:\\Users\\shres\\Desktop\\ScreenShots\\gmail1.png"));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Test@123");
            Thread.sleep(5000);
            TakesScreenshot Sc2 = ((TakesScreenshot) driver);
            File SrcFile2 = Sc2.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(SrcFile2, new File("C:\\Users\\shres\\Desktop\\ScreenShots\\gmailpw1.png"));
            Thread.sleep(8000);
            driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span")).click();
            Thread.sleep(3000);
            TakesScreenshot Sc3 = ((TakesScreenshot) driver);
            File SrcFile3 = Sc3.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(SrcFile3, new File("C:\\Users\\shres\\Desktop\\ScreenShots\\gmailpage1.png"));
            Thread.sleep(8000);
        }
    @Test
    public void gmailInvalidScreenshots() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("qatesting00567@gmail.com");
        TakesScreenshot Sc1 = ((TakesScreenshot) driver);
        File SrcFile = Sc1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File("C:\\Users\\shres\\Desktop\\ScreenShots\\gmail1.png"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Test@123");
        Thread.sleep(5000);
        TakesScreenshot Sc2 = ((TakesScreenshot) driver);
        File SrcFile2 = Sc2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile2, new File("C:\\Users\\shres\\Desktop\\ScreenShots\\gmailpw1.png"));
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span")).click();
        Thread.sleep(3000);
        TakesScreenshot Sc3 = ((TakesScreenshot) driver);
        File SrcFile3 = Sc3.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile3, new File("C:\\Users\\shres\\Desktop\\ScreenShots\\gmailpage1.png"));
        Thread.sleep(8000);
    }

        @After
        public void end() {
            driver.quit();
        }
    }


