package CucumberTest;

import Pages.BoxPage;
import Pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CucumberSteps {

    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "pvtautomationtest";
    private static final String PASSWORD = "748159263Qa";
    private BoxPage boxPage;
    private LoginPage loginPage;
    private WebDriver webDriver;

    public CucumberSteps()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\studyautomate\\cromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        boxPage = new BoxPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {webDriver.get(MAIN_URL); webDriver.manage().window().maximize();}

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {loginPage.login(LOGIN, PASSWORD);}

    @Then("^I am into InBox$")
    public void intoBox(){Assert.assertTrue(boxPage.seeInBox());}

    @When("^I click write message$")
    public void clickWriteMessage()
    {
        boxPage.clickSendLetter();
    }

    @When("^I write friend email \"([^\"]*)\" and theme of message \"([^\"]*)\" and \"([^\"]*)\"$")
    public void sendMessageToFriends(String email, String theme, String text)
    {
        boxPage.sendMessageToFriend(email, theme, text);
    }

    @Then("^I see message in send$")
    public void messageInSend()
    {
        Assert.assertTrue(boxPage.seeSentMessage());
    }

    @After
    public void afterClass()
    {
        webDriver.quit();
    }

}
