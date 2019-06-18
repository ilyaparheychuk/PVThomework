


public class StringOperation {



    public String OneStrCon(String str1, String str2, String str3){
        return str1.concat(str2).concat(str3);

    }

    public String TwoStrTrim(String str1, String str2, String str3){
        return str1.trim()+str2.trim()+str3.trim();

    }

    public String ThreeStrUp(String str){
        return str.toUpperCase();
    }

    public String FourStrLow(String str){
        return str.toLowerCase();
    }

    public int FiveStrOp(String str) {
        return str.length();
    }


}
