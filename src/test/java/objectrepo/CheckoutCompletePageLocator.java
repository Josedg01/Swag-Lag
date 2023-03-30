package objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePageLocator {

    @FindBy(xpath = "//span[@class='title'][contains(text(),'Checkout: Complete!')]")
    public WebElement checkoutCompleteTitle;

    @FindBy(xpath = "//h2[@class='complete-header'][contains(text(),'Thank you for your order!')]")
    public WebElement completeHeader;
}
