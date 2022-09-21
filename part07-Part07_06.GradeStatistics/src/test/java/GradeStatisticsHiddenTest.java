
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

@Points("07-06.4")
public class GradeStatisticsHiddenTest {

    @Rule
    public MockStdio io = new MockStdio();
    Random rand = new Random();

    @Test
    public void testMany0() {
        int[] numbers = makeNumbers(1, 1);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);
    }

    @Test
    public void testMany1() {

        int[] numbers = makeNumbers(4, 1);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);
    }

    @Test
    public void testMany1b() {

        int[] numbers = makeNumbers(4, 1);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);
    }

    @Test
    public void testMany2() {

        int[] numbers = makeNumbers(4, 4);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);
    }

    @Test
    public void testMany2b() {

        int[] numbers = makeNumbers(4, 4);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);
    }

    @Test
    public void testMany3() {

        int[] numbers = makeNumbers(8, 2);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);
    }

    @Test
    public void testMany3b() {

        int[] numbers = makeNumbers(8, 2);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);
    }

    @Test
    public void testMany4() {

        int[] numbers = makeNumbers(9, 1);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);
    }

    @Test
    public void testMany4b() {

        int[] numbers = makeNumbers(9, 1);

        int[] distribution = convertToGrades(numbers);
        double percentage = calculatePercentage(distribution);
        test(numbers, distribution, percentage);

    }

    private int[] makeNumbers(int good, int bad) {
        ArrayList<Integer> numberList = new ArrayList<>();
        int[] numbers = new int[good + bad];

        for (int i = 0; i < numbers.length; i++) {
            int addi = i < good ? 50 : 0;
            numberList.add(addi + rand.nextInt(50));
        }

        Collections.shuffle(numberList);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numberList.get(i);

        }

        return numbers;
    }

    private double calculatePercentage(int[] numbers) {
        double all = 0;
        for (int n : numbers) {
            all += n;
        }

        return 100 * (all - numbers[0]) / all;
    }

    private int[] convertToGrades(int[] numbers) {
        int[] distribution = new int[6];

        for (int number : numbers) {
            if (number < 0 || number > 100) {
                continue;
            }
            distribution[convertToGrade(number)]++;
        }

        return distribution;
    }

    private int convertToGrade(int pointAmount) {

        if (pointAmount < 50) {
            return 0;
        }
    
        if (pointAmount < 60) {
            return 1;
        }
        
        if (pointAmount < 70) {
            return 2;
        }
        
        if (pointAmount < 80) {
            return 3;
        }
        
        if (pointAmount < 90) {
            return 4;
        }

        return 5;
    }

    /*
     * helpers
     */
    private void test(int[] numbers, int[] distribution, double percentage) {
        io.setSysIn(userInput(numbers) + "-1\n");
        Main.main(new String[0]);
        String[] rows = io.getSysOut().split("\n");

        String percentage2 = ("" + percentage).replace('.', ',');

        String row = getRow(rows, "cent");

        try {
            assertTrue("with the input " + toS(numbers) + " the pass percentage should be " + percentage + ", now the output was: \"" + row + "\"",
                    row.contains("" + percentage) || row.contains(percentage2));
        } catch (NullPointerException e) {
            fail("Did you print the pass percentage?\nwith the input " + toS(numbers) + " the pass percentage should be " + percentage + ", now the output was: \"" + row + " \"");
        }

        assertFalse("make sure that the program prints a row with the text \"Pass percentage:\"", row == null);
        for (int i = 0; i < 6; i++) {
            row = getRow(rows, i + ":");
            checkGrade(i, distribution[i], row, numbers);
        }
    }

    private void checkGrade(int i, int expected, String row, int[] numbers) {
        if (expected == 0) {
            assertFalse("with the input " + toS(numbers) + " there should not be any stars on the line for the grade " + i + ", "
                    + "now the output was \"" + row + "\"", row.contains("*"));
            return;
        }

        String stars = "";
        for (int j = 0; j < expected; j++) {
            stars += "*";
        }

        assertTrue("with the input " + toS(numbers) + " the program should print \"" + i + ": " + stars
                + "  now the output was \"" + row + "\"", row.contains(stars));
        assertFalse("with the input " + toS(numbers) + " the program should print \"" + i + ": " + stars
                + "  now the output was \"" + row + "\"", row.contains(stars + "*"));
    }

    /*private void testaaTuloste(int[] numbers) {
        io.setSysIn(userInput(numbers) + "-1\n");
        Main.main(new String[0]);
        String[] rivit = io.getSysOut().split("\n");

        String rivi = getRow(rivit, "distribution");
        assertFalse("tarkasta että ohjelma tulostaa rivin jolla teksti \"Arvosanajakauma:\"", rivi == null);
        rivi = getRow(rivit, "sentti");
        assertFalse("tarkasta että ohjelma tulostaa rivin jolla teksti \"Hyväksymisprosentti:\"", rivi == null);
        for (int i = 0; i < 6; i++) {
            rivi = getRow(rivit, i + ":");
            assertFalse("tarkasta että ohjelma tulostaa rivin jolla teksti \"" + i + ":\"", rivi == null);
        }
    }

    private void testaaSyote(int[] numbers) {
        io.setSysIn(userInput(numbers) + "-1\n");
        try {
            Main.main(new String[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("ohjelmasi viittaa taulukon tai listan ulkopuolelle syötteellä " + toS(numbers));

        } catch (NoSuchElementException e) {
            fail("ohjelmasi pitäisi pysähtyä syötteellä " + toS(numbers));
        } catch (Exception e) {
            fail("jotain odottamatonta tapahtui syötteellä " + toS(numbers) + " lisätietoa " + e.getMessage());
        }
    }*/

    private String userInput(int[] numbers) {
        String str = "";

        for (int num : numbers) {
            str += num + "\n";
        }

        return str;
    }

    private String toS(int[] numbers) {
        if (numbers.length == 0) {
            return "-1";
        }

        return Arrays.toString(numbers).replace("[", "").replace("]", "") + ", -1";
    }

    private String getRow(String[] rows, String target) {
        for (String row : rows) {
            if (row.contains(target)) {
                return row;
            }
        }

        return null;
    }
}
