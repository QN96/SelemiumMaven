package Bai5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Locate the input field by its ID
        WebElement firstNameInput = driver.findElement(By.id("firstName"));

        // Get the "class" attribute value
        String classValue = firstNameInput.getAttribute("class");

        // Print the attribute value
        System.out.println("Class value: " + classValue);

        // Get the "class" attribute value
        String typeValue = firstNameInput.getAttribute("type");

        // Print the attribute value
        System.out.println("Type value: " + typeValue);

        //Returns the object of type Class that represents the runtime class of the object
        String classValue1 = firstNameInput.getClass().toString();
        System.out.println("Class value: " + classValue1);

        driver.quit();
    }
}

