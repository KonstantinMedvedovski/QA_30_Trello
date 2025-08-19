package tests;

import manager.AppManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTest extends AppManager {
    @Test
    public void loginPositiveTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
    }
}
