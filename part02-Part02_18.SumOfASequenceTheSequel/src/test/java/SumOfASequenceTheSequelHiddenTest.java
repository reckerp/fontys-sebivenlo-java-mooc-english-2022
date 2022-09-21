
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

@Points("02-18")
public class SumOfASequenceTheSequelHiddenTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int upper = 1 + random.nextInt(5);
            int lower = 1 + upper + random.nextInt(10);
            check(upper, lower, result(upper, lower));
        }
    }

    private int result(int upper, int lower) {
        int sum = 0;

        for (int i = upper; i <= lower; i++) {
            sum += i;
        }

        return sum;
    }

    private void check(int first, int last, int expectedResult) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(first + "\n" + last + "\n");
        callMain(SumOfASequenceTheSequel.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("You didn't print anything!", out.length() > 0);

        int result = getLastNumber(out);

        String errorMsg = "The sum of " + first + ".." + last + " should be " + expectedResult + ", you printed \"" + out + "\"";
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

        assertTrue("The output should be of the type \"The sum is 10\". Now you printed: " + inputStr, matcher.find());

        int number = Integer.valueOf(matcher.group(1));
        return number;

    }
}
