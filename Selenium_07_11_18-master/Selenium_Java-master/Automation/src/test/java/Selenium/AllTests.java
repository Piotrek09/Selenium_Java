package Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllTests {
    WebDriver driver;

    @Before
    public void before(){
        System.setProperty("webdriver.gecko.driver","geckodriver-v0.22.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void createAnAccount() {
        PageMethods page = new PageMethods(driver);
        page.createAccount();
        page.fillYourPersonalInformation();
        page.fillYourAddress();
        page.signOut();
    }

    @Test
    public void addTshirtToCartAndCheckout(){
        PageMethods page = new PageMethods(driver);
        page.signIn();
        page.addTshirtToCart();
        page.checkout();
        page.signOut();
    }

    @After
    public void after(){
        driver.quit();
    }
}
