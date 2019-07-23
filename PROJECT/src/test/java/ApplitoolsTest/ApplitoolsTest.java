package ApplitoolsTest;

import Pages.LoginPage;
import Pattern.Singleton;
import TestNGtests.SpamTest;
import com.applitools.eyes.selenium.Eyes;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.applitools.eyes.exceptions.TestFailedException;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;


public class ApplitoolsTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private Eyes eyes;
    private static final Logger logger = Logger.getLogger(SpamTest.class);

    @BeforeClass
    public void setUpDriver() {eyes = new Eyes();}

    @BeforeMethod
    public void before() {
        driver = Singleton.getInstance();
        loginPage = new LoginPage(driver);
        eyes.setApiKey("97K6htp2bEpOXiWo8VheXDHG1Fvvhw7iuuEotr104YHuIw110");
        driver.get("https://mail.ru");
        driver.manage().window().maximize();
        eyes.open(driver, "FINAL","applitoolsTest");
        logger.info("Start ApplitoolsTest");
    }

    @AfterMethod
    public void after() {
        driver.quit();
        eyes.abortIfNotClosed();
    }

    @Test
    public void applitoolsTest(){
        eyes.checkWindow("Mail Page");
        loginPage.login("pvtautomationtest", "748159263Qa");
        (new WebDriverWait(driver, 80))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[@href='/inbox/']")));
        eyes.checkWindow("Inbox Page");
        TestResults testResults = eyes.close();
        if (testResults.isNew()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(testResults.isPassed());
        }
    }

}
