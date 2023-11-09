package Bai5;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
public class DemoGetLocation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate the element you want to get the location of
        WebElement firstNameInput = driver.findElement(By.id("firstName"));


        // Use the getLocation() method to get the location
        Point elementLocation = firstNameInput.getLocation();


        // Retrieve the x and y coordinates (lấy tọa độ)
        int x = elementLocation.getX();
        int y = elementLocation.getY();


        // Print the coordinates to the console
        System.out.println("X Coordinate: " + x);
        System.out.println("Y Coordinate: " + y);

        driver.quit();
    }
}

