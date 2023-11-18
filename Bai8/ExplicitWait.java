package Bai8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.lang.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //1. Truy cập "https://demoqa.com/"
        //Kiểm tra title của page có chính xác không, và wait cho tới khi page xong để kiểm tra [Forms] đã hiện hay chưa

        driver.get("https://demoqa.com/");

        // 2. Wait for the logo shown
        String logoXPath = "//img[@src='/images/Toolsqa.jpg']";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoXPath)));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");


        // 3. Click [Forms]
        String formXPath  ="//h5[text()='Forms']";
        WebElement formEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(formXPath)));
        formEle.click();

        // 4. Click [Practice Form].
        String practiceFormXPath ="//span[text()='Practice Form']";
        WebElement practiceEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(practiceFormXPath)));
        practiceEle.click();

        String DYNAMIC_LOCATOR_INPUT_TEXT_FORM = "//input[@placeholder='%s']";

        // Handle for "First Name" field
        String finalFirstNameXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "First Name");
        System.out.println("XPath of First Name: " +finalFirstNameXPath);
        driver.findElement(By.xpath(finalFirstNameXPath)).sendKeys("Quynh");

        // Handle for "Last Name" field
        String finalLastNameXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "Last Name");
        System.out.println("XPath of Last Name: " +finalLastNameXPath);
        driver.findElement(By.xpath(finalLastNameXPath)).sendKeys("Nhu");

        // Handle for "Email" field
        String finalEmailXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "name@example.com");
        System.out.println("XPath of Email: " +finalEmailXPath);
        driver.findElement(By.xpath(finalEmailXPath)).sendKeys("abc@gmail.com");

        // Gender
        String DYNAMIC_INPUT_NAME_VALUE_FORM = "//input[@name='%s' and @value='%s']/following-sibling::label";
        String maleXPath = String.format(DYNAMIC_INPUT_NAME_VALUE_FORM, "gender","Male");
        Boolean isSelected = driver.findElement(By.xpath(maleXPath)).isSelected();
        if (isSelected == false) {
            driver.findElement(By.xpath(maleXPath)).click();
        }

        // Handle for "Mobile number" field
        String finalMobileXPath = String.format(DYNAMIC_LOCATOR_INPUT_TEXT_FORM, "Mobile Number");
        System.out.println("XPath of Mobile number: " +finalMobileXPath);
        driver.findElement(By.xpath(finalMobileXPath)).sendKeys("0982730999");

        // Date of Birth
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        //Press Ctrl-A
        String s = Keys.chord(Keys.COMMAND, "a");
        datePicker.sendKeys(s);
        //Fill Date
        datePicker.sendKeys("19 Nov 1996");
        //Press Enter to exit DatePicker
        datePicker.sendKeys(Keys.ENTER);

        // Subjects dropdown editable
        WebElement dropdown=driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");
        dropdown.click();
        Thread.sleep(20);
        WebElement dropdown1=driver.findElement(By.id("subjectsInput"));
        dropdown1.sendKeys("Chemistry");
        dropdown1.sendKeys(Keys.ENTER);

        // Hobbies
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();

        //5.Handle Upload file
        //driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("/Users/mac/Documents/Auto test/Selemium/SelemiumMaven/src/main/resources/TestDataFile/file1.jpeg");
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(System.getProperty("user.dir") + "/src/main/resources/TestDataFile/file1.jpeg");

        String DYNAMIC_INPUT = "//textarea[@id='%s']";
        //Handle for "Current Address field
        String currentAddressXpath = String.format(DYNAMIC_INPUT,"currentAddress");
        System.out.println("Xpath of Current Address: " + currentAddressXpath);
        driver.findElement(By.xpath(currentAddressXpath)).sendKeys("123 PT");

        // State
        String DROPDOWN1 = "//div[@class='%s']";
        String StateXPath = String.format(DROPDOWN1, "css-1uccc91-singleValue");

        // Mở dropdown
        WebElement StateField = driver.findElement(By.xpath(StateXPath));
        StateField.click();

        // Tìm và chọn tùy chọn trong dropdown bằng văn bản

        String OPTION = "//div[@id='%s']";

        String optionXPath = String.format(OPTION, "react-select-3-option-0");
        WebElement optionElement = driver.findElement(By.xpath(optionXPath));
        optionElement.click();

        // City
        String CityXPath = String.format(DROPDOWN1, " css-1pahdxg-control");

        // Mở dropdown
        WebElement cityField = driver.findElement(By.xpath(CityXPath));
        cityField.click();

        // Tìm và chọn tùy chọn trong dropdown bằng văn bản

        String option1XPath = String.format(OPTION, "react-select-4-option-0");
        WebElement option1Element = driver.findElement(By.xpath(option1XPath));
        option1Element.click();

    }
}

