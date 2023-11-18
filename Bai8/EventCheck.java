package Bai8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class EventCheck {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //1. Truy cập "https://rise.fairsketch.com/events"

        driver.get("https://rise.fairsketch.com/events");

        //2. Login

//        String LOGIN = "//input[@placeholder='%s']";

//        String finalEmailXPath = String.format(LOGIN, "Email");
//        WebElement EmailField = driver.findElement(By.xpath(finalEmailXPath));
//        EmailField.click();
//        EmailField.sendKeys(Keys.COMMAND, "a");
//        EmailField.sendKeys(Keys.DELETE);
//        EmailField.sendKeys("admin@demo.com");
//
//        String finalPassWordXPath = String.format(LOGIN, "Password");
//        WebElement PWField = driver.findElement(By.xpath(finalPassWordXPath));
//        PWField.click();
//        PWField.sendKeys(Keys.COMMAND, "a");
//        PWField.sendKeys(Keys.DELETE);
//        PWField.sendKeys("riseDemo");


        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String loginXPath  ="//button[@type=\"submit\"]";
        WebElement loginEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginXPath)));
        loginEle.click();

        // Kiểm tra trạng thái đăng nhập thành công
        String avtXPath  = "//span[@class='user-name ml10']";
        WebElement avtEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginXPath)));
        avtEle.click();

        String logoutXPath  = "//a[contains(text(),' Sign Out')]";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoutXPath)));
        System.out.println("XPath of LogOut: " +logoutXPath);

        // 2. Truy cập tab events
        String eventsXPath  ="//span[text()='Events']";
        WebElement eventsEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(eventsXPath)));
        eventsEle.click();

        // 3. Kiểm tra tiêu đề [Event calendar] có được hiển thị không

        String tieudeXPath = "//h1[text()='Event calendar']";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tieudeXPath)));
        System.out.println("XPath of tieu de: " +tieudeXPath);

        // Tắt trình duyệt
        driver.quit();
    }
}
