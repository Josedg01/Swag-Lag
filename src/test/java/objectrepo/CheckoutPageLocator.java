package objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageLocator {


    @FindBy(xpath = "//span[@class='title'][contains(text(),'Checkout: Your Information')]")
    public WebElement checkoutPageTitle;

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement fistNameTextBox;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastnameTextBox;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement zipCodeTextBox;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//h3[contains(text(),'Error: First Name is required')]")
    public WebElement nameRequiredAlert;

    @FindBy(xpath = "//h3[contains(text(),'Error: Last Name is required')]")
    public WebElement lastnameRequiredAlert;

    @FindBy(xpath = "//h3[contains(text(),'Error: Postal Code is required')]")
    public WebElement zipCodeRequiredAlert;

}
