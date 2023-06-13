import org.testng.annotations.Test;

public class DashBord extends loginPage{
    public DashBord(){
        super();
        this.driver= driver;

    }
    @Test
    public void DropDown() throws InterruptedException {
        Login();
        ClickButtonClass("collapsed");
        ClickButtonLink("General Settings");
        var numberOfSelectedOption= Dropdown("site_offline","Yes");
        CheckResultInt(numberOfSelectedOption.size(),1);
        Thread.sleep(10000);

    }
    @Test

}
