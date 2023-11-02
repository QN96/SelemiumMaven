package Bai4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.lang.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Bai4_2 {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");


        String DYNAMIC_LOCATOR_INPUT_TEXT_FORM = "//input[@placeholder='%s']";

        // Handle for "First Name" field
        String finalFirstNameXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "First Name");
        System.out.println("XPath of First Name: " +finalFirstNameXPath);
        driver.findElement(By.xpath(finalFirstNameXPath)).sendKeys("Quynh");

        // Handle for "Last Name" field
        String finalLastNameXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "Last Name");
        System.out.println("XPath of Last Name: " +finalLastNameXPath);
        driver.findElement(By.xpath(finalLastNameXPath)).sendKeys("Nhu");

        // Handle for "Email" field
        String finalEmailXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "name@example.com");
        System.out.println("XPath of Email: " +finalEmailXPath);
        driver.findElement(By.xpath(finalEmailXPath)).sendKeys("abc@gmail.com");

        // Handle for "Mobile number" field
        String finalMobileXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "Mobile Number");
        System.out.println("XPath of Mobile number: " +finalMobileXPath);
        driver.findElement(By.xpath(finalMobileXPath)).sendKeys("0982730999");


        String DYNAMIC_INPUT = "//textarea[@id='%s']";
        //Handle for "Current Address field
        String currentAddressXpath = String.format(DYNAMIC_INPUT,"currentAddress");
        System.out.println("Xpath of Current Address: " + currentAddressXpath);
        driver.findElement(By.xpath(currentAddressXpath)).sendKeys("123 PT");

    }
}
