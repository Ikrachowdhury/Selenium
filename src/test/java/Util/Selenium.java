package Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium {
    public WebDriver driver;
    @BeforeTest
    public void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void openBrowser() throws InterruptedException {
        driver.get("https://phptravels.net/admin/login.php");
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.id("password")).sendKeys("demoadmin");
        driver.findElement(By.id("submit")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Dashboard");
        Thread.sleep(1000);

    }

}
