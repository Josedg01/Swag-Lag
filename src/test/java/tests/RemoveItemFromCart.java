package tests;

import core.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.HomePage;

@Slf4j
public class RemoveItemFromCart extends TestBase {


    @Severity(SeverityLevel.NORMAL)
    @Test(description = "remover producto")
    @Description("remover producto del carrito")
    public void removeItemFromCart(){
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCard();
        homePage.verifyCartBadge();
        homePage.removeItemFromCart();
        homePage.verifyNoItemsInCart();
    }
}
