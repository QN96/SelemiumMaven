package Bai5;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class DemoTakeScreenshot {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Find an element on the page using its CSS selector (or any other locator)
        WebElement element = driver.findElement(By.xpath("//h5[text()='Forms']"));


        // Take a screenshot of the element
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        try {
            // Use FileUtils to save the screenshot to a file
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }


}

