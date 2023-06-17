package Test;

import Pages.GeneralSettingPage;

public class GeneralSettingPageTest {
    GeneralSettingPage generalSettingPage=new GeneralSettingPage();
    public void MainSettingTest{
        generalSettingPage.SetBusinsessName();
        generalSettingPage.SetDomainNmae();
        generalSettingPage.SetLicenceKey();
        generalSettingPage.SetOffLineMsg();
        generalSettingPage.SetWebStatus();
        generalSettingPage.SetDefaulColor();
        generalSettingPage.ClickUpdateButton();
    }
}
