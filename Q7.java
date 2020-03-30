package AutomationAssignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q7 {
//    Click on Dresses
//    Change the view type to List from Grid
//    Click on the 4th Image of the Gallery
//    Again click to see the view the Larger Picture Gallery
//    Click next to see scroll all the images
//    Finally close the image clicking on close button
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
    public void VerifyImage() throws InterruptedException {

        wd.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        wd.findElement(By.cssSelector(".icon-th-list")).click();
        Thread.sleep(4000);

        wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div/div[2]/h5/a")).click();
        //clicks on the dress
        Thread.sleep(5000);
        wd.findElement(By.id("bigpic")).click();
        Thread.sleep(2000);


        for (int i = 1; i < 4; i++) {
            wd.findElement(By.cssSelector(".fancybox-nav.fancybox-next")).click();
            Thread.sleep(4000);
        }
    }

    @After
    public void Exit() {
        wd.quit();
    }
}
