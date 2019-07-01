package AutomateBox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import Box.MenuBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import static org.openqa.selenium.Keys.SHIFT;


public class AutomateBox {

    private WebDriver driver;
    private MenuBox menuBox;

    @BeforeClass
    public void before(){
        System.setProperty("webdriver.chrome.driver", "D:/studyautomate/cromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        MenuBox menuBox = new MenuBox(driver);
        driver.get("https://mail.ru");
        menuBox.login("pvtautomationtest", "748159263Qa");

    }

    @Test
    public void goToSpamTest(){
        MenuBox menuBox = new MenuBox(driver);
        menuBox.goToSpam();
    }

    @Test
    public void comeFromSpamTest(){
        MenuBox menuBox = new MenuBox(driver);
        menuBox.comeFromSpam();
    }

    @Test
    public void sendMessageToFriendsTest(){
        MenuBox menuBox = new MenuBox(driver);
        menuBox.sendMessageToFriends("iliyaparheychuk@gmail.com; aleshkevichpv@gmail.com; olegparheychuk@icloud.com", "Example topic", "Hello world");
    }

    @Test
    public void putFlagTest(){
        MenuBox menuBox = new MenuBox(driver);
        menuBox.putFlag();
    }

    @Test
    public void removeAllFlagTest(){
        MenuBox menuBox = new MenuBox(driver);
        menuBox.removeAllFlag();
    }



}
