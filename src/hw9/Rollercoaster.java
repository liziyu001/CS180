package hw9;
/**
 * Homework 9 - Rollercoaster
 * <p>
 * Rollercoaster class
 *
 * @author Ziyu Li
 * @version October 23, 2021
 */
public class Rollercoaster extends Ride {
    private boolean simulated;

    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated) {
        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;
    }

    public boolean isSimulated() {
        return simulated;
    }

    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rollercoaster that = (Rollercoaster) o;
        return simulated == that.simulated;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\nColor: " + this.getColor() + "\nMinHeight: " + this.getMinHeight()
                + " inches\nMaxRiders: " + this.getMaxRiders() + "\nSimulated: " + this.simulated;
    }
}
