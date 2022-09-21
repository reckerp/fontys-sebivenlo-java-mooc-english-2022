import java.util.ArrayList;

public class Hold {
    private int maximumWeight;
    private ArrayList<Suitcase> suitcases;
    
    public Hold(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.totalWeight() + suitcase.totalWeight() <= this.maximumWeight) {
            this.suitcases.add(suitcase);
        }
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase suitcase : this.suitcases) {
            totalWeight += suitcase.totalWeight();
        }
        return totalWeight;
    }

    public void printItems() {
        for (Suitcase suitcase : this.suitcases) {
            suitcase.printItems();
        }
    }
    
    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        } else if (this.suitcases.size() == 1) {
            return "1 suitcase (" + this.totalWeight() + " kg)";
        } else {
            return this.suitcases.size() + " suitcases (" + this.totalWeight() + " kg)";
        }
    }
}
