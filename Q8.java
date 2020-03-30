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

public class Q8 {
//    Verify Add to Cart Works
//    Select the 3rd listed product from index page and add to cart. Verify after
//    adding to the card, The status of the cart on top right corner changes from
//    empty to 1.

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
    public void VerifyAddToCart() throws InterruptedException {
   WebElement dress= wd.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[1]/div/a[1]/img"));
        Actions builder = new Actions(wd);
        builder.moveToElement(dress).perform();

    wd.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]/span")).click();
    Thread.sleep(2000);
    wd.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
    String actualMessage= wd.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText();
    String expectedMessage= "1";
    Assert.assertEquals(actualMessage, expectedMessage);

    }

    @After
    public void Exit() {
        wd.quit();
    }
}
