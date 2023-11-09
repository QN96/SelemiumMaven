package Bai6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.*;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CheckBox {

    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        driver.get("https://demoqa.com/elements");

        driver.findElement(By.xpath("//span[text()='Check Box']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Expand all']")).click();

        String CheckBox = "//span[text()='%s']";

        //Commans
        String CommansXPath = String.format(CheckBox, "Commands");

        WebElement commansField = driver.findElement(By.xpath(CommansXPath));
        commansField.click();

        // Angular
        String AngularXPath = String.format(CheckBox, "Angular");

        WebElement AngularField = driver.findElement(By.xpath(AngularXPath));
        AngularField.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        // Private
        String PrivateXPath = String.format(CheckBox, "Private");

        WebElement PrivateField = driver.findElement(By.xpath(PrivateXPath));
        PrivateField.click();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");

        //Excel File.doc
        String FileXPath = String.format(CheckBox, "Excel File.doc");

        WebElement FileField = driver.findElement(By.xpath(FileXPath));
        FileField.click();

    }
}

