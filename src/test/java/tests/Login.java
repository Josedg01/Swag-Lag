package tests;

import core.TestBase;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.Config;


@Epic("Swag lab")
@Feature("Login")
public class Login extends TestBase {


    @BeforeClass
    public void disableAutoLogin(){
        setEnableAutologin(false);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Utilizar credenciales válidas")
    @Description("Introducir credenciales validas en la página de login")
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo(Config.getHomePage());
        loginPage.login().verifyLogin();
    }
}
