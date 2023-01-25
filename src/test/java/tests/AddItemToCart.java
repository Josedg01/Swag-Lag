package tests;


import core.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

@Slf4j
public class AddItemToCart extends TestBase {



    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Agregar producto")
    @Description("Agregar un producto al carrito")
    public void addItemToCart(){
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCard();
        homePage.verifyCartBadge();
    }
}
