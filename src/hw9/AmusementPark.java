package hw9;

import java.util.ArrayList;

/**
 * Homework 9 - Amusement
 * <p>
 * Amusement class
 *
 * @author Ziyu Li
 * @version October 23, 2021
 */
public class AmusementPark implements Park {
    private double admissionCost;
    private boolean arcade;
    private boolean bowling;
    private boolean indoor;
    private double land;
    private String name;
    private boolean outdoor;
    private ArrayList rides;
    private boolean[] seasons;

    public AmusementPark(String name, double admissionCost, double land, ArrayList rides, boolean indoor,
                         boolean outdoor, boolean arcade, boolean bowling, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }

    public boolean isArcade() {
        return arcade;
    }

    public void setArcade(boolean arcade) {
        this.arcade = arcade;
    }

    public boolean isBowling() {
        return bowling;
    }

    public void setBowling(boolean bowling) {
        this.bowling = bowling;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getLand() {
        return land;
    }

    @Override
    public void addRide(Ride ride) throws WrongRideException {
        if (!(ride instanceof Rollercoaster)) {
            throw new WrongRideException("An amusement park can only have rollercoaster rides!");
        }
        rides.add(ride);
    }

    @Override
    public void removeRide(Ride ride) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                rides.remove(i);
            }
        }
    }

    @Override
    public ArrayList getRides() {
        return rides;
    }

    @Override
    public boolean isOutdoor() {
        return outdoor;
    }

    @Override
    public boolean isIndoor() {
        return indoor;
    }

    @Override
    public boolean[] getSeasons() {
        return seasons;
    }

    @Override
    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
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

    @Override
    public void close() {
        name = "";
        land = 0;
        admissionCost = 0;
        rides = null;
        seasons = null;
        indoor = false;
        outdoor = false;
        arcade = false;
        bowling = false;
    }

    public void modifyRide(Ride ride, String newName, String newColor,
                           int newMinHeight, int newMaxRiders, boolean newSimulated) {
        int i = rides.indexOf(ride);
        ride.setName(newName);
        ride.setMaxRiders(newMaxRiders);
        ride.setColor(newColor);
        ride.setMinHeight(newMinHeight);
        ((Rollercoaster) ride).setSimulated(newSimulated);
        rides.remove(i);
        rides.add(i, ride);
    }

}
