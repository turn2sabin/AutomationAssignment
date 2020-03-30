package AutomationAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Q6 {
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
    public void VerifyWomensMenu() throws InterruptedException {
        wd.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);

        WebElement slider = wd.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]"));
        Actions move= new Actions(wd);
        Thread.sleep(5000);
        for (int i = 1; i <=80 ; i=i+20) {
            Action action= (Action)move.dragAndDropBy(slider, i,0).build();
            action.perform();

        }
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) wd;

        WebElement a = wd.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]"));
        js.executeScript("window.scrollBy(0, 1500)");
        Assert.assertEquals(wd.findElement(By.id("layered_price_range")).getText(), "$53.00 - $53.00");

//        js.executeScript("arguments[0].setAttribute('style', 'left: 100%;')",a);
//
//        Thread.sleep(5000);
    }

    @After
    public void Exit() {
        wd.quit();
    }
}
