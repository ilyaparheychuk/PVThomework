import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class ParameterizedCalculatorTest {
    Calculator calculator;
    @BeforeEach
    void setUp(){calculator = new Calculator();}

    @ParameterizedTest
    @CsvSource({"7, 4, 3","5, 3, 2"})
    @DisplayName("SUM")
    public void FirstMethodSum(int expectedResult, int a, int b){
        Assertions.assertEquals(expectedResult, calculator.FirstMethodSum(a, b));
    }

    @ParameterizedTest
    @CsvSource({"16, 2, 8","10, 5, 2"})
    @DisplayName("MULT")
    public void SecondMethodMult(int expectedResult, int a, int b){
        Assertions.assertEquals(expectedResult, calculator.SecondMethodMult(a, b));
    }

    @ParameterizedTest
    @CsvSource({"4, 2","25, 5"})
    @DisplayName("SQRT")
    public void ThirdMetodSqrt(int expectedResult, int a){
        Assertions.assertEquals(expectedResult, calculator.ThirdMetodSqrt(a));
    }

    @ParameterizedTest
    @CsvSource({"2, 2, 3","2, 5, 2"})
    @DisplayName("MIN")
    public void ForthMethodMin(int expectedResult, int a, int b){
        Assertions.assertEquals(expectedResult, calculator.ForthMethodMin(a, b));
    }

    @ParameterizedTest
    @CsvSource({"3, 2, 3","5, 5, 2"})
    @DisplayName("MAX")
    public void FifthMethodMax(int expectedResult, int a, int b){
        Assertions.assertEquals(expectedResult, calculator.FifthMethodMax(a, b));
    }



}
