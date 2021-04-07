import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {

    @BeforeClass
    public static void setup() {
        WebDriverManager.edgedriver().setup();
    }

    @Test
    public void test() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().fullscreen();
        WebElement login = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        login.click();
        login.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.click();
        password.sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        WebElement name = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        name.click();
        name.sendKeys("Konrad");
        WebElement secondName = driver.findElement(By.id("last-name"));
        secondName.click();
        secondName.sendKeys("Siborenko");
        WebElement code = driver.findElement(By.id("postal-code"));
        code.click();
        code.sendKeys("02-601");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        driver.findElement(By.name("back-to-products")).click();
        driver.quit();
    }

}
