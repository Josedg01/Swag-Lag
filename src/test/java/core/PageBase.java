package core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Config;

import java.time.Duration;
import java.util.Arrays;
import java.util.Objects;

public class PageBase {

    private final WebDriverWait wait;
    private final WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        Duration duration = Duration.ofSeconds(Config.getTimeout());
        this.wait = new WebDriverWait(driver, duration);
        this.wait.ignoreAll(Arrays.asList(NoSuchElementException.class));
    }

    public WebDriver getDriver() {
        return driver;
    }

    //NAVIGATE METHODS
    public void navigateTo(String url) {
        driver.get(url);
    }

    //WAIT METHODS
    public void waitForVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            Assert.fail(e.getMessage());
        }

    }

    public void waitForClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (TimeoutException e){
            Assert.fail(e.getMessage());
        }
    }

    //KEYS METHODS
    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    //CLICK METHODS:
    public void waitAndClick(WebElement element) {
        waitForClickable(element);
        element.click();
    }


    public void noSuchElement(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String getText(WebElement element){
        waitForVisibility(element);
        return element.getText();
    }

    public void compareText(WebElement element, String compare){
        waitForVisibility(element);
        String elementText = element.getText();
        if(Objects.equals(elementText, compare)){
            System.out.println(element.getText() + " = " + compare);
        }else {
            Assert.fail(elementText + " != " + compare);
        }
    }

}
