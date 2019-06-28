import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java. util. Collections;

public class BookingTest {

    @Test
    public void verifyPriceTest() {
        System.setProperty("webdriver.chrome.driver", "D:/studyautomate/cromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        driver.get("https://www.booking.com/searchresults.ru.html?label=gen173nr-1DCAEoggI46AdIM1gEaCWIAQGYASG4ARfIAQzYAQPoAQGIAgGoAgO4Ar3c1OgFwAIB&sid=0c7cb0e18db49ac5275657d671321883&sb=1&src=index&src_elem=sb&error_url=https%3A%2F%2Fwww.booking.com%2Findex.ru.html%3Flabel%3Dgen173nr-1DCAEoggI46AdIM1gEaCWIAQGYASG4ARfIAQzYAQPoAQGIAgGoAgO4Ar3c1OgFwAIB%3Bsid%3D0c7cb0e18db49ac5275657d671321883%3Bsb_price_type%3Dtotal%3Bsrpvid%3Dfc9693a0d39a0108%26%3B&ss=%D0%9F%D0%B0%D1%80%D0%B8%D0%B6%2C+%D0%98%D0%BB%D1%8C-%D0%B4%D0%B5-%D0%A4%D1%80%D0%B0%D0%BD%D1%81%2C+%D0%A4%D1%80%D0%B0%D0%BD%D1%86%D0%B8%D1%8F&is_ski_area=0&ssne=%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0&ssne_untouched=%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0&checkin_year=&checkin_month=&checkout_year=&checkout_month=&group_adults=2&group_children=0&no_rooms=1&b_h4u_keep_filters=&from_sf=1&ss_raw=%D0%9F%D0%B0%D1%80%D0%B8%D0%B6&ac_position=0&ac_langcode=ru&ac_click_type=b&dest_id=-1456928&dest_type=city&iata=PAR&place_id_lat=48.856682&place_id_lon=2.351476&search_pageview_id=49fa93d861bc04b6&search_selected=true");

        WebElement clickClick = driver.findElement(By.xpath("//*[@id=\"b2searchresultsPage\"]"));
        clickClick.click();

        WebElement chooseDate = driver.findElement(By.xpath(".//div[@class='sb-date-field__display' and @data-placeholder='Дата отъезда']"));
        chooseDate.submit();

        WebElement clickDataFirst = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[1]/td[2]"));
        clickDataFirst.click();

        WebElement chooseDataEnd = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[2]"));
        chooseDataEnd.click();

        WebElement clickDataSecond = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[2]/td[2]"));
        clickDataSecond.click();


        WebElement clickSearch = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[5]/div[2]/button"));
        clickSearch.click();


        WebElement choosePoor = driver.findElement((By.xpath("//*[@id=\"filter_price\"]/div[2]/a[1]/div/span[1]")));
        choosePoor.click();


        WebElement chooseAvailable = driver.findElement((By.xpath("//*[@id=\"filter_out_of_stock\"]/div[2]/a/div/span")));
        chooseAvailable.click();


        WebElement filtrePoor = driver.findElement((By.xpath("//*[@id=\"sort_by\"]/ul/li[3]/a")));
        filtrePoor.click();


        List<WebElement> hotelRating = driver.findElements(By.xpath(".//div[@class='bui-review-score__badge']"));
        for (int i = 0; i < hotelRating.size(); i++) {
            String aaa = hotelRating.get(i).getText();
            String frtg = aaa.replace(aaa.charAt(1), '.');
            float rtg = Float.parseFloat(frtg);


        }


    }


}
