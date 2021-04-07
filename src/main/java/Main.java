import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
    }

    @Test
    public void test() {
        this.driver.get("https://www.saucedemo.com/");
        this.driver.manage().window().fullscreen();
        WebElement login = driver.findElement(By.cssSelector("#user-name"));
        login.click();
        login.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys("secret_sauce");
        this.driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        this.driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        this.driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        this.driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        this.driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        this.driver.findElement(By.id("shopping_cart_container")).click();
        this.driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
        this.driver.findElement(By.id("shopping_cart_container")).click();
        this.driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        WebElement name = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        name.click();
        name.sendKeys("Konrad");
        WebElement secondName = driver.findElement(By.id("last-name"));
        secondName.click();
        secondName.sendKeys("Siborenko");
        WebElement code = driver.findElement(By.id("postal-code"));
        code.click();
        code.sendKeys("02-601");
        this.driver.findElement(By.id("continue")).click();
        this.driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        this.driver.findElement(By.name("back-to-products")).click();
        Assert.assertTrue(this.driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).isDisplayed());
    }

    @After
    public void end() {
        this.driver.quit();
    }
}
