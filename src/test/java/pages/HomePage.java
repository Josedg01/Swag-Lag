package pages;

import core.PageBase;
import io.qameta.allure.Step;
import objectrepo.HomePageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

    HomePageLocator page;

    public HomePage(WebDriver driver) {
        super(driver);
        page = new HomePageLocator();
        PageFactory.initElements(driver,page);
    }

    @Step("Validar que se hizo login")
    public HomePage verifyLogin(){
        waitForVisibility(page.homePageTitle);
        return this;
    }

    @Step("Haciendo logout")
    public LoginPage logout(){
        waitAndClick(page.burgerMenuButton);
        waitAndClick(page.logoutSidebar);
        return new LoginPage(getDriver());
    }

    @Step("Validar que no se hizo login")
    public void verifyNotInHomePage(){
        noSuchElement(page.homePageTitle);
    }

    @Step("Agregar producto al carrito")
    public void addItemToCard(){
        waitAndClick(page.addSauceLabsBackpack);
    }

    @Step("Verificar cartBadge")
    public void verifyCartBadge(){
        waitForVisibility(page.cartBadge);
    }

    @Step("Remover producto del carrito")
    public void removeItemFromCart(){
        waitAndClick(page.removeSauceLabsBackpack);
    }

    @Step("Vericar que no hay productos en el carrito")
    public void verifyNoItemsInCart(){
        noSuchElement(page.cartBadge);
    }

    @Step("Ir al carrito")
    public YourCartPage goToCart(){
        waitAndClick(page.shoppingCartContainer);
        return new YourCartPage(getDriver());
    }
}
