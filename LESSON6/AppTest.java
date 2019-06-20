package PVThome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @BeforeEach
    public void setUp() {
        System.out.println("START");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("END");
    }


    @Test
    @DisplayName("\uD83D\uDE31")
    public void sumFirstMethodTest() {
        App app = new App();
        double first = app.sumFirstMethod(9999999, 999999);
        Assertions.assertEquals(1.0999998E7, first);
    }

    @Test
    @DisplayName("╯°□°）╯")
    public void multSecondMethodTest() {
        App app = new App();
        int second = app.multSecondMethod(3, 4);
        Assertions.assertEquals(12, second);
    }

    @Test
    public void sqrtThirdMethodTest() {
        App app = new App();
        double third = app.sqrtThirdMethod(9);
        Assertions.assertEquals(3, third);
    }

    @Test
    public void minForthMethodTest() {
        App calculator = new App();
        int forth = calculator.minForthMethod(3, 4);
        Assertions.assertEquals(3, forth);
    }


    @Test
    public void maxFifthMethodTest() {
        App calculator = new App();
        int fifth = calculator.maxFifthMethod(3, 4);
        Assertions.assertEquals(4, fifth);
    }

    @Test
    public void sixMethodTest() {
        App app = new App();
        int six = app.divisionSixMethod(12, 3);
        Assertions.assertEquals(4, six);
    }

    @Test

    public void powSevenMethodTest() {
        App app = new App();
        double seven = app.powSevenMethod(2);
        Assertions.assertEquals(8.0, seven);
    }

    @Test

    public void lengthEightMethodTest() {
        App app = new App();
        int eight = app.lengthEightMethod("aaaa");
        Assertions.assertEquals(4, eight);
    }

    @ParameterizedTest
    @CsvSource({"5, aaaaa", "4, aaaa", "8, aaaaaaaa"})
    public void lengthEightMethodTest(int expectedResult, String str) {
        App app = new App();
        Assertions.assertEquals(expectedResult, app.lengthEightMethod(str));
    }


    @Test
    public void powSevenMethodNegativeTest() {
        App app = new App();
        double ten = app.powSevenMethod(333);
        double expectedResult = 3.6926037E7;
        Assertions.assertEquals(expectedResult, ten);
    }


}
