import org.junit.Test;

/**
 * Created by phoebegl on 2016/10/22.
 */
public class FileUtilTest {

    @Test
    public void testRead() {
        FileUtil f = new FileUtil("/Users/phoebegl/Lexical-Analyzer/src/input.txt");
        StringBuffer s = f.read();
        System.out.println(s);
        System.out.println(s.length());
    }


}
