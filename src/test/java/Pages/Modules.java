package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Modules  {
    WebDriver driver;
    int lenght;
    public String pageTittleExpected;
    public Modules(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    @FindAll({
            @FindBy(className ="modules_sort")
    })
    List<WebElement> Table;
    @FindBy(className = "success")
    WebElement AlertBox;

    public void  ClickSetting(int noOfSetting){
        Clickelement(noOfSetting,"clickSetting");
    }
    public void SetStatus(int noOfSetting){
        Clickelement(2,"clickStatus");
    }
    public void SetStatusAll(){
        Clickelement(2,"clickStatusAll");
    }
    public void Clickelement(int elementNumber,String
            type){

        try{
            WebElement array[]= ArrayOfTableElements();
            lenght=array.length;
            for (int i = 0; i <lenght; i++) {

//            String tag=array[i].findElement(By.className("fw-light")).getText();
//            System.out.println(tag);
                if (type.equals("clickSetting")) {
                    if (lenght > elementNumber && i == elementNumber) {
                        String Text= array[i].findElement(By.xpath("//*[@id=\"SORT\"]/tr[3]/th[3]")).getText();
                        String aarray[]=Text.split(" ");
                        pageTittleExpected=aarray[0];
                        System.out.println(pageTittleExpected);
                        array[i].findElement(By.className("btn-danger")).click();
                        // pageTittle=driver.getTitle();
                    }
                } else if (type.equals("clickStatus")) {
                    if (lenght > elementNumber && i == elementNumber) {
                        array[i].findElement(By.className("form-check-input")).click();
                    }
                } else if (type.equals("clickStatusAll")) {
                    array[i].findElement(By.className("form-check-input")).click();
                    Thread.sleep(100);
                }
                Thread.sleep(100);
//                array[i].findElement(By.className("fw-light")).getText();
//               Thread.sleep(100);
            }


        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public WebElement[] ArrayOfTableElements(){
        List<WebElement> elements = Table;
        WebElement[] elementArray = new WebElement[elements.size()];
        elements.toArray(elementArray);

        return elementArray;

    }
        public String AlertCheck() {
        String alertText = AlertBox.getText();
        return alertText;
    }

}

