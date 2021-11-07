package hw9;

import java.util.ArrayList;

/**
 * Homework 9 - WaterPark
 * <p>
 * WaterPark class
 *
 * @author Ziyu Li
 * @version October 23, 2021
 */
public class WaterPark implements Park {
    private String name;
    private double admissionCost;
    private double land;
    private ArrayList rides;
    private boolean indoor;
    private boolean outdoor;
    private boolean lazyRiver;
    private boolean wavePool;
    private boolean[] seasons;

    public WaterPark(String name, double admissionCost, double land, ArrayList rides, boolean indoor, boolean outdoor,
                     boolean lazyRiver, boolean wavePool, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
        this.seasons = seasons;
    }

    public boolean isLazyRiver() {
        return lazyRiver;
    }

    public void setLazyRiver(boolean lazyRiver) {
        this.lazyRiver = lazyRiver;
    }

    public boolean isWavePool() {
        return wavePool;
    }

    public void setWavePool(boolean wavePool) {
        this.wavePool = wavePool;
    }

    @Override
    public double getAdmissionCost() {
        return admissionCost;
    }

    @Override
    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getLand() {
        return land;
    }

    @Override
    public void addRide(Ride ride) throws WrongRideException {

        if (!(ride instanceof Waterslide)) {
            throw new WrongRideException("A waterpark can only have waterslide rides!");
        }
        rides.add(ride);
    }

    @Override
    public void removeRide(Ride ride) {
        this.rides.remove(ride);
    }

    @Override
    public ArrayList getRides() {
        return rides;
    }

    @Override
    public boolean isIndoor() {
        return indoor;
    }

    @Override
    public boolean isOutdoor() {
        return outdoor;
    }

    @Override
    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }

    @Override
    public boolean[] getSeasons() {
        return seasons;
    }

    @Override
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor)
            throws SpaceFullException {
        if (land + addedLand > maxLand) {
            throw new SpaceFullException("There is no more land to use for this park!");
        } else {
            if (addedIndoor) {
                indoor = true;
            }
            if (addedOutdoor) {
                outdoor = true;
            }
            land = land + addedLand;
        }
    }

    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight,
                           int newMaxRiders, double newSplashDepth) {
        int i = rides.indexOf(ride);
        ride.setName(newName);
        ride.setMaxRiders(newMaxRiders);
        ride.setColor(newColor);
        ride.setMinHeight(newMinHeight);
        ((Waterslide) ride).setSplashDepth(newSplashDepth);
        rides.remove(i);
        rides.add(i, ride);
    }

    public void close() {
        name = "";
        admissionCost = 0;
        land = 0;
        rides = null;
        seasons = null;
        indoor = false;
        outdoor = false;
        lazyRiver = false;
        wavePool = false;
    }
}
