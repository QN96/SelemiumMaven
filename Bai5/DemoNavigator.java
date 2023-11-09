package Bai5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class DemoNavigator {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Open a new tab and switch to it
        driver.switchTo().newWindow(WindowType.TAB);


        // Navigate to a different web page in the new tab
        driver.get("https://example2.com");


        // Close the new tab
        driver.close();


        // Switch back to the original tab
        driver.switchTo().window(driver.getWindowHandles().iterator().next());


        // Close the browser
        //driver.quit();
    }


}

