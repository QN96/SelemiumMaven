package Bai4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.lang.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Bai4_1 {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/text-box");


        String DYNAMIC_LOCATOR_INPUT_TEXT_FORM = "//input[@placeholder='%s']";
        // Handle for "Full Name" field
        String finalFullNameXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "Full Name");
        System.out.println("XPath of First Name: " +finalFullNameXPath);
        driver.findElement(By.xpath(finalFullNameXPath)).sendKeys("Quynh Nhu");

        // Handle for "Email" field
        String finalEmailXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "name@example.com");
        System.out.println("XPath of First Name: " +finalEmailXPath);
        driver.findElement(By.xpath(finalEmailXPath)).sendKeys("abc@gmail.com");


        String DYNAMIC_INPUT = "//textarea[@id='%s']";
        //Handle for "Current Address field
        String currentAddressXpath = String.format(DYNAMIC_INPUT,"currentAddress");
        System.out.println("Xpath of Current Address is " + currentAddressXpath);
        driver.findElement(By.xpath(currentAddressXpath)).sendKeys("60 LTT");

        //Handle for Permanent Address field
        String permanentAddressXpath = String.format(DYNAMIC_INPUT,"permanentAddress");
        System.out.println("Xpath of Permanent Address is " + permanentAddressXpath);
        driver.findElement(By.xpath(permanentAddressXpath)).sendKeys("56 NTP");
    }
}
