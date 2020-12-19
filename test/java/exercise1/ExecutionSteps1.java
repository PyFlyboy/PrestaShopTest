package exercise1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageTest1;

import java.util.concurrent.TimeUnit;

public class ExecutionSteps1 {
    private WebDriver driver;


    @Given("^User is logged in and address form is opened\\.$")
    public void userIsLoggedInAndAddressFormIsOpened() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        PageTest1 userLogin = new PageTest1(driver);
        userLogin.LoginAs("do.tomasza@wp.pl", "Master12!@");
        PageTest1 newAddress = new PageTest1(driver);
        newAddress.CreateNewAddres();
    }

    @When("^User enters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"\\.$")
    public void userEnters(String alias, String address, String zipcode, String city, String country, String phone) throws InterruptedException {
        PageTest1 addressForm = new PageTest1(driver);
        addressForm.SetData(alias, address, zipcode, city, country, phone);
        addressForm.AliasIsDispalyed(alias);
        addressForm.AddressIsDisplayed(address);
        addressForm.ZipIsDisplayed(zipcode);
        addressForm.CityIsDisplayed(city);
        addressForm.PhoneNumberIsDisplayed(phone);

    }

    @And("^User saves information\\.$")
    public void userSavesInformation()throws InterruptedException {
        PageTest1 addressForm = new PageTest1(driver);
        addressForm.SaveData();
    }

    @Then("^User closes the website\\.$")
    public void userClosesTheWebsite() {
        PageTest1 addressForm = new PageTest1(driver);
        addressForm.CaptureScreen();
        driver.quit();
    }
}