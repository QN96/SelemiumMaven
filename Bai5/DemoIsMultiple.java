package Bai5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DemoIsMultiple {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("cars"));

        // Create a Select object
        Select select = new Select(dropdownElement);


        // Check if the dropdown is multi-select or single-select
        boolean isMultiSelect = select.isMultiple();


        if (isMultiSelect) {
            System.out.println("Dropdown is multi-select.");
        } else {
            System.out.println("Dropdown is single-select.");
        }

        WebElement dropdown1Element = driver.findElement(By.id("oldSelectMenu"));

        // Create a Select object
        Select select1 = new Select(dropdown1Element);


        // Check if the dropdown is multi-select or single-select
        boolean isMultiSelect1 = select1.isMultiple();


        if (isMultiSelect1) {
            System.out.println("Old Style Select Menu Dropdown is multi-select.");
        } else {
            System.out.println("Standard multi select Dropdown is single-select.");
        }

        // Close the browser
        //driver.quit();
    }
}
