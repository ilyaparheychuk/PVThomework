package TestNGtests;


import DataBase.DBOperations;
import DataBase.UserData;
import Pages.BoxPage;
import Pages.LoginPage;
import Pattern.Singleton;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;

public class SpamTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private BoxPage boxPage;
    private static final Logger logger = Logger.getLogger(SpamTest.class);

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "D:\\studyautomate\\cromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        boxPage = new BoxPage(driver);
        driver.get("https://mail.ru");
        driver.manage().window().maximize();
        DBOperations databaseOperations = new DBOperations();
        UserData userData = databaseOperations.getAccessData(1);
        String login = userData.getLogin();
        String password = userData.getPassword();
        logger.info("Start SpamTest");
        loginPage.login(login, password);
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }

    @Test
    public void comeFromSpamTest(){
        logger.info("SpamTest comeFromSpam");
        boxPage.comeFromSpam();
        Assert.assertTrue(boxPage.seeNoSpamMessage());
    }

    @Test
    public void goToSpamTest(){
        logger.info("SpamTest goToSpam");
        boxPage.goToSpam();
        Assert.assertTrue(boxPage.seeSpamMessage());
    }


}