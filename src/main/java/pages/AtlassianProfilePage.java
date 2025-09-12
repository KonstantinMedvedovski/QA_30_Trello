package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class AtlassianProfilePage extends BasePage{

    public AtlassianProfilePage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//div[@data-test-selector='profile-hover-info']")
    WebElement btnProfilePhoto;
    @FindBy(xpath = "//button[@data-testid='change-avatar']")
    WebElement btnChangeProfilePhoto;
    @FindBy(xpath = "//input[@data-testid='image-navigator-input-file']")
    WebElement inputUploadAPhoto;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnUpload;
    @FindBy(xpath = "//div[@class='_v564glyw _1bsb1kdj _kqswstnw _u7coidpf _1eqkauwl _t9ec1ygq _1pbyqfx8 _12a7luct']")
    WebElement popUpMessage;

    public void changeMyProfilePhoto(String photoPath){
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfilePhoto).pause(2000).click().perform();
        clickWait(btnChangeProfilePhoto,5);
        File photo = new File(photoPath);
        inputUploadAPhoto.sendKeys(photo.getAbsolutePath());
        clickWait(btnUpload,5);

    }

    public boolean validateMessage(String text){
        return validateTextInElementWait(popUpMessage,text,10);
    }
}
