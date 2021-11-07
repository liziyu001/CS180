/**
 * Project 2 - LabManager
 * <p>
 * LabManager Class
 *
 * @author Ziyu Li
 * @version October 16, 2021
 */
public class LabManager {
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;

    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }

    public Lab getLabOne() {
        return labOne;
    }

    public Lab getLabTwo() {
        return labTwo;
    }

    public Lab getLabThree() {
        return labThree;
    }

    public void setLabOne(Lab labOne) {
        this.labOne = labOne;
    }

    public void setLabTwo(Lab labTwo) {
        this.labTwo = labTwo;
    }

    public void setLabThree(Lab labThree) {
        this.labThree = labThree;
    }

    public int calculateTotalCapacity() {
        return 2 * labOne.getCapacity() + 2 * labTwo.getCapacity() + 2 * labThree.getCapacity();
    }

    public double calculateTotalUtilization() {
        double result = 1 - (double) calculateAvailableSeats() / (double) calculateTotalCapacity();

        return result;

    }

    public int calculateAvailableSeats() {
        return calculateTotalCapacity() - (labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment()
                + labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment()
                + labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment());
    }

    public String listReservedLabs() {
        String s = "Lab One\n" + labOne.listReservations() + "\n"
                + "Lab Two\n" + labTwo.listReservations() + "\n"
                + "Lab Three\n" + labThree.listReservations();
        return s;
    }

    public String listAvailableLabs() {
        String s = "Lab One\n" + labOne.listAvailabilities() + "\n"
                + "Lab Two\n" + labTwo.listAvailabilities() + "\n"
                + "Lab Three\n" + labThree.listAvailabilities();
        return s;
    }

    public String addReservation(String location, String time, String name, int enrollment) {
        if (!(location.equalsIgnoreCase(labOne.getLocation()))
                && !(location.equalsIgnoreCase(labTwo.getLocation()))
                && !(location.equalsIgnoreCase(labThree.getLocation()))) {
            return "Error. Invalid location";
        }
        if (!(time.equalsIgnoreCase("morning")) && !(time.equalsIgnoreCase("afternoon"))) {
            return "Error. Invalid time.";
        }
        if (location.equalsIgnoreCase(labOne.getLocation())) {
            if (time.equalsIgnoreCase("morning")) {
                if (labOne.getMorning().getEnrollment() > 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labOne.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labOne.getMorning().setEnrollment(enrollment);
                        labOne.getMorning().setName(name);
                        return "Reservation added!";
                    }
                }
            } else {
                if (labOne.getAfternoon().getEnrollment() > 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labOne.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labOne.getAfternoon().setEnrollment(enrollment);
                        labOne.getAfternoon().setName(name);
                        return "Reservation added!";
                    }
                }
            }
        } else if (location.equalsIgnoreCase(labTwo.getLocation())) {
            if (time.equalsIgnoreCase("morning")) {
                if (labTwo.getMorning().getEnrollment() > 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labTwo.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labTwo.getMorning().setEnrollment(enrollment);
                        labTwo.getMorning().setName(name);
                        return "Reservation added!";
                    }
                }
            } else {
                if (labTwo.getAfternoon().getEnrollment() > 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labTwo.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labTwo.getAfternoon().setEnrollment(enrollment);
                        labTwo.getAfternoon().setName(name);
                        return "Reservation added!";
                    }
                }
            }
        } else {
            if (time.equalsIgnoreCase("morning")) {
                if (labThree.getMorning().getEnrollment() > 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labThree.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labThree.getMorning().setEnrollment(enrollment);
                        labThree.getMorning().setName(name);
                        return "Reservation added!";
                    }
                }
            } else {
                if (labThree.getAfternoon().getEnrollment() > 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labThree.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labThree.getAfternoon().setEnrollment(enrollment);
                        labThree.getAfternoon().setName(name);
                        return "Reservation added!";
                    }
                }
            }
        }
    }

    public String removeReservation(String location, String time) {
        if (!(location.equalsIgnoreCase(labOne.getLocation()))
                && !(location.equalsIgnoreCase(labTwo.getLocation()))
                && !(location.equalsIgnoreCase(labThree.getLocation()))) {
            return "Error. Invalid location";
        }
        if (!(time.equalsIgnoreCase("morning")) && !(time.equalsIgnoreCase("afternoon"))) {
            return "Error. Invalid time.";
        }
        if (location.equalsIgnoreCase(labOne.getLocation())) {
            if (time.equalsIgnoreCase("morning")) {
                if (labOne.getMorning().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    labOne.getMorning().setEnrollment(0);
                    labOne.getMorning().setName("");
                    return "Reservation removed!";
                }
            } else {
                if (labOne.getAfternoon().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    labOne.getAfternoon().setEnrollment(0);
                    labOne.getAfternoon().setName("");
                    return "Reservation removed!";
                }
            }
        } else if (location.equalsIgnoreCase(labTwo.getLocation())) {
            if (time.equalsIgnoreCase("morning")) {
                if (labTwo.getMorning().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    labTwo.getMorning().setEnrollment(0);
                    labTwo.getMorning().setName("");
                    return "Reservation removed!";
                }
            } else {
                if (labTwo.getAfternoon().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    labTwo.getAfternoon().setEnrollment(0);
                    labTwo.getAfternoon().setName("");
                    return "Reservation removed!";
                }
            }
        } else {
            if (time.equalsIgnoreCase("morning")) {
                if (labThree.getMorning().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    labTwo.getAfternoon().setEnrollment(0);
                    labTwo.getAfternoon().setName("");
                    return "Reservation removed!";
                }
            } else {
                if (labThree.getAfternoon().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    labTwo.getAfternoon().setEnrollment(0);
                    labTwo.getAfternoon().setName("");
                    return "Reservation removed!";
                }
            }
        }
    }

    public String modifyReservation(String location, String time, String name, int enrollment) {
        if (!(location.equalsIgnoreCase(labOne.getLocation()))
                && !(location.equalsIgnoreCase(labTwo.getLocation()))
                && !(location.equalsIgnoreCase(labThree.getLocation()))) {
            return "Error. Invalid location";
        }
        if (!(time.equalsIgnoreCase("morning")) && !(time.equalsIgnoreCase("afternoon"))) {
            return "Error. Invalid time.";
        }
        if (location.equalsIgnoreCase(labOne.getLocation())) {
            if (time.equalsIgnoreCase("morning")) {
                if (labOne.getMorning().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labOne.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labOne.getMorning().setEnrollment(enrollment);
                        labOne.getMorning().setName(name);
                        return "Reservation modified!";
                    }
                }
            } else {
                if (labOne.getAfternoon().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labOne.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labOne.getAfternoon().setEnrollment(enrollment);
                        labOne.getAfternoon().setName(name);
                        return "Reservation modified!";
                    }
                }
            }
        } else if (location.equalsIgnoreCase(labTwo.getLocation())) {
            if (time.equalsIgnoreCase("morning")) {
                if (labTwo.getMorning().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labTwo.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labTwo.getMorning().setEnrollment(enrollment);
                        labTwo.getMorning().setName(name);
                        return "Reservation modified!";
                    }
                }
            } else {
                if (labTwo.getAfternoon().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labTwo.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labTwo.getAfternoon().setEnrollment(enrollment);
                        labTwo.getAfternoon().setName(name);
                        return "Reservation modified!";
                    }
                }
            }
        } else {
            if (time.equalsIgnoreCase("morning")) {
                if (labThree.getMorning().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labThree.getCapacity()) {
                        return "Error. Capacity modified";
                    } else {
                        labThree.getMorning().setEnrollment(enrollment);
                        labThree.getMorning().setName(name);
                        return "Reservation modified!";
                    }
                }
            } else {
                if (labThree.getAfternoon().getEnrollment() == 0) {
                    return "Error. Invalid time.";
                } else {
                    if (enrollment > labThree.getCapacity()) {
                        return "Error. Capacity exceeded";
                    } else {
                        labThree.getAfternoon().setEnrollment(enrollment);
                        labThree.getAfternoon().setName(name);
                        return "Reservation modified!";
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "LabManager{" + labOne.toString() + ", " + labTwo.toString() + ", " + labThree.toString() + "}";
    }
}
