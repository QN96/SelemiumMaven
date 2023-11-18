package Bai8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.*;
import java.util.concurrent.TimeUnit;


public class THJavaScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //1. Truy cập "https://demoqa.com/text-box"

        driver.get("https://demoqa.com/text-box");

        // 1. Khởi tạo JavaScript
        JavascriptExecutor javaScripts = (JavascriptExecutor) driver;

        // 2. Tương tác với phần tử thông qua executeScript

        String DYNAMIC_INPUT_PLACEHOLDER_FORM = "//input[@placeholder='%s']";

        // Send Key Full Name
        String fullNameXPath = String.format(DYNAMIC_INPUT_PLACEHOLDER_FORM, "Full Name");
        WebElement fullNameEle = driver.findElement(By.xpath(fullNameXPath));
        javaScripts.executeScript("arguments[0].value = 'Vincent';", fullNameEle);
        String text = (String) javaScripts.executeScript("return arguments[0].value;", fullNameEle);
        System.out.println("Full Name: " + text);


        // Send Key Full Name
        String emailXPath = String.format(DYNAMIC_INPUT_PLACEHOLDER_FORM, "name@example.com");
        WebElement emailEle = driver.findElement(By.xpath(emailXPath));
        javaScripts.executeScript("arguments[0].value = 'vincent@gmail.com';", emailEle);
        String email = (String) javaScripts.executeScript("return arguments[0].value;", emailEle);
        System.out.println("Email : " + email);


        String DYNAMIC_TEXTAREA_ID_FORM = "//textarea[@id='%s']";

        // Input current address
        String currentXPath = String.format(DYNAMIC_TEXTAREA_ID_FORM, "currentAddress");
        WebElement currentEle = driver.findElement(By.xpath(currentXPath));
        javaScripts.executeScript("arguments[0].value = 'KĐT Nam Trung Yên, P. Yên Hòa, Q. Cầu Giấy, TP Hà Nội';", currentEle);
        String currentAdd = (String) javaScripts.executeScript("return arguments[0].value;", currentEle);
        System.out.println("Current Address : " + currentAdd);

        // Input Permanent address
        String permanentXPath = String.format(DYNAMIC_TEXTAREA_ID_FORM, "permanentAddress");
        WebElement permanentEle = driver.findElement(By.xpath(permanentXPath));
        javaScripts.executeScript("arguments[0].value = 'Q. Cầu Giấy, TP Hà Nội';", permanentEle);
        String permanent = (String) javaScripts.executeScript("return arguments[0].value;", permanentEle);
        System.out.println("Permanent Address : " + permanent);

        // Click to Submit
        String buttonXPath = "//button[@id='submit']";
        WebElement submitEle = driver.findElement(By.xpath(buttonXPath));
        javaScripts.executeScript("arguments[0].click()", submitEle);

    }
}

