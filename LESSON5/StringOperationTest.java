import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringOperationTest {


    StringOperation stringOperation;
    @BeforeMethod
    public void setUp() {
        stringOperation = new StringOperation();
        System.out.println("Start");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("End");
    }

    @Test
    public void testOneStrCon() {
        String str1 = "aa";
        String str2 = "bb";
        String str3 = "cc";
        String expectedResult = "aabbcc";
        Assert.assertEquals(expectedResult, stringOperation.OneStrCon(str1,str2,str3));
    }

    @Test
    public void testTwoStrTrim() {
        String str1 = " aa ";
        String str2 = " bb ";
        String str3 = " cc ";
        String expectedResult = "aabbcc";
        Assert.assertEquals(expectedResult, stringOperation.TwoStrTrim(str1,str2,str3));
    }

    @Test
    public void testThreeStrUp() {
        String str = "aa";
        String expectedResult = "AA";
        Assert.assertEquals(expectedResult, stringOperation.ThreeStrUp(str));
    }

    @Test
    public void testFourStrLow() {
        String str = "AA";
        String expectedResult = "aa";
        Assert.assertEquals(expectedResult, stringOperation.FourStrLow(str));
    }

    @Test
    public void testFiveStrOp() {
        String str = "AA";
        int expectedResult = 2;
        Assert.assertEquals(expectedResult, stringOperation.FiveStrOp(str));
    }
}