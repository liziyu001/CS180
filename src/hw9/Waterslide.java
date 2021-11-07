package hw9;


/**
 * Homework 9 - Waterslide
 * <p>
 * Waterslide class
 *
 * @author Ziyu Li
 * @version October 23, 2021
 */
public class Waterslide extends Ride {
    private double splashDepth;

    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth) {
        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }

    public double getSplashDepth() {
        return splashDepth;
    }

    public void setSplashDepth(double splashDepth) {
        this.splashDepth = splashDepth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Waterslide that = (Waterslide) o;
        return Double.compare(that.splashDepth, splashDepth) == 0;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\nColor: " + this.getColor() + "\nMinHeight: " + this.getMinHeight()
                + " inches\nMaxRiders: " + this.getMaxRiders() + "\nSplashDepth: " + this.splashDepth + " feet";
    }
}
