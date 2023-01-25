package tests;

import core.TestBase;
import entity.Customer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import util.Config;
import util.TestUtil;

public class IncorrectLogin extends TestBase {

    @BeforeClass
    public void disableAutoLogin(){
        setEnableAutologin(false);
    }

    @DataProvider(name = "dataDeCompraProvider")
    public Object[][] dataDeCompra(){
        return TestUtil.jsonToDataProvider("dataDeCompra.json" , Customer.class);
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Utilizar credenciales no válidas",
            dataProvider = "dataDeCompraProvider")
    @Description("Introducir credenciales no validas en la página de login")
    public void incorrectLoginTest(Customer customer){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo(Config.getHomePage());
        loginPage.wrongLogin(customer);
        HomePage homePage = new HomePage(driver);
        homePage.verifyNotInHomePage();
    }
}

