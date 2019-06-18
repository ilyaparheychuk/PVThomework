import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IgnoreStringOperationTest {

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

    @Test(enabled = false)
    public void testOneStrCon() {
        String str1 = "aa";
        String str2 = "bb";
        String str3 = "cc";
        String expectedResult = "aabbcc";
        Assert.assertEquals(expectedResult, stringOperation.OneStrCon(str1,str2,str3));
    }

    @Test(enabled = false)
    public void testTwoStrTrim() {
        String str1 = " aa ";
        String str2 = " bb ";
        String str3 = " cc ";
        String expectedResult = "aabbcc";
        Assert.assertEquals(expectedResult, stringOperation.TwoStrTrim(str1,str2,str3));
    }

    @Test(enabled = false)
    public void testThreeStrUp() {
        String str = "aa";
        String expectedResult = "AA";
        Assert.assertEquals(expectedResult, stringOperation.ThreeStrUp(str));
    }

    @Test(enabled = false)
    public void testFourStrLow() {
        String str = "AA";
        String expectedResult = "aa";
        Assert.assertEquals(expectedResult, stringOperation.FourStrLow(str));
    }

    @Test(enabled = false)
    public void testFiveStrOp() {
        String str = "AA";
        int expectedResult = 2;
        Assert.assertEquals(expectedResult, stringOperation.FiveStrOp(str));
    }
}