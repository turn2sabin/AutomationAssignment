package AutomationAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q4 {
        WebDriver wd;
        @Before
        public void setup() {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            //Create ChromeDriver instance
            wd = new ChromeDriver();
            wd.get("http://automationpractice.com/index.php?");
            wd.manage().window().maximize();
        }
        @Test
        public void VerifyFooter() {
            List<String> expfooter = new ArrayList<String>
                    (Arrays.asList("My orders", "My credit slips", "My addresses", "My personal info"));

            List<WebElement> list= wd.findElements(By.xpath("//*[@id=\"footer\"]/div/section[5]/div/ul/li/a")); //no of rows in a table
            List<String> footer = new ArrayList<>();
            int noRows = list.size();
            for (int i = 1; i<= noRows; i++)
            {
                WebElement name= wd.findElement(By.xpath("//*[@id=\"footer\"]/div/section[5]/div/ul/li["+i+"]/a"));
                footer.add(name.getText());
            }
            Assert.assertEquals(footer,expfooter);

        }
        @After
        public void exit ()
        { wd.quit();}
}
