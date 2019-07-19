import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;


public class Test {
    @FindBy(id = "mailbox:login")
    private WebElement loginField;
    @FindBy(id = "mailbox:password")
    private WebElement passwordField;



    public static void main(String[] args)
    {
        DBOperations databaseOperations = new DBOperations();
        UserData userData = databaseOperations.getAccessData(1);
        String login = userData.getLogin();
        String password = userData.getPassword();

        System.setProperty("webdriver.chrome.driver", "D:/studyautomate/cromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mail.ru");
        WebElement loginField = driver.findElement(By.id("mailbox:login"));
        loginField.sendKeys(login);
        WebElement passwordField = driver.findElement(By.id("mailbox:password"));
        passwordField.sendKeys(password);
        passwordField.submit();




    }






}
