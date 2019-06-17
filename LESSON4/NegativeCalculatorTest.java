import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//NEGATIVE
public class NegativeCalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {calculator = new Calculator();}


    @Test
    @DisplayName("NEGATIVCHIK")
     void FirstMethodSum() {
        long expectedResult = Integer.MIN_VALUE;
        Assertions.assertEquals(expectedResult, calculator.FirstMethodSum(Integer.MAX_VALUE, 1));
    }

}
