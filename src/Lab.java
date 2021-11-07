/**
 * Project 2 - Lab
 * <p>
 * LabManager
 *
 * @author Ziyu Li
 * @version October 16, 2021
 */
public class Lab {
    private Session morning;
    private Session afternoon;
    private int capacity;
    private String location;

    public Lab(Session morning, Session afternoon, int capacity, String location) {
        this.afternoon = afternoon;
        this.morning = morning;
        this.capacity = capacity;
        this.location = location;
    }

    public Lab(int capacity, String location) {
        this.capacity = capacity;
        this.location = location;
        morning = new Session();
        afternoon = new Session();
    }

    public Session getMorning() {
        return morning;
    }

    public Session getAfternoon() {
        return afternoon;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setMorning(Session morning) {
        this.morning = morning;
    }

    public void setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String listAvailabilities() {
        String s = "";
        if (morning.getEnrollment() == 0) {
            s = s + "Morning: Available\n";
        }

        if (afternoon.getEnrollment() == 0) {
            s = s + "Afternoon: Available\n";
        }

        if (morning.getEnrollment() != 0 && afternoon.getEnrollment() != 0) {
            s = "No Availabilities\n";
        }
        return s;
    }

    public String listReservations() {
        String s = "";
        if (morning.getEnrollment() > 0) {
            s = s + "Morning: Reserved\n";
        }
        if (afternoon.getEnrollment() > 0) {
            s = s + "Afternoon: Reserved\n";
        }
        if (morning.getEnrollment() <= 0 && afternoon.getEnrollment() <= 0) {
            s = "No Reservations\n";
        }
        return s;
    }

    @Override
    public String toString() {
        if (morning.getEnrollment() > 0 && afternoon.getEnrollment() > 0) {
            return "Lab{Capacity - " + capacity + ", Location - " + location + ", Morning: " + morning.toString()
                    + ", Afternoon: " + afternoon.toString() + "}";
        } else if (morning.getEnrollment() == 0 && afternoon.getEnrollment() > 0) {
            return "Lab{Capacity - " + capacity + ", Location - " + location + ", Morning: Available, Afternoon: "
                    + afternoon.toString() + "}";
        } else if (morning.getEnrollment() > 0 && afternoon.getEnrollment() == 0) {
            return "Lab{Capacity - " + capacity + ", Location - " + location + ", Morning: " + morning.toString()
                    + ", Afternoon: Available}";
        } else {
            return "Lab{Capacity - " + capacity + ", Location - " + location
                    + ", Morning: Available, Afternoon: Available}";
        }
    }
}
