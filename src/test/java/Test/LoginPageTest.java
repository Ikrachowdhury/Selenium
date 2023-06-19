package Test;
import Pages.loginPage;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends SetUp {
    loginPage loginpage;
    TestAction test;
    @BeforeTest
    public void PageObjects(){
         loginpage= new loginPage(driver);
         test=new TestAction();
    }

    @Test
    public void LoginTest(){

        loginpage.Login("admin@phptravels.com","demoadmin");
        test.CheckResultString(driver.getTitle(),"Dashboard");

    }
}
