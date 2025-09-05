package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import java.util.Random;

public class DeleteBoardsTests extends AppManager {
    BoardsPage boardsPage;
    MyBoardPage myBoardPage;

    @BeforeMethod(alwaysRun = true)
    public void createBoard() {
        User user = new User("konstantinmqatest@gmail.com", "Password123!QA");
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        int random = new Random().nextInt(1000);
        Board board = Board.builder().boardTitle("board3").build();
        boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreateNewBoardSubmit();
        myBoardPage = new MyBoardPage(getDriver());
    }

    @Test
    public void deleteBoardPositiveTest() {
        myBoardPage.deleteBoard();
    }

}
