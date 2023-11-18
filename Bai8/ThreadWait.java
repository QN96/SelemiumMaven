package Bai8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.*;

public class ThreadWait {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(20);

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");

        //3.Handle Subjects dropdown editable
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        dropdown.click();
        Thread.sleep(20);
        WebElement dropdown1 = driver.findElement(By.id("subjectsInput"));
        dropdown1.sendKeys("Chemistry");
        dropdown1.sendKeys(Keys.ENTER);
    }
}