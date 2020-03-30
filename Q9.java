package AutomationAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q9 {
    WebDriver driver;
    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @Test
    public void Cartfunctionality () throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[2]/h5/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".span_link.no-print")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).click();
        for (int i =2; i<= 3; i++){
            driver.findElement(By.cssSelector( ".btn.btn-default.button-plus.product_quantity_up")).click();
            Thread.sleep(3000);
        }
        driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        Thread.sleep(2000);
        String actualmsg = driver.findElement(By.id("layer_cart_product_attributes")).getText();
        String expectedmsg = "Yellow, L";
        Assert.assertEquals(expectedmsg,actualmsg);
        String actualmsg1 = driver.findElement(By.id("layer_cart_product_quantity")).getText();
        String expectedmsg1 = "3";
        Assert.assertEquals(expectedmsg1,actualmsg1);
        String actualmsg2 = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/span")).getText();
        String expectedmsg2 = "$51.20";
        Assert.assertEquals(expectedmsg2,actualmsg2);

    }
    @After
    public void end(){
        driver.quit();
    }
}