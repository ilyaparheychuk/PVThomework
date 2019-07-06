package junitcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ESCAPE;
import static org.openqa.selenium.Keys.SHIFT;

public class BoxPage
{
    private static final int LINK_PRESENSE_TIMEOUT = 90;

	private WebDriver driver;

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
    @FindBy(xpath = "(.//div[@class='llc__content'])[1]")
    private WebElement message3;
    @FindBy(xpath = ".//a[@href='/spam/']")
    private WebElement spam;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div/div[2]")
    private WebElement nullField2;
    @FindBy(xpath = "/html/body/div[8]/div/div/div[2]/div[2]/div/div/div[1]/span/span")
    private WebElement nullField3;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div")
    private WebElement nullField4;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[3]")
    private WebElement nullField5;

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
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div[1]/nav/a[4]")
    private WebElement sent;

    public BoxPage(WebDriver webdriver)
    {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
    }

    public void login(String login, String password)
    {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public void chooseMessageInbox()
    {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        inbox.click();
        message.click();
        nullField2.click();
    }

    public void goToSpamMessage()
    {
        Actions keyAction = new Actions(driver);
        keyAction.keyDown(SHIFT).sendKeys("J").perform();
        nullField5.click();

    }

    public boolean seeSpamMessage()
    {
        (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(spam)).click();
        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(message2)).isDisplayed();
    }

    public void clickSendLetter()
    {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        sendLetter.click();
    }

    public void sendMessageToFriend(String friend, String topic, String text) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        whomField.sendKeys(friend);
        topicField.click();
        topicField.sendKeys(topic);
        textField.click();
        nullField.click();
        textField.sendKeys(text);
        sendTo.click();

    }

    public boolean seeSentMessage()
    {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        nullField3.click();
        nullField4.click();
        (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(sent)).click();
        return message3.isDisplayed();
    }





}
