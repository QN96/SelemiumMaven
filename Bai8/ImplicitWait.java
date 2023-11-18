package Bai8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ImplicitWait {
    public static void main(String[] args) {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/links truc tiep
//        driver.get("https://demoqa.com/links/");

        //Mở tran thông qua navigator
        driver.navigate().to("https://demoqa.com/links/");

        //Click Home link
        driver.findElement(By.linkText ("Home")).click();

//        //Click Home link use partialLinkText
//        driver.findElement(By.partialLinkText ("me")).click();

        //Tắt browser
        //driver.quit();


    }
}