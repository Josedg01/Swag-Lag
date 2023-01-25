package pages;

import core.PageBase;
import io.qameta.allure.Step;
import objectrepo.CheckoutOverviewPageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends PageBase {

    CheckoutOverviewPageLocator page;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        page = new CheckoutOverviewPageLocator();
        PageFactory.initElements(driver,page);
    }

    @Step("Validar que se esta en checkout page")
    public CheckoutOverviewPage verifyInCheckoutOverviewPage(){
        waitForVisibility(page.checkoutOverviewTitle);
        return this;
    }

    @Step("Validar que no se paso a la página de overview")
    public void verifyNotInCheckoutOverviewPage(){
        noSuchElement(page.checkoutOverviewTitle);
    }

    @Step("Completar overview")
    public void finishOverview(){
        waitAndClick(page.finishButton);
    }
}
