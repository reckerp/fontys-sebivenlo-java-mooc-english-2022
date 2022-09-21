/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Statistics {
    private int count;
    private int sum;


    public Statistics() {
        // initialize the variable numberCount here
        count = 0;
        sum = 0;
    }

    public void addNumber(int number) {
        // write code here
        count++;
        sum += number;
    }

    public int getCount() {
        // write code here
        return count;
    }

    public int sum() {
        return sum;
    }
    
    public double average() {
        // write code here
        if (count == 0) {
            return 0;
        } else {
            return 1.0 * sum / count;
        }

      
    }
    
}
