package AutomationAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

    public class Q12 {
        WebDriver driver;
        @Before
        public void setup() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://demo.guru99.com/test/drag_drop.html");
            driver.manage().window().maximize();
            Thread.sleep(2000);
        }
        @Test
        public void VerifyDragAndDrop () throws InterruptedException {
            WebElement drag =  driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
            WebElement drop = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
            Actions act = new Actions(driver);
            act.dragAndDrop(drag, drop).build().perform();
            Thread.sleep(5000);
            Assert.assertEquals("0", driver.findElement(By.id("t7")).getText());
            Assert.assertEquals("0", driver.findElement(By.id("t8")).getText());
            driver.navigate().refresh();

            WebElement drag1 =  driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
            WebElement drop1 = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
            Actions act1 = new Actions(driver);
            act.dragAndDrop(drag1, drop1).build().perform();
            Thread.sleep(5000);
            Assert.assertEquals("5000", driver.findElement(By.id("t7")).getText());
            Assert.assertEquals("0", driver.findElement(By.id("t8")).getText());
            driver.navigate().refresh();

            WebElement drag2 =  driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
            WebElement drop2 = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
            Actions act2 = new Actions(driver);
            act.dragAndDrop(drag2, drop2).build().perform();
            Thread.sleep(5000);
            Assert.assertEquals("0", driver.findElement(By.id("t7")).getText());
            Assert.assertEquals("0", driver.findElement(By.id("t8")).getText());
            driver.navigate().refresh();

            WebElement drag3 =  driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
            WebElement drop3 = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
            Actions act3 = new Actions(driver);
            act.dragAndDrop(drag3, drop3).build().perform();
            Thread.sleep(5000);
            Assert.assertEquals("0", driver.findElement(By.id("t7")).getText());
            Assert.assertEquals("5000", driver.findElement(By.id("t8")).getText());
            driver.navigate().refresh();
        }
        @After
        public void end() {
            driver.quit();
        }
    }

