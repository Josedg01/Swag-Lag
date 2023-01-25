package pages;

import core.PageBase;
import entity.Customer;
import io.qameta.allure.Step;
import objectrepo.CheckoutPageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends PageBase {

    CheckoutPageLocator page;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        page = new CheckoutPageLocator();
        PageFactory.initElements(driver,page);
    }

    @Step("Validar que se esta en checkout page")
    public CheckoutPage verifyInCheckoutPage(){
        waitForVisibility(page.checkoutPageTitle);
        return this;
    }

    @Step("Haciendo checkout")
    public CheckoutOverviewPage checkout(Customer customer){
        sendKeys(page.fistNameTextBox, customer.getCustomerName());
        sendKeys(page.lastnameTextBox, customer.getCustomerLastname());
        sendKeys(page.zipCodeTextBox, customer.getZipCode());
        waitAndClick(page.continueButton);
        return new CheckoutOverviewPage(getDriver());
    }

    @Step("haciendo checkout sin introducir el nombre")
    public void checkoutNoName(Customer customer){
        sendKeys(page.lastnameTextBox, customer.getCustomerLastname());
        sendKeys(page.zipCodeTextBox, customer.getZipCode());
        waitAndClick(page.continueButton);
        compareText(page.nameRequiredAlert, "Error: First Name is required");
    }

    @Step("Haciendo checkout sin introducir el apellido")
    public void checkoutNoLastname(Customer customer){
        sendKeys(page.fistNameTextBox, customer.getCustomerName());
        sendKeys(page.zipCodeTextBox, customer.getZipCode());
        waitAndClick(page.continueButton);
        compareText(page.lastnameRequiredAlert, "Error: Last Name is required");
    }

    @Step("Haciendo checkout sin introducir el zip code")
    public void checkoutNoZipCode(Customer customer){
        sendKeys(page.fistNameTextBox, customer.getCustomerName());
        sendKeys(page.lastnameTextBox, customer.getCustomerLastname());
        waitAndClick(page.continueButton);
        compareText(page.zipCodeRequiredAlert, "Error: Postal Code is required");
    }
}
