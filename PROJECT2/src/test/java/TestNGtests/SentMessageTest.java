package TestNGtests;


import DataBase.DBOperations;
import DataBase.UserData;
import Pages.BoxPage;
import Pages.LoginPage;
import Parser.ParserDOM;
import Pattern.Singleton;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;

public class SentMessageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private BoxPage boxPage;
    private ParserDOM parserDOM;
    private static final Logger logger = Logger.getLogger(SentMessageTest.class);

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "D:\\studyautomate\\cromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        boxPage = new BoxPage(driver);
        parserDOM = new ParserDOM();
        driver.get("https://mail.ru");
        driver.manage().window().maximize();
        DBOperations databaseOperations = new DBOperations();
        UserData userData = databaseOperations.getAccessData(1);
        String login = userData.getLogin();
        String password = userData.getPassword();
        loginPage.login(login, password);
        logger.info("Start SentMessageTEst");
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }

    @Test
    public void sendMessageToFriendsTest() throws IOException, SAXException, ParserConfigurationException {
        logger.info("Start SentMessage");
        boxPage.clickSendLetter();
        String email = parserDOM.parserSearch(1, "Email");
        String theme = parserDOM.parserSearch(1, "Theme");
        String message = parserDOM.parserSearch(1, "Message");
        boxPage.sendMessageToFriend(email, theme, message);
        Assert.assertTrue(boxPage.seeSentMessage());
    }

    @Test
    public void sendMessageNegativeTest(){
        logger.info("Start SentMessageNegative");
        boxPage.clickSendLetter();
        boxPage.sendMessageNegative();
        Assert.assertTrue(boxPage.checkSentError());
    }


}
