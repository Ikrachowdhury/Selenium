import org.openqa.selenium.WebDriver;

public class WindowManger {
    WebDriver driver;
    WebDriver.Navigation navigate;
    public   WindowManger(WebDriver driver){
        this.driver=driver;
        this.navigate=driver.navigate();
    }
    public void GoBack(){
        driver.navigate().back();
    }
    public void GoForwarward(){

        navigate.forward();
    }
    public void RefreshPage(){
         navigate.refresh();
    }
    public void GoTO(String url){
        navigate.to(url);
    }
    public void SwitchToTab(String tabtittle){
        var windows= driver.getWindowHandles();
        for(String window:windows){
            driver.switchTo().window(window);
            if(tabtittle.equals(driver.getTitle())){
                break;
            }
        }
    }

}
