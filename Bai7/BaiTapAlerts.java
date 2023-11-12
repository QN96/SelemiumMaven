package Bai7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class BaiTapAlerts {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        // 1. Thực hiện truy cập "https://test.warface.codegym.vn"
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        // 2. Nhập thông tin cho Customer ID "Vincent"
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("Vincent");

        // 3. Click [Submit] button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // 4. Thực hiện kiểm tra xem thông báo trả ra là "Do you really want to delete this Customer?"
        Alert alert = driver.switchTo().alert();
        String alertText  = alert.getText();
        System.out.println("Text : " + alertText);


        // 5. Thực hiện action Cancel
        Thread.sleep(1000);
        alert.dismiss();

        // 6,7. Click đăng nhập
        //Thực hiện lặp lại bước 2,3,4
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // 8. Thực hiện action OK
        Thread.sleep(1000);
        alert.accept();

        Alert alert1 = driver.switchTo().alert();
        String alert1Text  = alert1.getText();
        System.out.println("Text : " + alert1Text);

    }
}