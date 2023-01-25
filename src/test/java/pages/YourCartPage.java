package pages;

import core.PageBase;
import io.qameta.allure.Step;
import objectrepo.YourCartPageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends PageBase {

    YourCartPageLocator page;

    public YourCartPage(WebDriver driver) {
        super(driver);
        page = new YourCartPageLocator();
        PageFactory.initElements(driver,page);
    }

    @Step("Validar que se esta en Your cart page")
    public YourCartPage verifyInYourCartPage(){
        waitForVisibility(page.yourCartTitle);
        return this;
    }

    @Step("Remover producto del carrito")
    public void removeItemFromCart(){
        waitAndClick(page.removeSauceLabsBackpack);
    }

    @Step("Vericar que no hay productos en el carrito")
    public void verifyNoItemsInCart(){
        noSuchElement(page.cartBadge);
    }

    @Step("Proceder al checkout")
    public void proceedToCheckout(){
        waitAndClick(page.checkoutButton);
    }


}
