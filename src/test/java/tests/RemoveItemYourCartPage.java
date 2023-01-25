package tests;

import core.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.YourCartPage;

public class RemoveItemYourCartPage extends TestBase {


    @Severity(SeverityLevel.NORMAL)
    @Test(description = "remover producto")
    @Description("remover producto del carrito desde la pagina de Your Cart")
    public void removeItemFromCartYourCartPAge(){
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCard();
        homePage.verifyCartBadge();
        homePage.goToCart();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.verifyInYourCartPage();
        yourCartPage.removeItemFromCart();
        yourCartPage.verifyNoItemsInCart();
    }
}
