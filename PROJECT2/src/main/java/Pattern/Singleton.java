package Pattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {
    private static WebDriver DRIVER;
    private static String DRIVER_FILE = "D:/studyautomate/cromedriver/chromedriver.exe";
    private static String KEY = "webdriver.chrome.driver";

    private Singleton() {
    }

    public static WebDriver getInstance() {
        if (DRIVER == null) {
            System.setProperty(KEY, DRIVER_FILE);
            DRIVER = new ChromeDriver();
        }
        return DRIVER;
    }

    public static void quit(){
        DRIVER.quit();
        DRIVER = null;
    }

}
