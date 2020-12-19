package exercise2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageTest2;

import java.util.concurrent.TimeUnit;

public class ExecutionSteps2 {
    private WebDriver driver;


    @Given("^Website is open\\.$")
    public void websiteIsOpen() {
        System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver.exe");

       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }

    @When("^User enter \"([^\"]*)\" and \"([^\"]*)\"\\.$")
    public void userEnterAnd(String email, String password) throws Throwable {
        PageTest2 userAction = new PageTest2(driver);
        userAction.loginAs(email, password);

    }

    @And("^User searches for product\\.$")
    public void userSearchesForProduct() {
        PageTest2 userAction = new PageTest2(driver);
        userAction.SearchProduct();

    }

    @And("^User clicks on selected product\\.$")
    public void userClicksOnSelectedProduct() throws InterruptedException {
        PageTest2 userAction = new PageTest2(driver);
        userAction.SelectProduct();
    }

    @And("^User selects the \"([^\"]*)\" and \"([^\"]*)\"\\.$")
    public void userSelectsTheAnd(String size, String quantity) throws InterruptedException {
        PageTest2 userAction = new PageTest2(driver);
        userAction.SelectProductSize(size);
        userAction.SelectProductQuantity(quantity);

    }

    @And("^User adds the product to the cart\\.$")
    public void userAddsTheProductToTheCart() throws InterruptedException {
        PageTest2 userAction = new PageTest2(driver);
        userAction.AddProductCart();
    }

    @And("^User proceeds to checkout\\.$")
    public void userProceedsToCheckout() throws InterruptedException {
        PageTest2 userAction = new PageTest2(driver);
        userAction.ProceedToCheckout();

    }

    @And("^User confirms address\\.$")
    public void userConfirmsAddress() throws InterruptedException{
        PageTest2 userAction = new PageTest2(driver);
        userAction.AcceptAddress();

    }

    @And("^User selects pick up in store\\.$")
    public void userSelectsPickUpInStore()throws InterruptedException {
        PageTest2 userAction = new PageTest2(driver);
        userAction.SelectDelivery();

    }

    @And("^User selects pay by check\\.$")
    public void userSelectsPayByCheck() {
        PageTest2 userAction = new PageTest2(driver);
        userAction.SelectPayOption();

    }

    @And("^User finilizes the order with an obligation to pay\\.$")
    public void userFinilizesTheOrderWithAnObligationToPay() {
        PageTest2 userAction = new PageTest2(driver);
        userAction.AcceptTermsAndOrder();

    }

    @Then("^User closes the browser\\.$")
    public void userClosesTheBrowser() {
        PageTest2 userAction = new PageTest2(driver);
        userAction.CaptureScreen();
        driver.quit();

    }
}
