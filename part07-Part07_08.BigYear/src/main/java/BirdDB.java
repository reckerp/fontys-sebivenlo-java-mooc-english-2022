import java.util.ArrayList;

public class BirdDB {
    private ArrayList<Bird> birds;

    public BirdDB() {
        this.birds = new ArrayList<>();
    }

    public void addBird(Bird bird) {
        this.birds.add(bird);
    }

    public void addObservation(String name) {
        for (Bird bird : this.birds) {
            if (bird.getName().equals(name)) {
                bird.addObservation();
            }
        }
    }

    public void printBirds() {
        for (Bird bird : this.birds) {
            System.out.println(bird);
        }
    }

    public void printBird(String name) {
        for (Bird bird : this.birds) {
            if (bird.getName().equals(name)) {
                System.out.println(bird);
            }
        }
    }
}
