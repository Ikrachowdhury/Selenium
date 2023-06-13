import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasicSetUp {
    public WebDriver driver;

    @BeforeTest
    public void  OpenChrome(){
         driver= new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


     }
    @AfterTest
     public void AfterTest(){

        driver.close();
     }
     public void ClickLink(String link){
        try {
            driver.get(link);
            Thread.sleep(50);

        }catch (Exception ex){
            System.out.println(ex);
        }

     }

     public void TakeInput(String id,String inputString){
        driver.findElement(By.id(id)).sendKeys(inputString);

     }
     public String ClickButtonId  (String id){
            driver.findElement(By.id(id)).click();
            return driver.getTitle();
     }
    public String ClickButtonClass  (String classname){
        driver.findElement(By.className(classname)).click();
        return driver.getTitle();
    }
    public String ClickButtonLink(String link){
        driver.findElement(By.linkText(link)).click();
        return driver.getTitle();
    }
    public List Dropdown(String dropdown,String option){
        Select dropDownElement=new Select(driver.findElement(By.name(dropdown)));
        dropDownElement.selectByVisibleText(option);
        List<WebElement> selectElement =dropDownElement.getAllSelectedOptions();
        return selectElement.stream().map(e->e.getText()).collect(Collectors.toList());



    }
     public  void CheckResultString(String ActualResult,String Expected){
         try{
             Assert.assertEquals(ActualResult,Expected);
             Thread.sleep(1000);
         }catch(Exception ex){
             System.out.println(ex);

         }
     }
    public  void CheckResultInt(int ActualResult,int Expected){
        try{
            Assert.assertEquals(ActualResult,Expected);
            Thread.sleep(1000);
        }catch(Exception ex){
            System.out.println(ex);

        }
    }


}
