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

public class BuyItem extends TestBase {


    @DataProvider(name = "dataDeCompraProvider")
    public Object[][] dataDeCompra(){
        return TestUtil.jsonToDataProvider("dataDeCompra.json" , Customer.class);
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Comprar producto",
            dataProvider = "dataDeCompraProvider")
    @Description("Comprar un producto")
    public void buyItem(Customer customer){
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCard();
        homePage.goToCart();
        homePage.verifyCartBadge();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.verifyInYourCartPage();
        yourCartPage.proceedToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.verifyInCheckoutPage();
        checkoutPage.checkout(customer);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.verifyInCheckoutOverviewPage();
        checkoutOverviewPage.finishOverview();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.verifyCompleteCheckoutPage();
        checkoutCompletePage.verifyCompleteCheckout();
    }




}
