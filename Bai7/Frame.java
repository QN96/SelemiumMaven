package Bai7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.MessageFormat;
import java.lang.*;
import java.util.Set;
import static java.time.Duration.ofSeconds;

public class Frame {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        // Truy cập địa chỉ "https://demoqa.com/alertsWindows"
        driver.get("https://demoqa.com/alertsWindows");

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");


        // Click "Frames" tại thanh menu bar
        String FrameXPath = "//span[text()='Frames']";
        WebElement frameEle = driver.findElement(By.xpath(FrameXPath));
        frameEle.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");

        // Thuc hien tim kiem frame va verify
        String frameXPath = "//iframe[@id='frame1']";
        String frameID = "frame1";
        WebElement frameElement = driver.findElement(By.id(frameID));

        //region Frame verification
        String expFrameWidth= "500px";
        String actFrameWidth = frameElement.getAttribute("width");
        if(expFrameWidth.equals(actFrameWidth)){
            System.out.println(String.format("The width of frame: %s", actFrameWidth));
        } else {
            System.out.println(String.format("The width of frame is not same: actual: %s, expected: %s", actFrameWidth, expFrameWidth));
        }
        //endregion

        // Access to this frame
        driver.switchTo().frame(frameElement);
        String sampleHeadingID = "sampleHeading";
        WebElement sampleHeading = driver.findElement(By.id(sampleHeadingID));
        String actHeadingText = sampleHeading.getText();
        System.out.println("Current text: " + actHeadingText);

        //region Frame verification
        String expHeadingText = "This is a sample page";
        if(actHeadingText.equals(expHeadingText)){
            System.out.println(String.format("The frame text:  %s", actHeadingText));
        } else {
            System.out.println(String.format("The frame text is not same: actual: %s, expected: %s", actHeadingText, expHeadingText));
        }
        //endregion

        // Back to page contents
        driver.switchTo().defaultContent();

    }
}
