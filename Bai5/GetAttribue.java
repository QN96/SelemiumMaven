package Bai5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class GetAttribue {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Locate the input field by its ID
        WebElement firstNameInput = driver.findElement(By.id("firstName"));


        // Get the "placeholder" attribute value
        String placeholderValue = firstNameInput.getAttribute("placeholder");

        // Print the attribute value
        System.out.println("Placeholder attribute value: " + placeholderValue);

        driver.quit();
    }
}