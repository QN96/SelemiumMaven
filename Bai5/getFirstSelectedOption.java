package Bai5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.List;
public class getFirstSelectedOption {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("cars"));


        // Create a Select object
        Select select = new Select(dropdownElement);


        // Select an option from the dropdown (e.g., by visible text)
        select.selectByValue("volvo");
        select.selectByValue("audi");


        // Retrieve the first selected option
        WebElement firstSelectedOption = select.getFirstSelectedOption();


        // Print the text of the first selected option
        System.out.println("First Selected Option: " + firstSelectedOption.getText());
        // Close the browser
        //driver.quit();
    }
}

