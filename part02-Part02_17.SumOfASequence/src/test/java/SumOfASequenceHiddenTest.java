
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

@Points("02-17")
public class SumOfASequenceHiddenTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int n = 1 + random.nextInt(30);
            check(n, result(n));
        }
    }

    private int result(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    private void check(int last, int expectedResult) {
        int first = 1;
        int oldOut = io.getSysOut().length();
        io.setSysIn(last + "\n");
        callMain(SumOfASequence.class);
        String out = io.getSysOut().substring(oldOut);

        int result = getLastNumber(out);

        String errorMessage = "The sum of " + first + ".." + last + " should be "
                + expectedResult + ", but you printed \"" + out + "\"";
        assertTrue("you're not printing anything!", out.length() > 0);
        assertEquals(errorMessage, expectedResult, result);
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("remember to read the user input with nextLine()");
        } catch (Throwable e) {
            fail("Something unexpected happened. The public static void main(String[] args) method of '" + kl + "' class has disappeared \n"
                    + "or your program crashed because of an exception. More info: " + e);
        }
    }

    private static int getLastNumber(String inputStr) {
        String patternStr = "(?s).*?(\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("output should be of the type \"The sum is 10\"", matcher.find());

        int number = Integer.valueOf(matcher.group(1));
        return number;
    }
}
