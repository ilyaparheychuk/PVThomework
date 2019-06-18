import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametrizedSptringOperationTest {


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

    @DataProvider
    public Object [][] getConcatStrings()
    {
        return new Object[][]{
                {"aa", "bb", "cc","aabbcc"},
                {"vv", "ff", "dd", "vvffdd"}};
    }

    @Test(dataProvider="getConcatStrings")
    public void testOneStrCon(String str1, String str2, String str3, String expectedResult)
    {
        Assert.assertEquals(expectedResult, stringOperation.OneStrCon(str1,str2,str3));
    }

    @DataProvider
    public Object [][] getTrimStrings()
    {
        return new Object[][]{
                {" aa ", " bb ", " cc ","aabbcc"},
                {" vv ", " ff ", " dd ", "vvffdd"}};
    }

    @Test(dataProvider="getTrimStrings")
    public void testTwoStrTrim(String str1, String str2, String str3, String expectedResult)
    {
        Assert.assertEquals(expectedResult, stringOperation.TwoStrTrim(str1,str2,str3));
    }

    @DataProvider
    public Object [][] getUpperStrings()
    {
        return new Object[][]{
                {"aa", "AA"},
                {"vv", "VV"}};
    }

    @Test(dataProvider="getUpperStrings")
    public void testThreeStrUp(String str, String expectedResult)
    {
        Assert.assertEquals(expectedResult, stringOperation.ThreeStrUp(str));
    }


}
