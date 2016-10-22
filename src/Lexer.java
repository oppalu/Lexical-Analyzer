/**
 * Created by phoebegl on 2016/10/21.
 * 具体根据DFA进行词法分析
 */
public class Lexer {
    private FileUtil fileUtil;
    private StringBuffer buffer;

    public Lexer(String path) {
        fileUtil = new FileUtil(path);
        buffer = fileUtil.read();
    }

    public void analyse() {
        int i = 0;
        State state = State.STATE0;
        String word = "";

        /*
        用<=是为了考虑最后一个字符的因素,如果用<最后一个字符无法进入循环
         */
        while(i <= buffer.length()) {
            //为了考虑最后一个字符,写的太烂了TAT
            char ch = 0;
            if(i != buffer.length())
                ch = buffer.charAt(i);

            switch(state) {
                case STATE0:
                    if(Type.isLetter(ch)) {
                        state = State.STATE1;
                        word += ch;
                    } else if(Type.isDigit(ch)) {
                        state = State.STATE2;
                        word += ch;
                    } else if (Type.isSeparator(ch)) {
                        state = State.STATE4;
                        word += ch;
                    }else if(Type.isOperator((word+=ch)) ) {
                        state = State.STATE3;
                    } else if(ch == ' ') {
                        //防止空白符号的干扰
                        word = "";
                    }
                    break;
                case STATE1:
                    if(Type.isDigit(ch) || Type.isLetter(ch)) {
                        word += ch;
                    } else {
                        state = State.STATE0;
                        if(Type.isKeyword(word.trim())) {
                            //System.out.println("(KEYWORD, "+word.trim()+")");
                            fileUtil.write("KEYWORD",word);
                        } else {
                            //System.out.println("(ID, "+word.trim()+")");
                            fileUtil.write("ID",word);
                        }
                        word = "";
                        i--;
                    }
                    break;
                case STATE2:
                    if(Type.isDigit(ch) || ch=='.') {
                        word +=ch;
                    } else if(Type.isLetter(ch)) {
                        /**
                         * 数字开头后面不允许出现字母,异常报错
                         */
                        System.err.println("Error! Letter cannot appear after digit");
                    } else {
                        state = State.STATE0;
                        //System.out.println("(NUMBER, "+word.trim()+")");
                        fileUtil.write("NUMBER",word);
                        word = "";
                        i--;
                    }
                    break;
                case STATE3:
                    //考虑类似+=的情况
                    String temp = word+ch;
                    if(Type.isOperator(temp)) {
                        word = temp;
                    } else {
                        state = State.STATE0;
                        //System.out.println("(OPERATOR, "+word.trim()+")");
                        fileUtil.write("OPERATOR",word);
                        word = "";
                        i--;
                    }
                    break;
                case STATE4:
                    state = State.STATE0;
                    //System.out.println("(SEPARATOR, "+word.trim()+")");
                    fileUtil.write("SEPARATOR",word);
                    word = "";
                    i--;
                    break;
            }
            i++;
        }
    }

}
