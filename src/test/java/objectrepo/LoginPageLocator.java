package objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator {

    @FindBy(xpath = "//*[@class='login_logo']")
    public WebElement loginLogo;

    @FindBy(id="user-name")
    public WebElement usernameText;

    @FindBy(id="password")
    public WebElement passwordText;

    @FindBy(id="login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
    public WebElement errorBox;

}
