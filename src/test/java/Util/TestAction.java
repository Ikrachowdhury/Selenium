package Util;

import org.testng.Assert;

public class TestAction {
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

}
