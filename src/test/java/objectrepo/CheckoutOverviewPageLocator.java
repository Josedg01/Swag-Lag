package objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPageLocator {

    @FindBy(xpath = "//span[@class='title'][contains(text(),'Checkout: Overview')]")
    public WebElement checkoutOverviewTitle;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishButton;


}
