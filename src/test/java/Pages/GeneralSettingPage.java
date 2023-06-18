package Pages;
import org.openqa.selenium.Keys;

public class GeneralSettingPage extends loginPage{

    public void SetBusinsessName(){
        TakeInputName("business_name", Keys.BACK_SPACE + "Ikra chowdhury ");
    }
    public void SetDomainNmae(){
        TakeInputName("site_url", "  https://github.com/");
    }
    public void SetLicenceKey(){
        TakeInputName("license_key", "Keynowkshii" + Keys.BACK_SPACE);
    }
    public int SetWebStatus(){
        var numberOfSelectedOption = Dropdown("site_offline", "Yes");
        return numberOfSelectedOption.size();
    }
    public void SetOffLineMsg(){
        TakeInputId("offmsg", "Nowkshis website");
    }
    public void SetDefaulColor(){
        TakeInputId("theme_color", "#330000");
    }
    public void ClickUpdateButton(){
        ClickButtonXpath("/html/body/main/section/div[2]/form/div/div/div[1]/div[1]/div/div[11]/button");
    }
}
