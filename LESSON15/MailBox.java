import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.Keys.SHIFT;
import static org.openqa.selenium.Keys.SPACE;


public class MailBox {

    @FindBy(id = "mailbox:login")
    private WebElement loginField;
    @FindBy(id = "mailbox:password")
    private WebElement passwordField;
    @FindBy(xpath = ".//span[@class='compose-button__wrapper']")
    private WebElement sendLetter;
    @FindBy(xpath = "(.//label[@class='container--zU301'])[1]")
    private WebElement whomField;
    @FindBy(xpath = "(.//input[@class='container--H9L5q size_s--3_M-_'])[2]")
    private WebElement topicField;
    @FindBy(xpath = ".//div[@tabindex= '505']")
    private WebElement textField;
    @FindBy(xpath = "(.//div[@tabindex= '505']/div/div)[1]")
    private WebElement nullField;
    @FindBy(xpath = ".//span[@class='button2__txt' and contains(text(),'Отправить')]")
    private WebElement sendTo;


    WebDriver driver;

    public MailBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login(String login, String password) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.submit();
    }


    public void stepZero()
    {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        sendLetter.click();
    }

    public void stepFirst(String friends)
    {
        whomField.sendKeys(friends);
    }
    public void stepSecond(String topic)
    {
        topicField.click();
        topicField.sendKeys(topic);
    }


    public void stepThird(String text)
    {
        textField.click();
        nullField.click();
        textField.sendKeys(text);
    }

    public void stepForth()
    {
        sendTo.click();
    }

}
