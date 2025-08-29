package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends AppManager {
    @Test
    public void loginPositiveTest(){
        User user = new User("konstantinmqatest@gmail.com","Password123!QA");
        logger.info("login test with user"+ user.getEmail()+"  "+user.getPassword());
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl("boards"));
    }
}
