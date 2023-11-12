package Bai7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.ofSeconds;

public class shopper {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        // 1. Thực hiện truy cập "https://test.warface.codegym.vn"
        driver.get("https://test.warface.codegym.vn");

        // 2. Thực hiện mở 01 tab mới và truy cập trang "https://test.warface.codegym.vn/login"
        driver.switchTo().newWindow(WindowType.TAB);
        String newWindowHandle = driver.getWindowHandle();
        driver.get("https://test.warface.codegym.vn/login");

        // 3. Đăng nhập
        driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();

        // 4. Quay về tab đầu tiên và thực hiện refresh trang này. Sau đó đóng tab đăng nhập
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        driver.navigate().refresh();

        driver.switchTo().window(newWindowHandle);
        driver.close();

        // 5. Quay lại tab đầu tiên
        driver.switchTo().window(driver.getWindowHandles().iterator().next());

        // 6. Tìm và click vào danh mục "Điện thoại"
        WebElement dienThoaiCategory = driver.findElement(By.xpath("//a[contains(text(), 'Điện thoại')]"));
        dienThoaiCategory.click();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,750)", "");

        // 7. Tìm và click vào 2 mặt hàng đầu tiên trong danh mục
        // Thêm sp 1
        driver.findElement(By.xpath("(//a[text()='Mua hàng'])[1]")).click();


        // Thêm sp 2
        driver.findElement(By.xpath("(//a[text()='Mua hàng'])[2]")).click();

        Thread.sleep(5000);

        // Vào giỏ hàng
        driver.findElement(By.xpath("(//a[contains(@href, 'cart')])[1]")).click();
    }
}
