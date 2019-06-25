import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExperiense {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/studyautomate/cromedriver/chromedriver.exe");//your own path
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com");

        WebElement searchField = driver.findElement(By.xpath(".//input[@id='ss']"));
        searchField.sendKeys("москва");

        WebElement clickSearch = driver.findElement(By.xpath(".//button[@data-sb-id='main']"));
        clickSearch.submit();

        Thread.sleep(3000);
        WebElement chooseDate = driver.findElement(By.xpath(".//div[@class='sb-date-field__display' and @data-placeholder='Дата отъезда']"));
        chooseDate.submit();

        WebElement clickDataFirst = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[5]/td[4]/span"));
        clickDataFirst.click();

        WebElement chooseDataEnd = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[2]"));
        chooseDataEnd.click();

        WebElement clickDataSecond = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[5]/td[6]/span"));
        clickDataSecond.click();

        WebElement clickSearchSec = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[5]/div[2]/button"));
        clickSearchSec.click();

        List<WebElement> hotels = driver.findElements(By.xpath(".//div[@data-hotelid]"));
        if (hotels.size() > 0) {
            System.out.println("Hotels are!!!!!!");
        } else {
            System.out.println("NO HOTEL!");
        }



        WebElement chooseRating = driver.findElement(By.xpath("//*[@id=\"filter_review\"]/div[2]/a[1]/div/span[1]"));
        chooseRating.click();
        Thread.sleep(4000);
        WebElement clickFirstHotelRating = driver.findElement(By.xpath("(.//a[@class='hotel_name_link url'])[1]"));
        clickFirstHotelRating.click();


        WebElement checkRating = driver.findElement(By.xpath("(.//div[@class='bui-review-score__badge'])[1]"));
        String rating = checkRating.getText();
        String frtg = rating.replace(rating.charAt(1), '.');
        float rtg = Float.parseFloat(frtg);
        if (rtg >= 9.0) {
            System.out.println("Hotel has rating more than 9.0");
        } else {
            System.out.println("Bad hotel");
        }

    }
}
