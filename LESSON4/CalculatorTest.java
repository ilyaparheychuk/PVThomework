import org.junit.Ignore;
import org.junit.jupiter.api.*;

class CalculatorTest {

    @BeforeEach
    public void setUp() {
        System.out.println("START");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("END");
    }

    // POSTIVE
    @Test
    @DisplayName("\uD83D\uDE31")
    public void firstMethodSum() {
        Calculator calculator = new Calculator();
        int first = calculator.FirstMethodSum(3,4);
        Assertions.assertEquals(7,first);
    }

    @Test
    @DisplayName("╯°□°）╯")
    public void secondMethodMult() {
        Calculator calculator = new Calculator();
        int second = calculator.SecondMethodMult(3,4);
        Assertions.assertEquals(12,second);
    }

    @Test
    public void thirdMetodSqrt() {
        Calculator calculator = new Calculator();
        int third = calculator.ThirdMetodSqrt(3);
        Assertions.assertEquals(9,third);
    }

    @Test
    public void forthMethodMin() {
        Calculator calculator = new Calculator();
        int forth = calculator.ForthMethodMin(3,4);
        Assertions.assertEquals(3,forth);
    }

    @Ignore
    @Test
    public void fifthMethodMax() {
        Calculator calculator = new Calculator();
        int fifth = calculator.FifthMethodMax(3,4);
        Assertions.assertEquals(4,fifth);
    }


}