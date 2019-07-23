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

public class FlagTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private BoxPage boxPage;
    private static final Logger logger = Logger.getLogger(FlagTest.class);

    @BeforeMethod
    public void before() {
        driver = Singleton.getInstance();
        loginPage = new LoginPage(driver);
        boxPage = new BoxPage(driver);
        driver.get("https://mail.ru");
        driver.manage().window().maximize();
        DBOperations databaseOperations = new DBOperations();
        UserData userData = databaseOperations.getAccessData(1);
        String login = userData.getLogin();
        String password = userData.getPassword();
        loginPage.login(login, password);
        logger.info("Start FLAGTEst");
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }


    @Test
    public void putFlagTest(){
        logger.info("PUT FLAG");
        boxPage.putFlag();
        Assert.assertTrue(boxPage.checkFlag());
    }

    @Test
    public void removeFlagTest(){
        logger.info("REMOVE FLAG");
        boxPage.removeAllFlag();
        Assert.assertTrue(boxPage.checkNoFlag());
    }


}
