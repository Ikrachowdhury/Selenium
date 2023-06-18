package Pages;
import Util.*;
import Test.LoginPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DashBord  extends loginPage {


    public void EndTest(){
        AfterTest();
    }
    String pageTittle;
    public void ClickAlert(){
        ClickButtonXpath("/html/body/main/header/ul/li[1]/div/button");
    }
    public void ClickSetting(){
        pageTittle=ClickButtonXpath("/html/body/main/header/ul/li[2]/button") ;
    }
    public void ClickGeneralSetting(){
        pageTittle= ClickButtonLink("General Settings");
    }
    public void ClickModule(){
        pageTittle=ClickButtonXpath("/html/body/main/header/ul/li[3]/a");
    }

//    @Test
//    public void GenerralSetting() throws InterruptedException {
//        try {
//           // ClickButtonClass("collapsed");
//            ClickButtonLink("General Settings");    //Thread.sleep(10000);
//        } catch (Exception ex) {
//            System.out.println(ex);
//
//        }
//    }
//
//    public void AlertSuccess() {
//        String alertText = driver.findElement(By.className("vt-card")).getText();
//        CheckResultString(alertText, "Information Updated\n" +
//                "Infromation has been updated successfully");
//    }
//
//    @Test
//    public void GeneralMainSetting() {
//        try {
//            GenerralSetting();
//            TakeInputName("business_name", Keys.BACK_SPACE + "Ikra chowdhury ");
//            TakeInputName("site_url", "  https://github.com/");
//            TakeInputName("license_key", "Keynowkshii" + Keys.BACK_SPACE);
//            var numberOfSelectedOption = Dropdown("site_offline", "Yes");
//            CheckResultInt(numberOfSelectedOption.size(), 1);
//            TakeInputId("offmsg", "Nowkshis website");
//            TakeInputId("theme_color", "#330000");
//            ClickButtonXpath("/html/body/main/section/div[2]/form/div/div/div[1]/div[1]/div/div[11]/button");
//            Thread.sleep(500);
//            AlertSuccess();
//            Thread.sleep(1000);
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//
//        }
//
//    }
//
//    @Test
//    public void GeneralBranding() {
//        try {
//            GenerralSetting();
//            Scroll("hlogo");
//            Fileupload("hlogo", "D:\\SeleniumBasic\\src\\test\\java\\images.png");
//            ClickButtonXpath("/html/body/main/section/div[2]/form/div/div/div[2]/div[1]/div/div[5]/button");
//            Thread.sleep(500);
//            Fileupload("favimage", "D:\\SeleniumBasic\\src\\test\\java\\images.png");
//            ClickButtonXpath("/html/body/main/section/div[2]/form/div/div/div[2]/div[1]/div/div[5]/button");
//            Thread.sleep(100);
//            String alertText = driver.findElement(By.className("vt-card")).getText();
//            CheckResultString(alertText, "Information Updated\n" +
//                    "Infromation has been updated successfully");
//            Thread.sleep(1000);
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//
//        }
//
//    }
//
//
//    /*@Test
//     public void Alert() {
//        try {
//            ClickButtonXpath("/html/body/main/header/ul/li[1]/div/button");
//            GetElementsByClass("");
//            System.out.println(el.length);
//            for (int i = 0; i < el.length; i++) {
//                el[i].findElement(By.className("btn")).click();
//                System.out.println("lol");
//                Thread.sleep(100);
//            }
//            String arrayLength;
//            if (el.length <= 0) {
//                arrayLength = "1";
//            } else {
//                arrayLength = "2";
//            }
//           // CheckResultString(arrayLength, "1");
//        } catch (Exception ex) {
//            System.out.println(ex);
//
//        }
//    }*/

}
