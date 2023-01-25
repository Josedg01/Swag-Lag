package pages;

import core.PageBase;
import io.qameta.allure.Step;
import objectrepo.CheckoutCompletePageLocator;
import objectrepo.HomePageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends PageBase {

    CheckoutCompletePageLocator page;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        page = new CheckoutCompletePageLocator();
        PageFactory.initElements(driver,page);
    }

    @Step("Validar que se esta en complete checkout page")
    public CheckoutCompletePage verifyCompleteCheckoutPage(){
        waitForVisibility(page.checkoutCompleteTitle);
        return this;
    }

    @Step("Validar que se completó el checkout")
    public void verifyCompleteCheckout(){
        waitForVisibility(page.completeHeader);

    }
}
