import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{

    private final String GAME_PIN = "704208";
    private int userNr = 0;
    private String userName;

    @FindBy(id = "game-input")
    private WebElement game_input;

    @FindBy(xpath = "//button[contains(text(),'Enter')]")
    private WebElement submit_button;

    @FindBy(id = "nickname")
    private WebElement nickname;

    @FindBy(xpath = "//button[contains(text(),'OK, go!')]")
    private WebElement finish;


    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterGamePin(){
        this.game_input.sendKeys(GAME_PIN);
    }

    public void enterNickname(){
        this.nickname.sendKeys(nameGenerator());
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void pressFinishButton(){
        this.finish.click();
    }

    private String nameGenerator(){
        userName = ("Joker" + userNr);
        userNr++;
        return userName; //This was left behind from a test to make it repeat and add multiple people into a kahoot game, the problem is that if the webpage is closed, the account gets kicked of the kahoot.
    }
}