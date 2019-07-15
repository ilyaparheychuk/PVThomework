import com.applitools.eyes.exceptions.TestFailedException;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class EyesTest {


    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "D:/studyautomate/cromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Eyes eyes = new Eyes();
        MailBox mailBox = new MailBox(driver);
        eyes.setApiKey("97K6htp2bEpOXiWo8VheXDHG1Fvvhw7iuuEotr104YHuIw110");
        driver.get("https://mail.ru");
        mailBox.login("pvtautomationtest", "748159263Qa");
        driver.manage().window().maximize();


        try {
            eyes.open(driver, "appName","HOMEWORK");
            mailBox.stepZero();
            eyes.checkWindow("text field");
            mailBox.stepFirst("iliyaparheychuk@gmail.com");
            eyes.checkWindow("friend field");
            mailBox.stepSecond( "Example topic");
            eyes.checkWindow("topic field");
            mailBox.stepThird("Hello world");
            eyes.checkWindow("tex field");
            mailBox.stepForth();
            eyes.checkWindow("Send");
            eyes.close();

        } catch (TestFailedException e) {
            System.out.println("\n" + e + "\n");
        } finally {

            // Close the browser.
            driver.quit();

            // If the test was aborted before eyes.close was called, ends the test as
            // aborted.
            eyes.abortIfNotClosed();

            // End main test
            System.exit(0);
        }



    }








}
