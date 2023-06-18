package Test;
import Pages.loginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
    //WebDriver driver= null;

    static loginPage loginpage= new loginPage();
    @BeforeTest
    public void OpenBrowser(){
        loginpage.OpenChrome();
    }
    @Test
    public static void LoginTest(){
        loginpage.GoToLoginPage("https://phptravels.net/admin/login.php");
        loginpage.SetEmail("admin@phptravels.com");
        loginpage.SetPassWord("demoadmin");
        String ActualResult=loginpage.ClickSubmitButton();
        loginpage.TestAction( ActualResult);

    }
}
