package core;

import listener.ExecutionListener;
import listener.TestListener;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pages.HomePage;
import pages.LoginPage;
import report.AllureManager;
import util.Config;

import java.beans.ExceptionListener;
import java.util.Objects;

import static constants.Browser.*;

@Slf4j
@Listeners({ExecutionListener.class, TestListener.class})
public class TestBase {

    public WebDriver driver;
    public HomePage homePage;
    public AllureManager allureManager = new AllureManager();
    private boolean enableAutologin = true;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        chooseBrowser(Config.getBrowser());
        driverConfiguration();
        if(enableAutologin){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.navigateTo(Config.getHomePage());
            homePage = loginPage.login().verifyLogin();
        }
    }

    public void setEnableAutologin(boolean status){
        this.enableAutologin = status;
    }

    public void chooseBrowser(String browser) {
        BrowserDrivers browserDrivers = new BrowserDrivers();
        switch (browser) {
            case CHROME:
                driver = browserDrivers.chrome();
                break;
            case FIREFOX:
                driver = browserDrivers.firefox();
                break;
            case EDGE:
                driver = browserDrivers.edge();
            default:
                throw new RuntimeException("Browser no soportado!");
        }

    }

   @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }


    private void driverConfiguration() {
        if (Objects.nonNull(driver)) {
            driver.manage().window().maximize();
        }
    }

}
