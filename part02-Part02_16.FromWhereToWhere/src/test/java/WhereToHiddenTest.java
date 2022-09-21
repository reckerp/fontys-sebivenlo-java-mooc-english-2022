
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

@Points("02-16.1")
public class WhereToHiddenTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        int[] numbers = {1, 50, 100};
        for (int number : numbers) {
            test(number);
        }
    }

    @Test
    public void verifyOutput() {
        io.setSysIn("5\n");

        ReflectionUtils.newInstanceOfClass(FromWhereToWhere.class);
        try {
            FromWhereToWhere.main(new String[0]);
        } catch (NoSuchElementException e) {
            return;
        }

        String output = io.getSysOut();
        output = output.replaceAll("[^\\d]", " ");
        output = output.trim();
        output = output.replace("1", "");
        output = output.replace("2", "");
        output = output.replace("3", "");
        output = output.replace("4", "");
        output = output.replace("5", "");

        output = output.trim();
        if (!output.isEmpty()) {
            fail("When you're printing numbers until 5, you should only print numbers 1, 2, 3, 4, and 5. Now you also printed: " + output);
        }
    }

    private void test(int last) {
        io.setSysIn(last + "\n");
        int len = io.getSysOut().length();

        ReflectionUtils.newInstanceOfClass(FromWhereToWhere.class);
        try {
            FromWhereToWhere.main(new String[0]);
        } catch (NoSuchElementException e) {
            return;
        }
        String output = io.getSysOut().substring(len);

        output = output.replaceAll("[^\\d]+", " ").trim();
        String[] lines = output.split("\\s+");

        if (lines.length < last) {
            fail("Output should contain " + last + " numbers, now it contained " + lines.length);
        }

        int number = 1;
        for (int i = 0; i < lines.length; i++) {
            if (Integer.valueOf(lines[i]) != number) {
                fail("The row number " + (i + 1) + " shuold contain number " + number + ", now there was " + lines[i] + ".");
            }

            number++;
        }
    }
}
