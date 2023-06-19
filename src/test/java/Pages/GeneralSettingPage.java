package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralSettingPage{
    WebDriver driver;
    public  GeneralSettingPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    @FindBy(xpath ="html/body/main/section/div[1]/div/div[1]/p")
    WebElement   PageTittle;
    @FindBy(name = "business_name")
    WebElement BusinessNameField;
    @FindBy(name = "site_url")
    WebElement DomainNameField;
    @FindBy(name = "license_key")
    WebElement LicenceKeyField;
    @FindBy(name = "site_offline")
    WebElement StatusDropDown;
    @FindBy(name = "offline_message")
    WebElement  OffLineMsgField;
    @FindBy(id = "theme_color")
    WebElement   ColorBox;//#330000
    @FindBy(xpath ="/html/body/main/section/div[2]/form/div/div/div[1]/div[1]/div/div[11]/button")
    WebElement   UpdateButton;
    @FindBy(className = "success")
    WebElement AlertBox;
    @FindBy(id = "hlogo")
    WebElement   BrandSection;//#330000
    @FindBy(xpath ="/html/body/main/section/div[2]/form/div/div/div[2]/div[1]/div/div[5]/button")
    WebElement   FileUpdateButton;


    public String GetTittle(){
        String pageTittle=PageTittle.getText();
        return pageTittle;
    }
    public void SetBusinsessName(String name){
        BusinessNameField.clear();
        BusinessNameField.sendKeys( name);
    }
    public void SetDomainNmae(String link){
        DomainNameField.clear();
        DomainNameField.sendKeys(link);
    }
    public void SetLicenceKey(String key){
        LicenceKeyField.clear();
        LicenceKeyField.sendKeys(key);
    }
    public int SetWebStatus(){
        var numberOfSelectedOption =Dropdown("Yes");
        return numberOfSelectedOption.size();
    }
    public void SetOffLineMsg(String msg){
    OffLineMsgField.sendKeys(msg);
    }
    public void SetColorBox(String color){
        ColorBox.sendKeys(color);
    }
    public void ClickUpdateButton(){
        UpdateButton.click();
    }
    public String AlertCheck() {
        String alertText = AlertBox.getText();
        return alertText;
    }
    public List Dropdown(String option){
        Select dropDownElement=new Select(StatusDropDown);
        dropDownElement.selectByVisibleText(option);
        List<WebElement> selectElement =dropDownElement.getAllSelectedOptions();
        return selectElement.stream().map(e->e.getText()).collect(Collectors.toList());

    }

    public void Scroll(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",BrandSection);
    }

    public void Fileupload(String absoulateFilePath){
        FileUpdateButton .sendKeys(absoulateFilePath);
    }
    public void ClickFileUploadButton(){
        FileUpdateButton.click();
    }
}
