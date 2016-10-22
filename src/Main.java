/**
 * Created by phoebegl on 2016/10/21.
 */
public class Main {

    public static void main(String[] args) {
        Lexer lex = new Lexer("input.txt");
        lex.analyse();
        FileUtil.finish();
    }
}
