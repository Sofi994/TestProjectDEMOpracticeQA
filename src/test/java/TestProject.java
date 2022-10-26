import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.nashorn.internal.ir.Terminal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestProject {

    public static WebDriver driver;
    public static WebDriverWait wdWait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.get("https://example.testproject.io/web/");
        driver.manage().window().maximize();
    }
    @Test
    public void TestProject1(){
        WebElement fullName = driver.findElement(By.id("name"));
        fullName.sendKeys("John Doe");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("12345");
        WebElement logINbtn = driver.findElement(By.id("login"));
        logINbtn.click();
        WebElement logOutbt = driver.findElement(By.id("logout"));
        Assert.assertTrue(logOutbt.isDisplayed());
        WebElement textHello = driver.findElement(By.id("greetings"));
        Assert.assertTrue(textHello.isDisplayed());
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByValue("US");
        WebElement Adress = driver.findElement(By.id("address"));
        Adress.sendKeys("Washington DC, The White House");
        WebElement Email = driver.findElement(By.id("email"));
        Email.sendKeys("mr.president@thewhitehouse.gov");
        WebElement Phone = driver.findElement(By.id("phone"));
        Phone.sendKeys("+202-123-456-789");
        WebElement SaveBtn = driver.findElement(By.id("save"));
        SaveBtn.click();
        WebElement SaveLabel = driver.findElement(By.xpath("//*[@id='saved']"));
        Assert.assertTrue(SaveLabel.isDisplayed());
        WebElement logOUT = driver.findElement(By.id("logout"));
        logOUT.click();

    }
    @After
    public void EndOfTest(){
        driver.quit();
    }

}
