package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoDuleSettingPage {
    WebDriver driver;
    public MoDuleSettingPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBy(xpath = "/html/body/main/section/div[1]/div/div[1]/p")
    WebElement PageTittle;
    @FindBy(id = "checkedbox")
    WebElement CheckBox;
    @FindBy(name ="module_color")
    WebElement ColorBox;
    @FindBy(xpath = "/html/body/main/section/div[1]/div/div[1]/p")
    WebElement SubmitButton;
    @FindBy(xpath = "/html/body/main/section/div[1]/div/div[2]/a")
    WebElement BackButton;

    public String GetTittle(){
        String pageTittle=PageTittle.getText();
        return pageTittle;
    }
    public  void  SetCheckBoxStatus(){
        CheckBox.click();
    }
    public void SetColorBox(String color){
        ColorBox.sendKeys(color);
    }
    public void ClickSubmitButton(){
        SubmitButton.click();
    }
    public void ClickBacktButton(){
         BackButton.click();
    }
    public void AlertBox(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().parentFrame();

        //return alert.getText();
    }
}

