package objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPageLocator {

    @FindBy(xpath = "//span[@class='title'][contains(text(),'Your Cart')]")
    public WebElement yourCartTitle;

    @FindBy(xpath = "//*[@id='remove-sauce-labs-backpack']")
    public WebElement removeSauceLabsBackpack;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public WebElement cartBadge;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButton;

}
