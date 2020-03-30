package AutomationAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q3 {

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
        public void VerifyEmptyCart() throws InterruptedException {
            wd.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b")).click();
            Thread.sleep(5000);

            String ActResult= wd.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
            String ExpResult= "Your shopping cart is empty.";
            Thread.sleep(8000);
            Assert.assertTrue(ActResult, ActResult.equals(ExpResult));
        }

        @After
        public void Exit() {
            wd.quit();
        }

    }


