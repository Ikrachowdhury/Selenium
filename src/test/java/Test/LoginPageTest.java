package Test;
import Pages.loginPage;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends SetUp {
    loginPage loginpage= new loginPage(driver);
    TestAction test=new TestAction();
    @Test
    public void LoginTest(){
        loginpage.Login("admin@phptravels.com","demoadmin");
        test.CheckResultString(driver.getTitle(),"Dashboard");

    }
}
