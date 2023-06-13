import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashBord extends loginPage{
    public DashBord(){
        super();
        this.driver= driver;

    }
    @Test
    public void DropDown() throws InterruptedException {
        try{
            Login();
            ClickButtonClass("collapsed");
            ClickButtonLink("General Settings");
            var numberOfSelectedOption= Dropdown("site_offline","Yes");
            CheckResultInt(numberOfSelectedOption.size(),1);
            //Thread.sleep(10000);
        }catch(Exception ex){
            System.out.println(ex);

        }
    }

    @Test
    public void MainSetting(){
        try{
            DropDown();
            TakeInputName( "site_url","https://github.com/");
            TakeInputName("license_key","Keynowkshi");
            TakeInputId("offmsg","Nowkshis website");
            TakeInputId("theme_color","#330000");
            ClickButtonXpath("/html/body/main/section/div[2]/form/div/div/div[1]/div[1]/div/div[11]/button");
            Thread.sleep(500);
            String  alertText=driver.findElement(By.className("vt-card")).getText();
            System.out.println(alertText);
            CheckResultString(alertText,"Information Updated\n" +
                    "Infromation has been updated successfully");

        }catch(Exception ex){
            System.out.println(ex);

        }

    }

}
