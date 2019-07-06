package junitcucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoxSteps
{
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "pvtautomationtest";
    private static final String PASSWORD = "748159263Qa";
    private BoxPage boxPage;
    private WebDriver webDriver;

    public BoxSteps()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\studyautomate\\cromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        boxPage = new BoxPage(webDriver);
    }

    @Given("^I am on main application page$")
    public void loadMainPage()
    {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser()
    {
        boxPage.login(LOGIN, PASSWORD);
    }

    @When("^I choose a message$")
    public void chooseMessage()
    {
        boxPage.chooseMessageInbox();
    }

    @When("^I sent the message to spam$")
    public void goToSpam()
    {
        boxPage.goToSpamMessage();
    }

    @Then("^I see the message in spam$")
    public void spamMessage()
    {
        Assert.assertTrue(boxPage.seeSpamMessage());
    }

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
