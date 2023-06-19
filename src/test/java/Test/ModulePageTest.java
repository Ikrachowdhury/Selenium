package Test;

import Pages.*;
import Util.SetUp;
import Util.TestAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ModulePageTest extends SetUp {
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
    public void ModuleStatusTest(){
        loginpage.Login("admin@phptravels.com","demoadmin");
        dashBord.ClickModule();
        modulepage.SetStatus(2);
        ActualResult= modulepage.AlertCheck();
        test.CheckResultString(ActualResult, "Module Updated\n" +
               "Module status updated successfully");
        //modulepage.SetStatusAll();
    }
        @Test
    public void ModuleSettingTest(){
      try{
          loginpage.Login("admin@phptravels.com","demoadmin");
          dashBord.ClickModule();
          modulepage.ClickSetting(2);
          ActualResult=moduleSetting.GetTittle();
          test.CheckResultString(ActualResult,modulepage.pageTittleExpected+" Settings");
          Thread.sleep(1000);

      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }

    }

}
