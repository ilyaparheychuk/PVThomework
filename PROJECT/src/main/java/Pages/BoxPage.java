package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.SHIFT;

public class BoxPage {

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

    @FindBy(xpath = "/html/body/div[8]/div/div/div[2]/div[2]/div/div/div[1]/span/span")
    private WebElement nullField5;

    @FindBy(xpath = "(.//button[@type='button' and @title='Пометить флажком'])[1]")
    private WebElement flag1;

    @FindBy(xpath = ".//button[@type='button' and @title='Снять флажок']")
    private WebElement checkFlag1;

    @FindBy(xpath = "(.//button[@type='button' and @title='Снять флажок'])[1]")
    private WebElement checkFlag2;

    @FindBy(xpath = "(.//span[@class = 'button2__wrapper'])[1]")
    private WebElement chooseAll;

    @FindBy(xpath = "(.//span[@class='button2__wrapper'])[8]")
    private WebElement allMenu;

    @FindBy(xpath = ".//span[@class='list-item__text' and contains(text(), 'Снять флажок')]")
    private WebElement removeAllFlag;

    @FindBy(xpath = ".//a[@class='nav__item js-shortcut nav__item_active nav__item_shortcut']")
    private WebElement sent;

    @FindBy(xpath = "(.//div[@class='llc__content'])[1]")
    private WebElement message3;

    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div[1]")
    private WebElement nospam;

    @FindBy(xpath = ".//div[contains(text(), 'Не указан адрес получателя')]")
    private WebElement sentError;

    WebDriver driver;

    public BoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToSpam() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        inbox.click();
        message.click();
        nullField2.click();
        Actions keyAction = new Actions(driver);
        keyAction.keyDown(SHIFT).sendKeys("J").perform();
        driver.navigate().refresh();
    }

    public void comeFromSpam() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        spam.click();
        nullField3.click();
        message2.click();
        nullField4.click();
        Actions keyAction = new Actions(driver);
        keyAction.keyDown(SHIFT).sendKeys("J").perform();
        driver.navigate().refresh();
    }

    public void clickSendLetter()
    {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        sendLetter.click();
    }

    public void sendMessageToFriend(String email, String theme, String text) {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        whomField.click();
        whomField.sendKeys(email);
        topicField.sendKeys(theme);
        textField.click();
        nullField.click();
        textField.sendKeys(text);
        sendTo.click();
    }

    public void sendMessageNegative() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        sendTo.click();
    }

    public boolean checkSentError(){
        return(new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(sentError)).isDisplayed();
    }

    public void putFlag() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        inbox.click();
        flag1.click();
        driver.navigate().refresh();
    }

    public boolean checkFlag(){
        return(new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(checkFlag1)).isDisplayed();
    }

    public void removeAllFlag() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        inbox.click();
        chooseAll.click();
        allMenu.click();
        removeAllFlag.click();
        chooseAll.click();
    }

    public boolean checkNoFlag(){
        return(new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(flag1)).isDisplayed();
    }

    public boolean seeInBox()
    {
        (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(inbox)).click();
        return (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(inbox)).isDisplayed();
    }

    public boolean seeSentMessage()
    {
        (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(nullField5)).click();
        sent.click();
        return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(message3)).isDisplayed();
    }

    public boolean seeSpamMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver,50);
        (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(spam)).click();
        return (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(message2)).isDisplayed();
    }

    public boolean seeNoSpamMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver,50);
        (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(spam)).click();
        return (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOf(nospam)).isDisplayed();
    }



}
