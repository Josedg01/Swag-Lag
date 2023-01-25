package pages;

import core.PageBase;
import entity.Customer;
import io.qameta.allure.Step;
import objectrepo.CheckoutPageLocator;
import objectrepo.LoginPageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Config;

public class LoginPage extends PageBase {

    LoginPageLocator page;

    public LoginPage(WebDriver driver){
        super(driver);
        page = new LoginPageLocator();
        PageFactory.initElements(driver,page);
    }

    @Step("ingresando usuario y contraseña")
    public HomePage login(){
        sendKeys(page.usernameText, Config.getUser());
        sendKeys(page.passwordText, Config.getPassword());
        waitAndClick(page.loginButton);
        return new HomePage(getDriver());
    }

    @Step("ingresando usuario y contraseña")
    public void wrongLogin(Customer customer){
        sendKeys(page.usernameText, customer.getIncorrectUser());
        sendKeys(page.passwordText, customer.getIncorrectPassword());
        waitAndClick(page.loginButton);
        compareText(page.errorBox, "Epic sadface: Username and password do not match any user in this service");
    }

    @Step("Validar que se hizo login")
    public LoginPage verifyInLoginPage(){
        waitForVisibility(page.loginLogo);
        return this;
    }


}
