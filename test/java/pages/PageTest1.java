package pages;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class PageTest1 {

    private WebDriver driver;

    public PageTest1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement loginInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[4]/a")
    WebElement AddressLink;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/a")
    WebElement CreateAddressButton;

    @FindBy(name = "alias")
    WebElement aliasInput;

    @FindBy(name = "address1")
    WebElement addressInput;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "id_country")
    WebElement countryInput;

    @FindBy(name = "phone")
    WebElement phoneInput;

    @FindBy(xpath = " //*[@id=\"content\"]/div/div/form/footer/button")
    WebElement saveButton;


    //This method uses credentials for login into the user's account.
    public void LoginAs(String email, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();
    }

    //This method creates a new address form.
    public void CreateNewAddres() {
        AddressLink.click();
        CreateAddressButton.click();

    }
    // This method sends the user's data to the address form.
    public void SetData(String alias, String address, String zipcode, String city, String country, String phone) throws InterruptedException {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);
        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(zipcode);
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
        countryInput.click();
        countryInput.sendKeys(country);
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        Thread.sleep(1000);
    }
    // This method checks if text is displayed.
    public void AliasIsDispalyed(String alias){
           if (aliasInput.isDisplayed()) {
                System.out.println("Alias: " + alias + "- is displayed");
          }else {
                Assert.fail();
            }
    }
    // This method checks if text is displayed.
    public void AddressIsDisplayed(String address){
           if (addressInput.isDisplayed()){
               System.out.println("Address: " + address + "- is displayed");
          }else {
                Assert.fail();
            }
    }
    // This method checks if text is displayed.
    public void ZipIsDisplayed(String postCode) {
            if (postcodeInput.isDisplayed()) {
                System.out.println("Zip Code: " + postCode + "- is displayed");

           }else {
                Assert.fail();
            }
    }
    // This method checks if text is displayed.
    public void CityIsDisplayed(String city){
            if (cityInput.isDisplayed()){
                System.out.println("City: " + city + "- is displayed");
        }
            else {
                Assert.fail();
        }
    }
    // This method checks if text is displayed.
    public void PhoneNumberIsDisplayed(String phone){
            if(phoneInput.isDisplayed()){
                System.out.println("Phone number: " + phone + "- is displayed");
           }else{
                 Assert.fail();
        }
    }
    // This method saves the information provided by the user.
    public void SaveData()throws InterruptedException {
        Thread.sleep(1000);
        saveButton.click();
        }
    // This method takes a screenshot.
    public String CaptureScreen() {
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./src/screenshots/exercise1/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();}
        return path;

        }
}