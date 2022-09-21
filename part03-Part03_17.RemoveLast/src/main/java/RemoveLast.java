/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;

public class RemoveLast {

    public static void main(String[] args) {
        // Try your method in here
    }
    
    public static void removeLast(ArrayList<String> strings) {
        if (strings.size() == 0) {
            return;
        }
        strings.remove(strings.size() - 1);
    }
}
