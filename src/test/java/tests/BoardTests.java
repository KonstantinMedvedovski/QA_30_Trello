package tests;

import data_providers.BoardDP;
import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class BoardTests  extends AppManager {

    @BeforeMethod(alwaysRun = true)
    public void login(){
        User user = new User("konstantinmqatest@gmail.com","Password123!QA");
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewBoardPositiveTest(){
        Board board = Board.builder().boardTitle("11242").build();
        new BoardsPage(getDriver()).createNewBoard(board);
    }



    @Test(dataProvider = "dataProviderBoards",dataProviderClass = BoardDP.class)
    public void createNewBoardPositiveTest_FromDP(Board board){
        new BoardsPage(getDriver()).createNewBoard(board);

    }
}
