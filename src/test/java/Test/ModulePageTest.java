package Test;

import Pages.Modules;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ModulePageTest {
    Modules modulepage=new Modules();
    @BeforeTest
    public void Login(){
        modulepage.Login();
    }
   @Test
    public void ModuleSettingTest(){
        modulepage.GotoModulePage();
        modulepage.ClickSetting(2);
    }
    @Test
    public void ModuleStatusTest(){
        modulepage.GotoModulePage();
        modulepage.SetStatus(2);
        //modulepage.SetStatusAll();
    }
    @AfterTest
    public void EndTest(){
        modulepage.EndTest();
    }
}
