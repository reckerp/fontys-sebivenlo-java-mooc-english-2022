
public class HealthStation {
    private int weighings = 0;

    public int weigh(Person person) {
        // return the weight of the person passed as the parameter
        weighings++;
        return person.getWeight();
    }

    public void feed(Person person) {
        // increase the weight of the person by one
        person.setWeight(person.getWeight() + 1);
    }

    public int weighings(){
        return weighings;
    }

}
