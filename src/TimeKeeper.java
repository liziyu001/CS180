import java.util.Scanner;

/**
 * Project 2 - TimeKeeper
 * <p>
 * TimeKeeper Class
 *
 * @author Ziyu Li
 * @version October 16, 2021
 */
public class TimeKeeper {

    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab ";
    private static String labLocationPrompt = "Enter the location of the lab:";
    private static String reservationTimePrompt = "Enter the time of the reservation:";
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:";
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:";
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: ";


    private static String initializeMenu = "1. Initialize Application\n" +
            "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
            "2. List Labs by Availability\n" +
            "3. List Labs by Reservation\n" +
            "4. Add a Reservation\n" +
            "5. Remove a Reservation\n" +
            "6. Modify a Reservation\n" +
            "7. Calculate Statistics\n" +
            "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
            "2. Total Utilization\n" +
            "3. Available seats\n" +
            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";


    public static void main(String[] args) {
        int cap = 0;
        String location = "";
        String time = "";
        String name = "";
        int enrollment;
        Scanner scan = new Scanner(System.in);
        String ans = "";
        System.out.println(welcomePrompt);
        out:
        while (true) {
            System.out.println(initializeMenu);
            ans = scan.nextLine();
            switch (ans) {
                case "1":
                    System.out.println(enterLabCapacity + "1");
                    cap = Integer.parseInt(scan.nextLine());
                    System.out.println(enterLabLocation + "1");
                    location = scan.nextLine();
                    Lab l1 = new Lab(cap, location);
                    System.out.println(enterLabCapacity + "2");
                    cap = Integer.parseInt(scan.nextLine());
                    System.out.println(enterLabLocation + "2");
                    location = scan.nextLine();
                    Lab l2 = new Lab(cap, location);
                    System.out.println(enterLabCapacity + "3");
                    cap = Integer.parseInt(scan.nextLine());
                    System.out.println(enterLabLocation + "3");
                    location = scan.nextLine();
                    Lab l3 = new Lab(cap, location);
                    LabManager lm = new LabManager(l1, l2, l3);
                    mid:
                    while (true) {
                        System.out.println(ongoingMenu);
                        ans = scan.nextLine();
                        switch (ans) {
                            case "1":
                                System.out.println(lm.getLabOne().toString() + "\n"
                                        + lm.getLabTwo().toString() + "\n"
                                        + lm.getLabThree().toString());
                                continue mid;
                            case "2":
                                System.out.println("Lab one\n" + lm.getLabOne().listAvailabilities() + "\n"
                                        + "Lab Two\n" + lm.getLabTwo().listAvailabilities() + "\n" +
                                        "Lab Three\n" + lm.getLabThree().listAvailabilities());
                                continue mid;
                            case "3":
                                System.out.println("Lab one\n" + lm.getLabOne().listReservations() + "\n"
                                        + "Lab Two\n" + lm.getLabTwo().listReservations() + "\n" +
                                        "Lab Three\n" + lm.getLabThree().listReservations());
                                continue mid;
                            case "4":
                                System.out.println(labLocationPrompt);
                                location = scan.nextLine();
                                System.out.println(reservationTimePrompt);
                                time = scan.nextLine();
                                System.out.println(reservationNamePrompt);
                                name = scan.nextLine();
                                System.out.println(reservationEnrollmentPrompt);
                                enrollment = Integer.parseInt(scan.nextLine());
                                System.out.println(lm.addReservation(location, time, name, enrollment));
                                continue mid;
                            case "5":
                                System.out.println(labLocationPrompt);
                                location = scan.nextLine();
                                System.out.println(reservationTimePrompt);
                                time = scan.nextLine();
                                System.out.println(lm.removeReservation(location, time));
                                continue mid;
                            case "6":
                                System.out.println(labLocationPrompt);
                                location = scan.nextLine();
                                System.out.println(reservationTimePrompt);
                                time = scan.nextLine();
                                System.out.println(reservationNameUpdate);
                                name = scan.nextLine();
                                System.out.println(reservationEnrollmentUpdate);
                                enrollment = Integer.parseInt(scan.nextLine());
                                System.out.println(lm.modifyReservation(location, time, name, enrollment));
                                continue mid;
                            case "7":
                                in:
                                while (true) {
                                    System.out.println(statisticsMenu);
                                    ans = scan.nextLine();
                                    switch (ans) {
                                        case "1":
                                            System.out.println(totalCapacity + lm.calculateTotalCapacity());
                                            continue in;
                                        case "2":
                                            System.out.print(totalUtilization);
                                            System.out.printf ("%.2f", lm.calculateTotalUtilization());
                                            System.out.println("");
                                            continue in;
                                        case "3":

                                            System.out.println(availableSeats + lm.calculateAvailableSeats());
                                            continue in;
                                        case "4":
                                            break;
                                        default:
                                            System.out.println(invalidInput);
                                            continue in;
                                    }
                                    break;
                                }
                                continue mid;
                            case "8":
                                break;
                            default:
                                System.out.println(invalidInput);
                                continue mid;
                        }
                        break;
                    }
                    break;
                case "2":
                    break;
                default:
                    System.out.println(invalidInput);
                    continue out;
            }
            break;
        }
        System.out.println(exitMessage);
    }
}