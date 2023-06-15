import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Modules extends DashBord{
    int lenght;
    String pageTittleExpected;
  @BeforeTest
    public void ModulePageTest(){
        ClickModule();
        CheckResultString(pageTittle,"Modules");
    }
    public void AlertSuccess() {

        String alertText = driver.findElement(By.className("success")).getText();
        System.out.println(alertText);
       CheckResultString(alertText, "Module Updated\n" +
               "Module status updated successfully");
    }
    public int ArrayOfElements(){
        WebElement array[]=  GetElementsByClass("modules_sort");
        lenght=array.length;
        return  lenght;
    }
    public void Clickelement(int elementNumber,String type){

        try{
            WebElement array[]=  GetElementsByClass("modules_sort");
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
    @Test
    public void ModuleSettingTest(){
      try{
          Clickelement(2,"clickSetting");
          String pageTittleActual=GetELementByXpath("/html/body/main/section/div[1]/div/div[1]/p");
          System.out.println(pageTittleActual);
          CheckResultString(pageTittleActual,pageTittleExpected);
          Thread.sleep(1000);
          GetWindowManager().GoBack();
          Thread.sleep(1000);

      }catch (Exception ex){
          System.out.println(ex);
      }

    }
    @Test
    public void ModuleStatusTest(){
        try{
          Clickelement(2,"clickStatus");
          Thread.sleep(1000);
          AlertSuccess();
            Thread.sleep(1000);

          //  Clickelement(2,"clickStatusAll");

        }catch (Exception ex){
            System.out.println(ex);
        }

    }
}

