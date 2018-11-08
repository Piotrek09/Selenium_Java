package Selenium;

import com.mifmif.common.regex.Generex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageMethods extends PageObject{

    public PageMethods(WebDriver driver) { super(driver);}


    public String generateMailAddress(){

        String regex;
        regex = "\\w{5}\\@gmail\\.com";
        Generex generex = new Generex(regex);
        return generex.random();
    }

    public void createAccount(){

        driver.findElement(By.cssSelector(".login")).click();
        driver.findElement(By.id("email_create")).sendKeys(generateMailAddress());
        driver.findElement(By.id("SubmitCreate")).click();
    }

    public void fillYourPersonalInformation() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Jan");
        driver.findElement(By.id("customer_lastname")).sendKeys("Kowalski");
        driver.findElement(By.id("passwd")).sendKeys("password");
        new Select(driver.findElement(By.id("days"))).selectByValue("2");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("March ");
        new Select(driver.findElement(By.id("years"))).selectByValue("1994");
    }


    public void fillYourAddress(){

        driver.findElement(By.id("company")).sendKeys("Samsung");
        driver.findElement(By.id("address1")).sendKeys("Mainstreet");
        driver.findElement(By.id("address2")).sendKeys("19/209");
        driver.findElement(By.id("city")).sendKeys("Miami");
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Florida");
        driver.findElement(By.id("postcode")).sendKeys("10110");
        new Select (driver.findElement(By.id("id_country"))).selectByVisibleText("United States");
        driver.findElement(By.id("other")).sendKeys("Some needed info");
        driver.findElement(By.id("phone")).sendKeys("+22 50620220");
        driver.findElement(By.id("phone_mobile")).sendKeys("+ 48 660440330");
        driver.findElement(By.id("submitAccount")).click();
    }


    public void signIn(){

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.id("email")).sendKeys("randomuser@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.id("SubmitLogin")).click();
    }


    public void addTshirtToCart(){

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a")).click();

        Actions hover = new Actions(driver);
        WebElement Elem_to_hover = driver.findElement(By.cssSelector(".lnk_view > span:nth-child(1)"));
        hover.moveToElement(Elem_to_hover);
        hover.build();
        hover.perform();

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/a[2]/span/i")).click();
        new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]"))).selectByVisibleText("M");
        driver.findElement(By.xpath("//*[@id=\"color_14\"]")).click();
        driver.findElement(By.cssSelector("button.exclusive")).click();
    }


    public void checkout(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/div/div[3]/textarea")).sendKeys("This is some comment");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button")).click();
    }


    public void signOut(){
        driver.findElement(By.cssSelector(".logout")).click();
    }


}
