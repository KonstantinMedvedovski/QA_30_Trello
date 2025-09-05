package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BoardsPage extends BasePage {
    public BoardsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//button[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnCreateNewBoardSubmit;

    public void createNewBoard(Board board) {
        pause(3);
        btnCreateNewBoard.click();
        inputBoardTitle.sendKeys(board.getBoardTitle());
        //pause(5);
      // btnCreateNewBoardSubmit.click();
    }

    public void clickBtnCreateNewBoardSubmit(){
        clickWait(btnCreateNewBoardSubmit,3);
        pause(5);
        btnCreateNewBoardSubmit.click();
    }
}
