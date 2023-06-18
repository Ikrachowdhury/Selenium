package Pages;
import Util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage  {
    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement  EmailField;
    @FindBy(id = "password")
    WebElement PasswordField;
    @FindBy(id = "submit")
    WebElement SubmitButton;

    public void GoToLoginPage(String link){
        driver.get(link);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void SetEmail(String email){
        EmailField.sendKeys(email);
  }
  public void SetPassWord(String password){
      PasswordField.sendKeys(password);
  }
  public String ClickSubmitButton(){
      SubmitButton.click();
  }


    public void  Login(){
        GoToLoginPage("https://phptravels.net/admin/login.php");
        SetEmail("admin@phptravels.com");
        SetPassWord("demoadmin");
        ClickSubmitButton();
    }
}
