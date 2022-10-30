
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        history = new ArrayList<>();
    }
    
    public void add(double status){
        history.add(status);
    }
    
    public void clear(){
        history.clear();
    }
    
    public double maxValue(){
        double maxVal = history.get(0);
        for (Double val : history) {
            if (val > maxVal) {
                maxVal = val;
            }
        }
        return maxVal;
    }
    
    public double minValue(){
        double minVal = history.get(0);
        for (Double val : history) {
            if (val < minVal) {
                minVal = val;
            }
        }
        return minVal;
    }
    
    public double average(){
        if (history.isEmpty()) {
            return 0;
        }
        
        int sum = 0;
        for (Double val : history) {
            sum += val;
        }
        
        return 1.0*sum/history.size();
    }
    
    @Override
    public String toString(){
        return history.toString();
    }
}
