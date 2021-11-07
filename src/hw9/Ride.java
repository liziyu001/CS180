package hw9;

/**
 * Homework 9 - Ride
 * <p>
 * Ride class
 *
 * @author Ziyu Li
 * @version October 23, 2021
 */
public class Ride {
    private String name;
    private String color;
    private int minHeight;
    private int maxRiders;

    public Ride() {
        name = "";
        color = "";
        maxRiders = 0;
        minHeight = 0;
    }

    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return minHeight == ride.minHeight && maxRiders == ride.maxRiders && name.equals(ride.name)
                && color.equals(ride.color);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nColor: " + color + "\nMinHeight: " + minHeight + " inches\nMaxRiders: " + maxRiders;
    }
}
