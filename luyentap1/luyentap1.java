package luyentap1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.awt.SystemColor.text;
import static java.time.Duration.ofSeconds;

public class luyentap1 {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        //Mở trang
        driver.get("https://rise.fairsketch.com/clients/contact_profile/107/general");

        //Login

        String LOGIN = "//input[@placeholder='%s']";
        String finalEmailXPath = String.format(LOGIN, "Email");

        WebElement EmailField = driver.findElement(By.xpath(finalEmailXPath));
        EmailField.click();
        EmailField.sendKeys(Keys.COMMAND, "a");
        EmailField.sendKeys(Keys.DELETE);
        EmailField.sendKeys("client@demo.com");

        String finalPassWordXPath = String.format(LOGIN, "Password");
        WebElement PWField = driver.findElement(By.xpath(finalPassWordXPath));
        PWField.click();
        PWField.sendKeys(Keys.COMMAND, "a");
        PWField.sendKeys(Keys.DELETE);
        PWField.sendKeys("riseDemo");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // General Info Tab
        // I.Tối ưu
        String DYNAMIC_INPUT_TEXT_FORM = "//input[@placeholder='%s']";

        // 1. Handle for "First Name" field
        String finalFirstNameXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "First name");
        System.out.println("XPath of First name: " + finalFirstNameXPath);
        WebElement firstNameField = driver.findElement(By.xpath(finalFirstNameXPath));
        firstNameField.click();
        firstNameField.sendKeys(Keys.COMMAND, "a");
        firstNameField.sendKeys(Keys.DELETE);
        firstNameField.sendKeys("Nhu"); // Nhập giá trị mới

        // 2. Handle for "Last Name" field
        String finalLastNameXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Last name");
        System.out.println("XPath of Last name: " + finalLastNameXPath);
        WebElement lastNameField = driver.findElement(By.xpath(finalLastNameXPath));
        lastNameField.click();
        lastNameField.sendKeys(Keys.COMMAND, "a");
        lastNameField.sendKeys(Keys.DELETE);
        lastNameField.sendKeys("Duong");

        String DYNAMIC_Phone = "(//input[@placeholder='%s'])[%s]";

        // 3. Handle for "Phone" field
        String finalPhoneXPath = String.format(DYNAMIC_Phone, "Phone", "1");
        System.out.println("XPath of Phone: " + finalPhoneXPath);
        WebElement PhoneField = driver.findElement(By.xpath(finalPhoneXPath));
        PhoneField.click();
        PhoneField.sendKeys(Keys.COMMAND, "a");
        PhoneField.sendKeys(Keys.DELETE);
        PhoneField.sendKeys("090000900");

        // 4. Handle for "Skype" field
        String finalSkypeXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Skype");
        System.out.println("XPath of Skype: " + finalSkypeXPath);
        WebElement SkypeField = driver.findElement(By.xpath(finalSkypeXPath));
        SkypeField.click();
        SkypeField.sendKeys(Keys.COMMAND, "a");
        SkypeField.sendKeys(Keys.DELETE);
        SkypeField.sendKeys("xxxxxx");

        // 4. Handle for "Job Title" field
        String finalJobTitleXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Job Title");
        System.out.println("XPath of Skype: " + finalJobTitleXPath);
        WebElement jobTitleField = driver.findElement(By.xpath(finalJobTitleXPath));
        jobTitleField.click();
        jobTitleField.sendKeys(Keys.COMMAND, "a");
        jobTitleField.sendKeys(Keys.DELETE);
        jobTitleField.sendKeys("Cùi bắp");

        // 5. Gender
        driver.findElement(By.xpath("//label[@for='gender_other']")).click();

        // 6. Save
        WebDriverWait saveWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        saveWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]"))).click();

        // Đợi cho đến khi trang web hoàn thành tải lại
        WebDriverWait reloadWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        reloadWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.tagName("html"))));

        // II. Chuyển tab "Company"
        driver.findElement(By.xpath("//a[@data-bs-target=\"#tab-company-info\"]")).click();

        // 1. Type
        driver.findElement(By.xpath("//label[@for='type_organization']")).click();

        // 2. Company

        String CompanyXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Company name");
        System.out.println("XPath of Company: " + CompanyXPath);
        WebElement companyField = driver.findElement(By.xpath(CompanyXPath));
        companyField.click();
        companyField.sendKeys(Keys.COMMAND, "a");
        companyField.sendKeys(Keys.DELETE);
        companyField.sendKeys("Đời");

        // 3. Adress
        WebElement adressField = driver.findElement(By.xpath("//textarea[@placeholder='Address']"));
        adressField.click();
        adressField.sendKeys(Keys.COMMAND, "a");
        adressField.sendKeys(Keys.DELETE);
        adressField.sendKeys("Penthouse");

        // 4. City
        String CityXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "City");
        System.out.println("XPath of City: " + CityXPath);
        WebElement cityField = driver.findElement(By.xpath(CityXPath));
        cityField.click();
        cityField.sendKeys(Keys.COMMAND, "a");
        cityField.sendKeys(Keys.DELETE);
        cityField.sendKeys("Happy City");

        // 5. State
        String StateXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "State");
        System.out.println("XPath of State: " + StateXPath);
        WebElement stateField = driver.findElement(By.xpath(CityXPath));
        cityField.click();
        cityField.sendKeys(Keys.COMMAND, "a");
        cityField.sendKeys(Keys.DELETE);
        cityField.sendKeys("Smile");

        // 5. Zip
        String ZipXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Zip");
        System.out.println("XPath of Zip: " + ZipXPath);
        WebElement zipField = driver.findElement(By.xpath(ZipXPath));
        zipField.click();
        zipField.sendKeys(Keys.COMMAND, "a");
        zipField.sendKeys(Keys.DELETE);
        zipField.sendKeys("900-0000");

        // 6. Country

        String CountryXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Country");
        System.out.println("XPath of country: " + CountryXPath);
        WebElement countryField = driver.findElement(By.xpath(CountryXPath));
        countryField.click();
        countryField.sendKeys(Keys.COMMAND, "a");
        countryField.sendKeys(Keys.DELETE);
        countryField.sendKeys("VietNam");

        // 7. Phone

        String finalPhone1XPath = String.format(DYNAMIC_Phone, "Phone", "2");
        System.out.println("XPath of Phone: " + finalPhone1XPath);
        WebElement Phone1Field = driver.findElement(By.xpath(finalPhone1XPath));
        Phone1Field.click();
        Phone1Field.sendKeys(Keys.COMMAND, "a");
        Phone1Field.sendKeys(Keys.DELETE);
        Phone1Field.sendKeys("09000888");

        // 8. Website

        String WebsiteXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Website");
        System.out.println("XPath of Website: " + WebsiteXPath);
        WebElement websiteField = driver.findElement(By.xpath(WebsiteXPath));
        websiteField.click();
        websiteField.sendKeys(Keys.COMMAND, "a");
        websiteField.sendKeys(Keys.DELETE);
        websiteField.sendKeys("//https:www");

        // 9. VAT Number

        String VATXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "VAT Number");
        System.out.println("XPath of Website: " + VATXPath);
        WebElement vatField = driver.findElement(By.xpath(VATXPath));
        vatField.click();
        vatField.sendKeys(Keys.COMMAND, "a");
        vatField.sendKeys(Keys.DELETE);
        vatField.sendKeys("01236748");

        // 10. GST Number

        String GSTXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "GST Number");
        System.out.println("XPath of Website: " + GSTXPath);
        WebElement gstField = driver.findElement(By.xpath(GSTXPath));
        gstField.click();
        gstField.sendKeys(Keys.COMMAND, "a");
        gstField.sendKeys(Keys.DELETE);
        gstField.sendKeys("98765");

        // 11. Save
        WebDriverWait saveWait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        saveWait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[2]"))).click();

        // II. Chuyển tab "Social links"
        driver.findElement(By.xpath("//a[@data-bs-target=\"#tab-social-links\"]")).click();

        // 1. Facebook

        String FacebookXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://www.facebook.com/");
        System.out.println("XPath of Website: " + FacebookXPath);
        WebElement facebookField = driver.findElement(By.xpath(FacebookXPath));
        facebookField.click();
        facebookField.sendKeys(Keys.COMMAND, "a");
        facebookField.sendKeys(Keys.DELETE);
        facebookField.sendKeys("https://www.facebook.com/1");

        // 2. Twitter

        String TwitterXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://twitter.com/");
        System.out.println("XPath of Twitter: " + TwitterXPath);
        WebElement twitterField = driver.findElement(By.xpath(TwitterXPath));
        twitterField.click();
        twitterField.sendKeys(Keys.COMMAND, "a");
        twitterField.sendKeys(Keys.DELETE);
        twitterField.sendKeys("https://twitter.com/1");

        // 3. Linkedin

        String LinkedinXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://www.linkedin.com/");
        System.out.println("XPath of Linkedin: " + LinkedinXPath);
        WebElement linkedinField = driver.findElement(By.xpath(LinkedinXPath));
        linkedinField.click();
        linkedinField.sendKeys(Keys.COMMAND, "a");
        linkedinField.sendKeys(Keys.DELETE);
        linkedinField.sendKeys("https://www.linkedin.com/1");

        // 4. WhatsApp

        String WhatsAppXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://wa.me/+001XXXXXXX");
        System.out.println("XPath of WhatsApp: " + WhatsAppXPath);
        WebElement WhatsAppField = driver.findElement(By.xpath(WhatsAppXPath));
        WhatsAppField.click();
        WhatsAppField.sendKeys(Keys.COMMAND, "a");
        WhatsAppField.sendKeys(Keys.DELETE);
        WhatsAppField.sendKeys("https://wa.me/090900000");

        // 5. Digg

        String DiggXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "http://digg.com/");
        System.out.println("XPath of Digg: " + DiggXPath);
        WebElement DiggField = driver.findElement(By.xpath(DiggXPath));
        DiggField.click();
        DiggField.sendKeys(Keys.COMMAND, "a");
        DiggField.sendKeys(Keys.DELETE);
        DiggField.sendKeys("http://digg.com/1");

        // 6. Youtube

        String YoutubeXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://www.youtube.com/");
        System.out.println("XPath of Youtube: " + YoutubeXPath);
        WebElement YoutubeField = driver.findElement(By.xpath(YoutubeXPath));
        YoutubeField.click();
        YoutubeField.sendKeys(Keys.COMMAND, "a");
        YoutubeField.sendKeys(Keys.DELETE);
        YoutubeField.sendKeys("https://www.youtube.com/1");

        // 7. Pinterest

        String PinterestXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://www.pinterest.com/");
        System.out.println("XPath of Pinterest: " + PinterestXPath);
        WebElement PinterestField = driver.findElement(By.xpath(PinterestXPath));
        PinterestField.click();
        PinterestField.sendKeys(Keys.COMMAND, "a");
        PinterestField.sendKeys(Keys.DELETE);
        PinterestField.sendKeys("https://www.pinterest.com/1");

        // 8. Instagram

        String InstagramXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://instagram.com/");
        System.out.println("XPath of Instagram: " + InstagramXPath);
        WebElement InstagramField = driver.findElement(By.xpath(InstagramXPath));
        InstagramField.click();
        InstagramField.sendKeys(Keys.COMMAND, "a");
        InstagramField.sendKeys(Keys.DELETE);
        InstagramField.sendKeys("https://instagram.com/1");

        // 9. Github

        String GithubXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://github.com/");
        System.out.println("XPath of Github: " + GithubXPath);
        WebElement GithubField = driver.findElement(By.xpath(GithubXPath));
        GithubField.click();
        GithubField.sendKeys(Keys.COMMAND, "a");
        GithubField.sendKeys(Keys.DELETE);
        GithubField.sendKeys("https://github.com/1");

        // 10. Tumblr

        String TumblrXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://www.tumblr.com/");
        System.out.println("XPath of Tumblr: " + TumblrXPath);
        WebElement TumblrField = driver.findElement(By.xpath(TumblrXPath));
        TumblrField.click();
        TumblrField.sendKeys(Keys.COMMAND, "a");
        TumblrField.sendKeys(Keys.DELETE);
        TumblrField.sendKeys("https://www.tumblr.com/1");

        // 11. Vine

        String VineXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "https://vine.co/");
        System.out.println("XPath of Vine: " + VineXPath);
        WebElement VineField = driver.findElement(By.xpath(VineXPath));
        VineField.click();
        VineField.sendKeys(Keys.COMMAND, "a");
        VineField.sendKeys(Keys.DELETE);
        VineField.sendKeys("https://vine.co/1");

        // 12. Save
        WebDriverWait saveWait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        saveWait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[3]"))).click();

        // III. Chuyển tab " Account settings"
        driver.findElement(By.xpath("//a[@data-bs-target=\"#tab-account-settings\"]")).click();

        // 1. Email
        String EmailXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Email");
        System.out.println("XPath of Email: " + EmailXPath);
        WebElement emailField = driver.findElement(By.xpath(EmailXPath));
        emailField.click();
        emailField.sendKeys(Keys.COMMAND, "a");
        emailField.sendKeys(Keys.DELETE);
        emailField.sendKeys("test@gmail.com");

        // 2. Password

        String PasswordXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Password");
        System.out.println("XPath of Password: " + PasswordXPath);
        WebElement passwordField = driver.findElement(By.xpath(PasswordXPath));
        passwordField.click();
        passwordField.sendKeys(Keys.COMMAND, "a");
        passwordField.sendKeys(Keys.DELETE);
        passwordField.sendKeys("admin123");

        // 3. Retype Password

        String RetypeXPath = String.format(DYNAMIC_INPUT_TEXT_FORM, "Retype password");
        System.out.println("XPath of Retype Password: " + RetypeXPath);
        WebElement retypeField = driver.findElement(By.xpath(RetypeXPath));
        retypeField.click();
        retypeField.sendKeys(Keys.COMMAND, "a");
        retypeField.sendKeys(Keys.DELETE);
        retypeField.sendKeys("admin123");

        // 4. Save
        WebDriverWait saveWait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        saveWait3.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[4]"))).click();

    }
}