package AutomationAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q5 {
    WebDriver wd;

    @Before
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php?");
        wd.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test
    public void VerifyNewsletter() throws InterruptedException {
        wd.findElement(By.id("newsletter-input")).sendKeys("sabihdhdn");
        wd.findElement(By.name("submitNewsletter")).click();
        Thread.sleep(5000);
        String ActRes= wd.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText();
        System.out.println(ActRes);

        Thread.sleep(5000);
        String invalidEmail= "Newsletter : Invalid email address.";
        String validEmail= "Newsletter : You have successfully subscribed to this newsletter.";
        String AlreadyReg= "Newsletter : This email address is already registered.";
        if(ActRes.equals(validEmail)) {
            Assert.assertEquals(wd.findElement(By.cssSelector(".alert.alert-success")).getText(), "Newsletter : You have successfully subscribed to this newsletter.");
            // System.out.println("Pass");
        }
        else if(ActRes.equals(AlreadyReg)){
            Assert.assertEquals(wd.findElement(By.cssSelector(".alert.alert-success")).getText(), "Newsletter : This email address is already registered.");
        }
        else {
            Assert.assertEquals(wd.findElement(By.cssSelector(".alert.alert-danger")).getText(), "Newsletter : Invalid email address.");
            //System.out.println( "Fail");
        }

    }

    @After
    public void Exit() {
        wd.quit();
    }
}
