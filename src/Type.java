/**
 * Created by phoebegl on 2016/10/21.
 * 定义各种类别的具体值以及对于输入字符进行判断是何种类型
 */
public class Type {

    public static final String[] keyword = {"abstract","boolean","break","byte","case","catch","char","class",
                                            "const","continue","default","do","double","else","enum","extends",
                                            "false","final","finally","float","for","if","implements","import",
                                            "int","interface","long","new","null","package","private","protected",
                                            "public","return","short","static","super","switch","this","throw",
                                            "throws","try","true","void","while"};

    public static final char[] separator = {',',';','{','}'};

    public static final String[] operator = {"+","-","*","/","%",">","<","=","&","|","~",">=","<=","==","!=",
                                            "&&","||","++","--","+=","-=","(",")","[","]",".","\""};

    /**
     * 判断输入字符是不是数字
      * @param ch
     * @return
     */
    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    /**
     * 判断输入字符是不是字母
     * @param ch
     * @return
     */
    public static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    /**
     * 判断是不是关键字
     * @param ch
     * @return
     */
    public static boolean isKeyword(String ch) {
        for(String key : keyword) {
            if(key.equals(ch))
                return true;
        }
        return false;
    }

    /**
     * 判断是不是运算符
     * @param ch
     * @return
     */
    public static boolean isOperator(String ch) {
        for(String op : operator) {
            if(op.equals(ch))
                return true;
        }
        return false;
    }

    /**
     * 判断是不是非运算符号
     * @param ch
     * @return
     */
    public static boolean isSeparator(char ch) {
        for(Character se : separator) {
            if(se.equals(ch))
                return true;
        }
        return false;
    }
}
