package Bai2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
public class Bai2_2 {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");

        //xpath

        //driver.findElement(By.id("firstName")).sendKeys("Nhu");
        //driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("quynh@gmail.com");
        //driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]")).sendKeys("quynh@gmail.com");
        //driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
        //driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]")).click();
        driver.findElement(By.xpath("//div[@id=\"state\"]")).click();
        //div[@id="city"]

        //css

        //driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys("Phan");
        //driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Nguyen");
        //driver.findElement(By.cssSelector("textarea[placeholder='Current Address']")).sendKeys("Nguyen Van Linh");


        //driver.findElement(By.partialLinkText ("Ho")).click();

    }
}
