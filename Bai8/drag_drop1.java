package Bai8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class drag_drop1 {

    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang web
        driver.get("https://demoqa.com/droppable");

        // Chờ đến khi trang web được tải hoàn tất
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));

        // Lấy phần tử "Drag me" và "Drop here"
        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropHere = driver.findElement(By.id("droppable"));

        // Thực hiện kéo thả
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).perform();

        // Tạo alert bằng cách gọi executeScript với method alert()
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Drag and drop successfully');");

        // Chờ 1 giây để đảm bảo alert xuất hiện
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Xác nhận alert
        driver.switchTo().alert().accept();

        // Đóng trình duyệt
        driver.quit();
    }
}
