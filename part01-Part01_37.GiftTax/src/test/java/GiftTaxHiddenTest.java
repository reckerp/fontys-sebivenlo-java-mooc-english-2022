
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

@Points("01-37")
public class GiftTaxHiddenTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void hiddenTest() {
        for (int i = 0; i < 100; i++) {
            Random rnd = new Random();
            int valueOfGift = 5000 + rnd.nextInt(2000000);
            calculatesCorrect(valueOfGift, tax(valueOfGift));
        }
    }

    private double tax(int valueOfGift) {
        if (valueOfGift >= 5000 && valueOfGift < 25000) {
            return 100 + (valueOfGift - 5000) * 0.08;
        } else if (valueOfGift >= 25000 && valueOfGift < 55000) {
            return 1700 + (valueOfGift - 25000) * 0.10;
        } else if (valueOfGift >= 55000 && valueOfGift < 200000) {
            return 4700 + (valueOfGift - 55000) * 0.12;
        } else if (valueOfGift >= 200000 && valueOfGift < 1000000) {
            return 22100 + (valueOfGift - 200000) * 0.15;
        } else {
            return 142100 + (valueOfGift - 1000000) * 0.17;
        }
    }

    private void calculatesCorrect(int valueOfGift, double tax) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(valueOfGift + "\n");
        callMain(GiftTax.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("The program had no output!", out.length() > 0);

        if (tax < 0) {
            assertTrue("With input " + valueOfGift + " output was \"" + out + "\". Expected \"No tax!\"", out.toLowerCase().contains("no"));
        } else {
            assertFalse("With input" + valueOfGift + " output was \"" + out + "\". Did not expect \"No tax!\".", out.toLowerCase().contains("no"));
            assertTrue("With input " + valueOfGift + " output was \"" + out + "\". Expected tax to be " + tax, out.toLowerCase().contains("" + tax));
        }
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

}
