package Test;

import Pages.*;
import Util.SetUp;
import Util.TestAction;
import Util.WindowManger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GeneralSettingPageTest extends SetUp {
    loginPage loginpage;
    TestAction test;
    DashBord dashBord;
    GeneralSettingPage generalSettingPage;
    WindowManger windowManger;
    String ActualResult;
    @BeforeTest
    public void PageObjects(){
        loginpage= new loginPage(driver);
        test=new TestAction();
        dashBord=new DashBord(driver);
        generalSettingPage=new   GeneralSettingPage(driver);
        windowManger=new WindowManger(driver);

    }
    @Test
    public void MainSettingTest(){
        loginpage.Login("admin@phptravels.com","demoadmin");
        dashBord.ClickSetting();
        dashBord.ClickGeneralSetting();
        generalSettingPage.SetBusinsessName("Nowkshi");
        generalSettingPage.SetDomainNmae("https://phptravels.net/admin/settings.php");
        generalSettingPage.SetLicenceKey("09764");
        int size=generalSettingPage.SetWebStatus();
        test.CheckResultInt(size,1);
        generalSettingPage.SetOffLineMsg("no msg");
        generalSettingPage.SetColorBox("#330000");
        generalSettingPage.ClickUpdateButton();
        ActualResult= generalSettingPage.AlertCheck();
        test.CheckResultString(ActualResult,   "Information Updated\n" + "Infromation has been updated successfully");
        windowManger.GoBack();

    }
    @Test
    public void BrandingPictureUploadTest(){
        try {
            loginpage.Login("admin@phptravels.com", "demoadmin");
            dashBord.ClickSetting();
            dashBord.ClickGeneralSetting();
            generalSettingPage.Scroll();
            generalSettingPage.Fileupload("D:\\SeleniumBasic\\src\\test\\java\\images.png");
            Thread.sleep(500);
            generalSettingPage.Fileupload("D:\\SeleniumBasic\\src\\test\\java\\images.png");
            Thread.sleep(100);
            generalSettingPage.ClickFileUploadButton();
            ActualResult = generalSettingPage.AlertCheck();
            test.CheckResultString(ActualResult, "Information Updated\n" + "Infromation has been updated successfully");
        }catch (Exception ex) {
       }
    }
}
