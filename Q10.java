package AutomationAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Q10 {
    WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @Test
    public void alertbox () throws InterruptedException {
        driver.findElement(By.id("cookie_action_close_header")).click(); //click accept on cookies message
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click(); //click on simple atert button
        Thread.sleep(3000);
        String expectedmsg = "A simple Alert";
        String actualmsg= driver.switchTo().alert().getText();
        Assert.assertEquals(actualmsg,expectedmsg);

        Thread.sleep(2000);
        driver.switchTo().alert().accept(); //click on okay button
        driver.findElement(By.xpath("//*[@id=\"content\"]/p[7]/button")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/p[10]/button")).click();
        Thread.sleep(2000);
        String expectedmsg1 = "Do you like toolsqa?";
        String actualmsg1= driver.switchTo().alert().getText();
        Assert.assertEquals(actualmsg1,expectedmsg1);
        Thread.sleep(2000);
    }

    @After
    public void end(){
        driver.quit();
    }
}

