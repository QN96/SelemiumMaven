package Bai5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DemoEqualMethod {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        // Locate two elements you want to compare
        WebElement element1 = driver.findElement(By.xpath("//h5[text()='Forms']"));
        WebElement element2 = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));

        // So sánh số lượng ký tự 2 xpath
        boolean areEqual = element1.equals(element2);
        System.out.println("The elements of element 1 is "+element1);
        System.out.println("The elements of element 2 is "+element2);
        if (areEqual) {
            System.out.println("The elements are equal.");
        } else {
            System.out.println("The elements are not equal.");
        }

        driver.quit();
    }
}

