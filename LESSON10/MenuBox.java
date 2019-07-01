package Box;

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


public class MenuBox {

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = ".//a[@href='/inbox/']")
    private WebElement inbox;

    @FindBy(xpath = "(.//div[@class='llc__content'])[1]")
    private WebElement message;
    @FindBy(xpath = "(.//div[@class='llc__content'])[1]")
    private WebElement message2;

    @FindBy(xpath = ".//a[@href='/spam/']")
    private WebElement spam;

    @FindBy(xpath = ".//span[@class='compose-button__wrapper']")
    private WebElement sendLetter;

    @FindBy(xpath = "(.//label[@class='container--zU301'])[1]")
    private WebElement whomField;

    @FindBy(xpath = "(.//input[@class='container--H9L5q size_s--3_M-_'])[2]")
    private WebElement topicField;

    @FindBy(xpath = ".//div[@tabindex= '505']")
    private WebElement textField;

    @FindBy(xpath = ".//input[@tabindex='515']")
    private WebElement textMainField;

    @FindBy(xpath = ".//span[@class='button2__txt' and contains(text(),'Отправить')]")
    private WebElement sendTo;

    @FindBy(xpath = "(.//div[@tabindex= '505']/div/div)[1]")
    private WebElement nullField;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div/div[2]")
    private WebElement nullField2;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div/div")
    private WebElement nullField3;
    @FindBy(xpath = ".//div[@class='letter__body']")
    private WebElement nullField4;

    @FindBy(xpath = "(.//button[@class='ll-fs'])[1]")
    private WebElement flag1;
    @FindBy(xpath = "(.//button[@class='ll-fs'])[2]")
    private WebElement flag2;
    @FindBy(xpath = "(.//button[@class='ll-fs'])[3]")
    private WebElement flag3;

    @FindBy(xpath = "(.//span[@class = 'button2__wrapper'])[1]")
    private WebElement chooseAll;
    @FindBy(xpath = "(.//span[@class='button2__wrapper'])[8]")
    private WebElement allMenu;
    @FindBy(xpath = ".//span[@class='list-item__text' and contains(text(), 'Снять флажок')]")
    private WebElement removeAllFlag;

    WebDriver driver;

    public MenuBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String password) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public void goToSpam() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        inbox.click();
        message.click();
        nullField2.click();
        Actions keyAction = new Actions(driver);
        keyAction.keyDown(SHIFT).sendKeys("J").perform();
    }

    public void comeFromSpam() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        spam.click();
        nullField3.click();
        message2.click();
        nullField4.click();
        Actions keyAction = new Actions(driver);
        keyAction.keyDown(SHIFT).sendKeys("J").perform();
    }

    public void sendMessageToFriends(String friends, String topic, String text) {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        sendLetter.click();
        whomField.sendKeys(friends);
        topicField.click();
        topicField.sendKeys(topic);
        textField.click();
        nullField.click();
        textField.sendKeys(text);
        sendTo.click();
    }

    public void putFlag() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        inbox.click();
        flag1.click();
        flag2.click();
        flag3.click();
    }

    public void removeAllFlag() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        inbox.click();
        chooseAll.click();
        allMenu.click();
        removeAllFlag.click();
        chooseAll.click();
    }


}
