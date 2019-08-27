package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[@id='mailbox:error' and contains(text(), 'Введите пароль')]")
    private WebElement errorNotPassword;

    @FindBy(xpath = ".//div[@id='mailbox:error' and contains(text(), 'Введите имя ящика')]")
    private WebElement errorNotLogin;

    @FindBy(xpath = ".//div[@id='mailbox:error' and contains(text(), 'Введите имя ящика и пароль')]")
    private WebElement notLoginAndPassword;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String password) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        loginField.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public boolean withoutPassword()
    {
        return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(errorNotPassword)).isDisplayed();
    }

    public boolean withoutLogin()
    {
        return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(errorNotLogin)).isDisplayed();
    }

    public boolean notLoginAndPassword(){
        return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(notLoginAndPassword)).isDisplayed();
    }
}
