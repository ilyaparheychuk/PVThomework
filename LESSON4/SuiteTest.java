import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({CalculatorTest.class, ParameterizedCalculatorTest.class, NegativeCalculatorTest.class})
public class SuiteTest {
}
