package AutomationAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2 {
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
    public void VerifySaree() throws InterruptedException {
        wd.findElement(By.id("search_query_top")).sendKeys("Saree");
        wd.findElement(By.name("submit_search")).click();
        String expResult="0 results have been found.";

        String ActResult= wd.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span")).getText();
        System.out.println(ActResult);
        Thread.sleep(8000);
        Assert.assertTrue(ActResult, ActResult.equals(expResult));
    }

    @After
    public void Exit() {
        wd.quit();
    }

}
