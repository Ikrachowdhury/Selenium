package Pages;
import Util.*;

public class loginPage extends BaseSetUp{

    public void GoToLoginPage(String link){
        ClickLink("https://phptravels.net/admin/login.php");

    }
    public void SetEmail(String email){
        TakeInputId("email",email);
        ClickLink(email);
  }
  public void SetPassWord(String password){
      TakeInputId("password",password);
  }
  public String ClickSubmitButton(){
       return ClickButtonId("submit");
  }
  public void TestAction(String ActualResult ){
      CheckResultString(ActualResult,"Dashboard");
  }
    public void  Login(){
        GoToLoginPage("https://phptravels.net/admin/login.php");
        SetEmail("admin@phptravels.com");
        SetPassWord("demoadmin");
        ClickSubmitButton();
    }
}
