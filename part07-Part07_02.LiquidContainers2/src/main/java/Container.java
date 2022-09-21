/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Container {
    private int volume; 
    private int maxVolume;

    public Container() {
        this.volume = 0;
        this.maxVolume = 100;
    }

    public int contains() {
        return this.volume;
    }

    public void add(int amount) {
        if (amount > 0) {
            this.volume += amount;
            if (this.volume > this.maxVolume) {
                this.volume = this.maxVolume;
            }
        }
    }

    public void remove(int amount) {
        if (amount > 0) {
            this.volume -= amount;
            if (this.volume < 0) {
                this.volume = 0;
            }
        }
    }

    public String toString() {
        return this.volume + "/" + this.maxVolume;
    }
}
