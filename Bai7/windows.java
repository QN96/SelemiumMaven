package Bai7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.MessageFormat;
import java.lang.*;
import java.util.Set;
import static java.time.Duration.ofSeconds;

public class windows {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        driver.get("https://demoqa.com/alertsWindows");
        // Click "Browser Windows"
        String browserWinXPath = "//span[text()='Browser Windows']";
        WebElement browserWinEle = driver.findElement(By.xpath(browserWinXPath));
        browserWinEle.click();
        // Get current windows
        String currentWin = driver.getWindowHandle();
        System.out.println("Current window: " + currentWin);

        // Thực hiện click vào từng button (03 buttons)
        // 1. New tab button
        WebElement newTabEle = driver.findElement(By.id("tabButton"));
        newTabEle.click();

        Set<String> windowList = driver.getWindowHandles();
        System.out.println(MessageFormat.format("The total windows: {0}", windowList.size()));


       // Switch qua cửa sổ mới
        for (String win : windowList) {
            if (!win.equals(currentWin)){
                driver.switchTo().window(win);
            }
        }

        System.out.println("New window: " + driver.getWindowHandle());
        WebElement textWindow2Ele = driver.findElement(By.id("sampleHeading"));
        String textValue = textWindow2Ele.getText();
        if (textValue.equals("This is a sample page"))
            System.out.println("Verify the window text : successfully - " + textValue);

        // Back về trang chủ tại bước 2 (Sử dụng phương thức get window đầu tiên và switchTo)
        driver.switchTo().window(currentWin);

        // 2. New window button

        WebElement newWindowEle = driver.findElement(By.id("windowButton"));
        newTabEle.click();

        Set<String> newWindowList = driver.getWindowHandles();
        System.out.println(MessageFormat.format("The total windows: {0}", newWindowList.size()));


        // Switch qua cửa sổ mới
        for (String win : newWindowList) {
            if (!win.equals(currentWin)){
                driver.switchTo().window(win);
            }
        }

        System.out.println("New window: " + driver.getWindowHandle());
        WebElement textWindow3Ele = driver.findElement(By.id("sampleHeading"));
        String textValue3 = textWindow3Ele.getText();
        if (textValue3.equals("This is a sample page"))
            System.out.println("Verify the window text : successfully - " + textValue3);

        // Back về trang chủ tại bước 2 (Sử dụng phương thức get window đầu tiên và switchTo)
        driver.switchTo().window(currentWin);

        // 3. New window message

        WebElement MessEle = driver.findElement(By.id("messageWindowButton"));
        newTabEle.click();

        Set<String> MessList = driver.getWindowHandles();
        System.out.println(MessageFormat.format("The total windows: {0}", MessList.size()));


        // Switch qua cửa sổ mới
        for (String win : newWindowList) {
            if (!win.equals(currentWin)){
                driver.switchTo().window(win);
            }
        }

        System.out.println("New window: " + driver.getWindowHandle());
        WebElement textWindow4Ele = driver.findElement(By.id("sampleHeading"));
        String textValue4 = textWindow3Ele.getText();
        if (textValue3.equals("This is a sample page"))
            System.out.println("Verify the window text : successfully - " + textValue4);

        // Back về trang chủ tại bước 2 (Sử dụng phương thức get window đầu tiên và switchTo)
        driver.switchTo().window(currentWin);

    }
}

