package Bai5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;


public class DemoGetCssValue {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Find an element on the page using its CSS selector
        WebElement element = driver.findElement(By.cssSelector("#app > div > div > div > a"));


        // Use the getCssValue method to retrieve the value of a specific CSS property
        String color = element.getCssValue("color");


        // Print the retrieved CSS property value
        System.out.println("Text color: " + color);


        // Use the getCssValue method to retrieve the value of a specific CSS property
        String backgroundColor = element.getCssValue("background-color");


        // Print the retrieved CSS property value
        System.out.println("Background Color color: " + backgroundColor);

        // Close the browser
        driver.quit();


    }


}

