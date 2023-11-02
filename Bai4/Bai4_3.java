package Bai4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.ofSeconds;

public class Bai4_3 {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        //Mở trang
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");

        //Login

        String LOGIN = "//input[@placeholder='%s']";
        String finalUserNameXPath = String.format(LOGIN, "Username");
        driver.findElement(By.xpath(finalUserNameXPath)).sendKeys("Admin");

        String finalPassWordXPath = String.format(LOGIN, "Password");
        driver.findElement(By.xpath(finalPassWordXPath)).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // I.Tối ưu
        String DYNAMIC_INPUT_TEXT_FORM = "//input[@placeholder='%s']";

        // 1. Handle for "First Name" field
        String finalFirstNameXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "First Name");
        System.out.println("XPath of First Name: " +finalFirstNameXPath);
        WebElement firstNameField = driver.findElement(By.xpath(finalFirstNameXPath));
        firstNameField.click();
        firstNameField.sendKeys(Keys.COMMAND, "a");
        firstNameField.sendKeys(Keys.DELETE);
        firstNameField.sendKeys("Nhu"); // Nhập giá trị mới

        // 2. Handle for "Middle Name" field
        String finalMiddleNameXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Middle Name");
        System.out.println("XPath of Middle Name: " +finalMiddleNameXPath);
        WebElement middleNameField = driver.findElement(By.xpath(finalMiddleNameXPath));
        middleNameField.click();
        middleNameField.sendKeys(Keys.COMMAND, "a");
        middleNameField.sendKeys(Keys.DELETE);
        middleNameField.sendKeys("Quynh");

        // 3. Handle for "Last Name" field
        String finalLastNameXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Last Name");
        System.out.println("XPath of Last Name: " +finalLastNameXPath);
        WebElement lastNameField = driver.findElement(By.xpath(finalLastNameXPath));
        lastNameField.click();
        lastNameField.sendKeys(Keys.COMMAND, "a");
        lastNameField.sendKeys(Keys.DELETE);
        lastNameField.sendKeys("Duong");

        String DYNAMIC_INPUT_CLASS_FORM = "//label[text()='%s']/following::input[position()=1]";

        // 4. Handle for "Nickname" field
        String finalNickNameXPath = String.format(DYNAMIC_INPUT_CLASS_FORM, "Nickname");
        System.out.println("XPath of Nick Name: " +finalNickNameXPath);
        driver.findElement(By.xpath(finalNickNameXPath)).sendKeys("Julie");

        // 5. Handle for "Employee Id" field
        String finalEmployeeIdXPath = String.format(DYNAMIC_INPUT_CLASS_FORM, "Employee Id");
        System.out.println("XPath of Employee Id: " +finalEmployeeIdXPath);
        driver.findElement(By.xpath(finalEmployeeIdXPath)).sendKeys("99999");

        // 6. Handle for "Other Id" field
        String finalOtherIdXPath = String.format(DYNAMIC_INPUT_CLASS_FORM, "Other Id");
        System.out.println("XPath of Other Id: " +finalOtherIdXPath);
        driver.findElement(By.xpath(finalOtherIdXPath)).sendKeys("11111");

        // Handle for "Driver's License Number" field
        driver.findElement(By.xpath("//label[text()=\"Driver's License Number\"]/following::input[1]")).sendKeys("092");

//        String finalDriverXPath = String.format(DYNAMIC_INPUT_CLASS_FORM, "Driver's License Number");
//        System.out.println("XPath of Driver's License Number: " +finalDriverXPath);
//        driver.findElement(By.xpath(finalDriverXPath)).sendKeys("090");

        // 7. Handle for "SSN Number" field
        String finalSSNNumberXPath = String.format(DYNAMIC_INPUT_CLASS_FORM, "SSN Number");
        System.out.println("XPath of SSN Number: " +finalSSNNumberXPath);
        driver.findElement(By.xpath(finalSSNNumberXPath)).sendKeys("090909");

        // 8. Handle for "SIN Number" field
        String finalSINNumberXPath = String.format(DYNAMIC_INPUT_CLASS_FORM, "SIN Number");
        System.out.println("XPath of SIN Number: " +finalSSNNumberXPath);
        driver.findElement(By.xpath(finalSINNumberXPath)).sendKeys("98789");

        // 9. Handle for "Military Service" field
        String finalMilitaryServiceXPath = String.format(DYNAMIC_INPUT_CLASS_FORM, "Military Service");
        System.out.println("XPath of Military Service: " +finalMilitaryServiceXPath);
        driver.findElement(By.xpath(finalMilitaryServiceXPath)).sendKeys("111222333");

        // II.Tối ưu
        String DROPDOWN = "//label[text()='%s']/following::div[position()=1]";

        // 1. Nationality

        String NationalityXPath = String.format(DROPDOWN, "Nationality");
        System.out.println("XPath of Nationality: " + NationalityXPath);

        // Mở dropdown
        WebElement NationalityField = driver.findElement(By.xpath(NationalityXPath));
        NationalityField.click();

        // Tìm và chọn tùy chọn trong dropdown bằng văn bản
        String OPTION = "//div[@role='option' and .='%s']";

        String optionXPath = String.format(OPTION, "Vietnamese");
        WebElement optionElement = driver.findElement(By.xpath(optionXPath));
        optionElement.click();

        // 2. Marital Status
        String MaritalXPath = String.format(DROPDOWN, "Marital Status");
        System.out.println("XPath of Marital Status: " + MaritalXPath);
        WebElement MaritalField = driver.findElement(By.xpath(MaritalXPath));
        MaritalField.click();
        String option1XPath = String.format(OPTION, "Single");
        WebElement option1Element = driver.findElement(By.xpath(option1XPath));
        option1Element.click();

        // 3. Blood Type
        String BloodTypeXPath = String.format(DROPDOWN, "Blood Type");
        System.out.println("XPath of Blood Type Status: " + BloodTypeXPath);
        WebElement BloodTypeField = driver.findElement(By.xpath(BloodTypeXPath));
        BloodTypeField.click();
        String option2XPath = String.format(OPTION, "A+");
        WebElement option2Element = driver.findElement(By.xpath(option2XPath));
        option2Element.click();

        // III. License Expiry Date
        WebElement datePicker=driver.findElement(By.xpath("//label[text()='License Expiry Date']/following::input[position()=1]"));
        //Press Ctrl-A
        String s1 = Keys.chord(Keys.COMMAND, "a");
        datePicker.sendKeys(s1);
        //Fill Date
        datePicker.sendKeys("2023-11-19");
        //Press Enter to exit DatePicker
        datePicker.sendKeys(Keys.ENTER);

        // IV. Date of Birth
        WebElement datePicker1=driver.findElement(By.xpath("//label[text()='Date of Birth']/following::input[position()=1]"));
        //Press Ctrl-A
        String s2 = Keys.chord(Keys.COMMAND, "a");
        datePicker1.sendKeys(s2);
        //Fill Date
        datePicker1.sendKeys("1996-11-19");
        //Press Enter to exit DatePicker
        datePicker1.sendKeys(Keys.ENTER);

        // V. Gender
        String DYNAMIC_INPUT_NAME_VALUE_FORM = "//label[type()='%s' and @value='%s']/following-sibling::label";
        String maleXPath = String.format(DYNAMIC_INPUT_NAME_VALUE_FORM, "Radio","2");
        Boolean isSelected = driver.findElement(By.xpath(maleXPath)).isSelected();
        if (isSelected == false) {
            driver.findElement(By.xpath(maleXPath)).click();
        }

        driver.findElement(By.xpath("//button[@type=\"submit\"] [position() =1]")).click();
        driver.findElement(By.xpath("//button[@type=\"submit\"]/following::button [@type=\"submit\"]")).click();
    }
}
