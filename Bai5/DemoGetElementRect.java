package Bai5;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoGetElementRect {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Find an element on the page using its CSS selector (or any other locator)
        WebElement element = driver.findElement(By.xpath("//h5[text()='Forms']"));


        // Use the getRect() method to get the element's dimensions and position
        Rectangle rect = element.getRect();


        // Print the retrieved dimensions and position
        System.out.println("X Coordinate: " + rect.getX());
        System.out.println("Y Coordinate: " + rect.getY());
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Height: " + rect.getHeight());


        // Close the browser
        driver.quit();
    }


}

