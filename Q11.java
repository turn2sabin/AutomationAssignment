package AutomationAssignment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Q11 {
        WebDriver driver;

        @Before
        public void setup() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.demoqa.com/automation-practice-form/");
            driver.manage().window().maximize();
            Thread.sleep(2000);
        }

        @Test
        public void toolssqa() throws InterruptedException {
            WebElement actualmsg = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/fieldset/div[2]/a/strong"));
            String expectedmsg = "Partial Link Test";
            Assert.assertEquals(actualmsg.getText() , expectedmsg);
            String Partiallink = driver.findElement(By.linkText("Partial Link Test")).getAttribute("href");
            System.out.println(Partiallink);
            Thread.sleep(2000);

            WebElement actualmsg1= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/fieldset/div[5]/a/strong"));
            String expectedmsg1 = "Link Test";
            Assert.assertEquals(actualmsg1.getText(),expectedmsg1);
            String LinkTest = driver.findElement(By.linkText("Link Test")).getAttribute("href");
            System.out.println(LinkTest);
            Thread.sleep(3000);
        }

        @Test
        public void FLName () throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/fieldset/div[8]/input")).sendKeys("Prizma");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Gautam");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"sex-1\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("exp-4")).click();
            Thread.sleep(2000);
            DateTimeFormatter currentdate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate currenttime = LocalDate.now();
            driver.findElement(By.id("datepicker")).sendKeys(currentdate.format(currenttime));
            System.out.println(currentdate.format(currenttime));
            Thread.sleep(5000);
            driver.findElement(By.id("profession-0")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("profession-1")).click();
            Thread.sleep(2000);
        }

        @Test
        public void downloadLinks() throws InterruptedException {
            String expectedlink = "http://toolsqa.com/wp-content/uploads/2014/04/OnlineStore.zip";
            String acutallink = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/fieldset/div[25]/a")).getAttribute("href");
            Thread.sleep(2000);
            Assert.assertEquals(expectedlink,acutallink);
            System.out.println(acutallink);
            Thread.sleep(5000);
            String expectedlink1 = "http://toolsqa.com/wp-content/uploads/2016/09/Test-File-to-Download.xlsx";
            String actuallink1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/fieldset/div[26]/a")).getAttribute("href");
            Thread.sleep(2000);
            Assert.assertEquals(expectedlink1,actuallink1);
            System.out.println(actuallink1);
            Thread.sleep(5000);
        }

        @Test
        public void automationtool () throws InterruptedException {
            driver.findElement(By.id("tool-0")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("tool-1")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"continents\"]/option[6]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"continentsmultiple\"]/option[2]")).click();
            Thread.sleep(2000);
        }

        @Test
        public void continents () throws InterruptedException {
            List<String> ActCont = new ArrayList<>();
            WebElement Opt1= driver.findElement(By.xpath("//*[@id=\"continentsmultiple\"]/option[2]"));
            Thread.sleep(2000);
            ActCont.add(Opt1.getText());
            Opt1.click();
            WebElement slider =  driver.findElement(By.xpath("//*[@id=\"continentsmultiple\"]"));
            Actions move= new Actions(driver);
            for (int i = 1; i <=80 ; i=i+20) {
                Action action= (Action)move.dragAndDropBy(slider, i,0).build();
                action.perform();

            }
            Thread.sleep(3000);

            WebElement Opt2= driver.findElement(By.xpath("//*[@id=\"continentsmultiple\"]/option[6]"));
            ActCont.add(Opt2.getText());
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.LEFT_CONTROL)
                    .click(Opt2)
                    .keyUp(Keys.LEFT_CONTROL)
                    .build()
                    .perform();
            List<String> expCont = new ArrayList<String>
                    (Arrays.asList("Europe", "North America"));

            Assert.assertEquals(expCont, ActCont);
        }

   @Test
    public void SeCommands() throws InterruptedException {

       List<String> expCommands = new ArrayList<String>
               (Arrays.asList("Browser Commands", "Navigation Commands", "Switch Commands", "Wait Commands", "WebElement Commands"));
       List<WebElement> list= driver.findElements(By.xpath("//*[@id=\"selenium_commands\"]/option")); //no of rows in a table
       List<String> ActCommands = new ArrayList<>();
       int noRows = list.size();
       for (int i = 1; i<= noRows; i++)
       {
           WebElement name= driver.findElement(By.xpath("//*[@id=\"selenium_commands\"]/option["+i+"]"));
           ActCommands.add(name.getText());
       }
       Assert.assertEquals(ActCommands,expCommands);

   }

        @Test
        public void verifyButtons () throws InterruptedException {
            String act1 = driver.findElement(By.id("submit")).getText();
            String exp1 = "Button";
            Assert.assertEquals(exp1,act1);
            Thread.sleep(1000);
            String act2 = driver.findElement(By.id("submit1")).getText();
            String exp2 = "Button 2";
            Assert.assertEquals(exp2,act2);
            Thread.sleep(1000);
            String act3 = driver.findElement(By.id("submit2")).getText();
            String exp3 = "Button 3";
            Assert.assertEquals(exp3,act3);
            Thread.sleep(1000);
            String act4 = driver.findElement(By.id("submit3")).getText();
            String exp4 = "Button 4";
            Assert.assertEquals(exp4,act4);
            Thread.sleep(1000);
            driver.findElement(By.id("submit2")).click();
            Thread.sleep(2000);
        }

        @Test
        public void drinklist () throws InterruptedException {
            JavascriptExecutor JS = (JavascriptExecutor) driver;
            JS.executeScript("window.scrollBy(0,1500)");
            Thread.sleep(3000);
            List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"beverages\"]/li"));
            int linkCount = list.size();
        }

        @After
        public void end(){
            driver.quit();
        }
    }


