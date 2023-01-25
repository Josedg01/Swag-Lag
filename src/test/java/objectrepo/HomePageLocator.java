package objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocator {

    @FindBy(xpath = "//span[@class='title']")
    public WebElement homePageTitle;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement addSauceLabsBackpack;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public WebElement cartBadge;

    @FindBy(xpath = "//*[@id='shopping_cart_container']")
    public WebElement shoppingCartContainer;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    public WebElement removeSauceLabsBackpack;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    public WebElement burgerMenuButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    public WebElement logoutSidebar;
}
