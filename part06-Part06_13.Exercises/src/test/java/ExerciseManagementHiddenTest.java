
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ExerciseManagementHiddenTest {

    @Test
    @Points("06-13.1")
    public void partOne() {
        assertTrue(MainProgram.partsCompleted() >= 1);
    }

    @Test
    @Points("06-13.2")
    public void partTwo() {
        assertTrue(MainProgram.partsCompleted() >= 2);
    }

}
