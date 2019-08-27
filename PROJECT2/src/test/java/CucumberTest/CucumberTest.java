package CucumberTest;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(features = {"features/"},tags = {})
public class CucumberTest extends AbstractTestNGCucumberTests {}
