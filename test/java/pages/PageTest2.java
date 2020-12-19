package pages;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class PageTest2 {
    private WebDriver driver;

    @FindBy(name = "email")
    WebElement inputEmail;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    @FindBy(name = "s")
    WebElement search;

    @FindBy(css = "article.product-miniature:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)")
    WebElement product;

    @FindBy(id = "group_1")
    WebElement selecttSize;

    @FindBy(id = "quantity_wanted")
    WebElement selectquantity;

    @FindBy(xpath = "/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")
    WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")
    WebElement confirmProceedToCheckoutButton;

    @FindBy(name = "confirm-addresses")
    WebElement addressBtn;

    @FindBy(name = "confirmDeliveryOption")
    WebElement deliveryConfirm;

    @FindBy(xpath = "//*[@id=\"payment-option-1\"]")
    WebElement payBy;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement selectTerms;

    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")
    WebElement acceptOrder;

    public PageTest2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }
    //This method uses credentials for login into the user account.
    public void loginAs(String email, String password) {
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);

        signInButton.click();
         }
    //This method searches for an indicated product.
    public void SearchProduct(){
        search.sendKeys("Hummingbird Printed Sweater");
        search.submit();
        }
    //This method selects an indicated product.
    public void SelectProduct() throws InterruptedException {
        product.click();
        Thread.sleep(1000);
        }
    // This method allows to select the product size.
    public void SelectProductSize(String size) {
        Select sizeSelect = new Select(selecttSize);
        sizeSelect.selectByVisibleText(size);
        }

    // This method allows to select the product quantity.
    public void SelectProductQuantity(String quantity) throws InterruptedException  {
        selectquantity.click();
        selectquantity.sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        selectquantity.clear();
        selectquantity.sendKeys(quantity);
        }
    // This method adds the product to the cart.
    public void AddProductCart() throws InterruptedException {
        Thread.sleep(1000);
        addToCartButton.click();
        }
    // This method proceeds to the payment process.
    public void ProceedToCheckout() throws InterruptedException {
        Thread.sleep(2000);
        proceedToCheckoutButton.click();
        confirmProceedToCheckoutButton.click();
        }

    // This method accepts the user's address.
    public void AcceptAddress() throws InterruptedException {
        Thread.sleep(2000);
        addressBtn.click();
    }
    // This method selects a delivery option.
    public void SelectDelivery() throws InterruptedException {
        Thread.sleep(2000);
        deliveryConfirm.click();
    }
    // This method selects the payment option.
    public void SelectPayOption() {
        payBy.click();
    }
    //This method finilzes payment procces.
    public void AcceptTermsAndOrder() {
        if (!selectTerms.isSelected())
            selectTerms.click();
        acceptOrder.click();
        }
    // This method takes a screenshot.
    public String CaptureScreen() {
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./src/screenshots/exercise2/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
             }
        return path;

        }

}


