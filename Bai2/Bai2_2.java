package Bai2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.lang.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Bai2_2 {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");

        //xpath

        driver.findElement(By.id("firstName")).sendKeys("Nhu");
        driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("quynh");
        driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]")).sendKeys("quynh@gmail.com");
        driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
        driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]")).click();

        String DYNAMIC_INPUT_NAME_VALUE_FORM = "//input[@name='%s' and @value='%s']/following-sibling::label";
        String maleXPath = String.format(DYNAMIC_INPUT_NAME_VALUE_FORM, "gender","Male");
        Boolean isSelected = driver.findElement(By.xpath(maleXPath)).isSelected();
        if (isSelected == false) {
            driver.findElement(By.xpath(maleXPath)).click();
        }

        driver.findElement(By.xpath("//div[@id=\"state\"]")).click();

        //css

        //driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys("Phan");
        //driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Nguyen");
        //driver.findElement(By.cssSelector("textarea[placeholder='Current Address']")).sendKeys("Nguyen Van Linh");

        //driver.findElement(By.partialLinkText ("Ho")).click();

        //2.Handle DatePicker
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        //Press Ctrl-A
        String s = Keys.chord(Keys.COMMAND, "a");
        datePicker.sendKeys(s);
        //Fill Date
        datePicker.sendKeys("10 Oct 1984");
        //Press Enter to exit DatePicker
        datePicker.sendKeys(Keys.ENTER);

        //3.Handle Subjects dropdown editable
        WebElement dropdown=driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        dropdown.click();
        Thread.sleep(20);
        WebElement dropdown1=driver.findElement(By.id("subjectsInput"));
        dropdown1.sendKeys("Chemistry");
        dropdown1.sendKeys(Keys.ENTER);

        //5.Handle Upload file
        //driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("/Users/mac/Documents/Auto test/Selemium/SelemiumMaven/src/main/resources/TestDataFile/file1.jpeg");
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(System.getProperty("user.dir") + "/src/main/resources/TestDataFile/file1.jpeg");
    }
}

