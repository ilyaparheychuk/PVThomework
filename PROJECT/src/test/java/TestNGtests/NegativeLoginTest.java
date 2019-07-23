package TestNGtests;
import DataBase.DBOperations;
import DataBase.UserData;
import Pages.LoginPage;
import Pattern.Singleton;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NegativeLoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(NegativeLoginTest.class);

    @BeforeMethod
    public void before() {
        driver = Singleton.getInstance();
        loginPage = new LoginPage(driver);
        driver.get("https://mail.ru");
        driver.manage().window().maximize();
        logger.info("Start NegativeLoginTEst");
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }


    @Test
    public void withoutPasswordTest(){
        logger.info("Without password");
        DBOperations databaseOperations = new DBOperations();
        UserData userData = databaseOperations.getAccessData(1);
        String login = userData.getLogin();
        loginPage.login(login, "");
        Assert.assertTrue(loginPage.withoutPassword());
    }

    @Test
    public void withoutLoginTest(){
        logger.info("WithoutLogin");
        DBOperations databaseOperations = new DBOperations();
        UserData userData = databaseOperations.getAccessData(1);
        String password = userData.getLogin();
        loginPage.login("", password);
        Assert.assertTrue(loginPage.withoutLogin());
    }

    @Test
    public void notLoginAndPsswordTest(){
        logger.info("Without LoginAndPassword");
        loginPage.login("","");
        Assert.assertTrue(loginPage.notLoginAndPassword());
    }




}