package tests;

import core.TestBase;
import entity.Customer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import util.TestUtil;

public class CheckoutWithoutName extends TestBase {

    @DataProvider(name = "dataDeCompraProvider")
    public Object[][] dataDeCompra(){
        return TestUtil.jsonToDataProvider("dataDeCompra.json" , Customer.class);
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Checkout sin nombre",
            dataProvider = "dataDeCompraProvider")
    @Description("Tratar de hacer checkout sin colocar el nombre del cliente en la página de your information.")
    public void checkoutWithoutName(Customer customer){
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCard();
        homePage.goToCart();
        homePage.verifyCartBadge();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.verifyInYourCartPage();
        yourCartPage.proceedToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.verifyInCheckoutPage();
        checkoutPage.checkoutNoName(customer);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.verifyNotInCheckoutOverviewPage();


    }

}
