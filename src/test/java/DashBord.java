import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashBord extends loginPage{
    public DashBord(){
        super();
        this.driver= driver;

    }
    @Test
    public void GenerralSetting() throws InterruptedException {
        try{
            Login();
            ClickButtonClass("collapsed");
            ClickButtonLink("General Settings");    //Thread.sleep(10000);
        }catch(Exception ex){
            System.out.println(ex);

        }
    }
    public void AlertSuccess(){
        String  alertText=driver.findElement(By.className("vt-card")).getText();
        CheckResultString(alertText,"Information Updated\n" +
                "Infromation has been updated successfully");
    }

    @Test
    public void GeneralMainSetting(){
        try{
            GenerralSetting();
            TakeInputName( "business_name",Keys.BACK_SPACE+"Ikra chowdhury ");
            TakeInputName( "site_url","  https://github.com/");
            TakeInputName("license_key","Keynowkshii"+Keys.BACK_SPACE);
            var numberOfSelectedOption= Dropdown("site_offline","Yes");
            CheckResultInt(numberOfSelectedOption.size(),1);
            TakeInputId("offmsg", "Nowkshis website");
            TakeInputId("theme_color","#330000");
            ClickButtonXpath("/html/body/main/section/div[2]/form/div/div/div[1]/div[1]/div/div[11]/button");
            Thread.sleep(500);
            AlertSuccess();
            Thread.sleep(1000);

        }catch(Exception ex){
            System.out.println(ex);

        }

    }
    @Test
    public void GeneralBranding(){
        try{
            GenerralSetting();
            Scroll("hlogo");
            Fileupload("hlogo","D:\\SeleniumBasic\\src\\test\\java\\images.png");
            ClickButtonXpath("/html/body/main/section/div[2]/form/div/div/div[2]/div[1]/div/div[5]/button");
            Thread.sleep(500);
            Fileupload("favimage","D:\\SeleniumBasic\\src\\test\\java\\images.png");
            ClickButtonXpath("/html/body/main/section/div[2]/form/div/div/div[2]/div[1]/div/div[5]/button");
            Thread.sleep(100);
            String  alertText=driver.findElement(By.className("vt-card")).getText();
            CheckResultString(alertText,"Information Updated\n" +
                    "Infromation has been updated successfully");
            Thread.sleep(1000);

        }catch(Exception ex){
            System.out.println(ex);

        }

    }

}
