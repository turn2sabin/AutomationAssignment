package AutomationAssignment;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Q14 {
    WebDriver wd;
    FileInputStream inputStream;
    Workbook workbook; //Source.xlsx
    Sheet employeeSheet;

    @Before
    public void setup() throws IOException, InterruptedException {
        String fileName = "Sources.xlsx";
//user.dir gives the root folder, here Automation_java
//
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources";
        File file = new File(filePath + "\\" + fileName);
//Create an object of FileInputStream class to read excel file
        inputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(inputStream);
        employeeSheet = workbook.getSheet("Sheet1"); //sheetname
        String site = employeeSheet.getRow(0).getCell(1).getStringCellValue();
        System.out.println(site);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//Create ChromeDriver instance
        wd = new ChromeDriver();
        wd.get(site);
        wd.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test
    public void readexel() throws InterruptedException {
        String email = employeeSheet.getRow(1).getCell(1).getStringCellValue();
        String password = employeeSheet.getRow(2).getCell(1).getStringCellValue();
        WebElement emailElement = wd.findElement(By.name("identifier"));
        emailElement.sendKeys(email);
        WebElement nextButtonElement = wd.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
        nextButtonElement.click();
        Thread.sleep(6000);
        WebElement Pwd = wd.findElement(By.name("password"));
        Pwd.sendKeys(password);
        WebElement btnNext = wd.findElement(By.id("passwordNext"));
        btnNext.click();
        Thread.sleep(3000);
    }

    @After
    public void end() {
        wd.quit();
    }
}


