
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

@Points("01-36")
public class LeapYearHiddenTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {

        for (int year = 0; year < 2500; year++) {
            if (isALeapYear(year)) {
                regodnizesCorrect(year);
            } else {
                failsIncorrect(year);
            }
        }
    }

    private void regodnizesCorrect(int year) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(year + "\n");
        callMain(LeapYear.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("When the input is   " + year + " there was no output!", out.length() > 0);
        assertTrue("When the input is  " + year + " output was  \"" + out + "\" ", out.toLowerCase().contains("is a leap"));
        assertTrue("When the input is " + year + " output was  \"" + out + "\" ", !out.toLowerCase().contains("is not"));
    }

    private void failsIncorrect(int year) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(year + "\n");
        callMain(LeapYear.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("When the input is " + year + " there was no output!", out.length() > 0);
        assertTrue("When the input is" + year + " output was  \"" + out + "\" ", !out.toLowerCase().contains("is a leap"));
        assertTrue("When the input is" + year + " output was  \"" + out + "\" ", out.toLowerCase().contains("is not"));
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (Throwable e) {
            fail(kl + "-class public static void main(String[] args) -method has dissappeared!");
        }
    }

    private boolean isALeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}
