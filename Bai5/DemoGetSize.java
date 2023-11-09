package Bai5;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class DemoGetSize {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Find an element on the page using its CSS selector (or any other locator)
        WebElement element = driver.findElement(By.xpath("//h5[text()='Forms']"));


        // Use the getSize() method to get the element's size
        Dimension elementSize = element.getSize();


        // Print the retrieved dimensions
        System.out.println("Width: " + elementSize.getWidth());
        System.out.println("Height: " + elementSize.getHeight());


        // Close the browser
        driver.quit();
    }


}

