package Util;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import org.openqa.selenium.Keys;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BaseSetUp {
    public WebDriver driver;


    public void  OpenChrome(){
         driver= new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


     }
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

     public void TakeInputId(String id,String inputString){
       WebElement element= driver.findElement(By.id(id));
       element.clear();
       element.sendKeys(inputString);

     }
    public void TakeInputName(String name,String inputString){
        WebElement element= driver.findElement(By.name(name));
        element.clear();
        element.sendKeys(inputString);

    }
     public String ClickButtonId  (String id){
            driver.findElement(By.id(id)).click();
            return driver.getTitle();
     }

    public String ClickButtonLink(String link){
        driver.findElement(By.linkText(link)).click();
        return driver.getTitle();
    }
    public String ClickButtonXpath(String link){
        driver.findElement(By.xpath(link)).click();
        return driver.getTitle();
    }
    public String ClickButtonCss(String css){
        driver.findElement(By.cssSelector(css));
        return driver.getTitle();
    }

    public WebElement[] GetElementsByClass(String classname){
        List<WebElement> elements = driver.findElements(By.className(classname));
        WebElement[] elementArray = new WebElement[elements.size()];
        elements.toArray(elementArray);

        return elementArray;

    }
    public String GetELementByXpath(String xpath){
        String tittle = driver.findElement(By.xpath(xpath)).getText();
        return tittle;
    }
    public void Fileupload(String id,String absoulateFilePath){
        driver.findElement(By.id(id)).sendKeys(absoulateFilePath);


    }
    public List Dropdown(String dropdown,String option){
        Select dropDownElement=new Select(driver.findElement(By.name(dropdown)));
        dropDownElement.selectByVisibleText(option);
        List<WebElement> selectElement =dropDownElement.getAllSelectedOptions();
        return selectElement.stream().map(e->e.getText()).collect(Collectors.toList());

    }

    public String AlertGetText(){
        //driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        return alert.getText();

    }
    public void Scroll(String  id){
        WebElement element= driver.findElement(By.id(id));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);


    }

     public  void CheckResultString(String ActualResult,String Expected){
         try{
             Assert.assertEquals(ActualResult,Expected);
             Thread.sleep(1000);
         }catch(Exception ex){
             System.out.println(ex);

         }
     }
    public  void CheckResultInt(int ActualResult,int Expected) {
        try {
            Assert.assertEquals(ActualResult, Expected);
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
    public WindowManger GetWindowManager(){
        return new WindowManger(driver);
    }
    @AfterMethod
    public void RecordFailure(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            var camera =(TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            File destination = new File("D:\\SeleniumBasic\\src\\test\\screenshot\\"+result.getName()+".png");
            try{
                Files.move(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        // System.out.println("Screenshot taken: "+screenshot.getAbsolutePath();
    }
}
