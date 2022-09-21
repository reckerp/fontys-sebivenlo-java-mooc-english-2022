
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("02-19")
public class FactorialHiddenTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int n = 1 + random.nextInt(9);
            check(n, result(n));
        }
    }

    private int result(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    private void check(int number, int expectedResult) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(number + "\n");
        callMain(Factorial.class);
        String out = io.getSysOut().substring(oldOut);

        int result = getLastNumber(out);

        String errorMsg = " The factorial of " + number + " is " + expectedResult
                + ", but you printed \"" + out + "\"";
        assertTrue("you didn't print anything!", out.length() > 0);
        assertEquals(errorMsg, expectedResult, result);
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("Your program was trying to read too much user input, remember to use nextLine()!");
        } catch (Throwable e) {
            fail("The void main(String[] args) method of '" + kl + "' class has disappeared, "
                    + "or something unexpected happened. More info: " + e);
        }
    }

    private static int getLastNumber(String inputStr) {
        String patternStr = "(?s).*?(\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("The output should be of the type \"Factorial: 6\"", matcher.find());

        int number = Integer.valueOf(matcher.group(1));
        return number;
    }
}
