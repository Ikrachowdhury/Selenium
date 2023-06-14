import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginPage extends BaseSetUp{

    public loginPage(){
        super();
        this.driver=driver;
    }
   // @Test(priority = 2)
   @BeforeTest
    public void Login(){
     ClickLink("https://phptravels.net/admin/login.php");
     TakeInputId("email","admin@phptravels.com");
     TakeInputId("password","demoadmin");
     String ActualResult= ClickButtonId("submit");
    // CheckResult(ActualResult,"Dashboard");

    }
}
