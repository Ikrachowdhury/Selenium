package Test;

import Pages.DashBord;
import Pages.MoDuleSettingPage;
import Pages.Modules;
import Pages.loginPage;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ModuleSettingPageTest extends SetUp {
    loginPage loginpage;
    TestAction test;
    DashBord dashBord;
    Modules modulepage;
    MoDuleSettingPage moduleSetting;
    String ActualResult;
    @BeforeTest
    public void PageObjects(){
        loginpage= new loginPage(driver);
        test=new TestAction();
        dashBord=new DashBord(driver);
        modulepage=new Modules(driver);
        moduleSetting=new MoDuleSettingPage(driver);
    }
    @Test
    public void BasicSettingActionTest(){
        try{
            loginpage.Login("admin@phptravels.com","demoadmin");
            dashBord.ClickModule();
            modulepage.ClickSetting(1);
            moduleSetting.SetCheckBoxStatus();
            Thread.sleep(1000);
            moduleSetting.AlertBox();
            moduleSetting.SetColorBox("#330000");
            Thread.sleep(1000);
            moduleSetting.ClickSubmitButton();
            Thread.sleep(1000);

        }catch (Exception ex) {
            System.out.println(ex);
        }


    }
}
