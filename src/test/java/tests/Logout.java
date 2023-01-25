package tests;

import core.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import util.Config;

public class Logout extends TestBase {



    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "logout")
    @Description("Hacer logout")
    public void logout(){
        HomePage homePage = new HomePage(driver);
        homePage.logout().verifyInLoginPage();
    }
}

