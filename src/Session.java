/**
 * Project 2 - Session
 * <p>
 * Session Class
 *
 * @author Ziyu Li
 * @version October 16, 2021
 */
public class Session {
    private String name;
    private int enrollment;

    public Session() {
        this.name = "";
        this.enrollment = 0;
    }

    public Session(String name, int enrollment) {
        this.enrollment = enrollment;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Session{Name - " + name + ", Enrollment - " + enrollment + "}";
    }
}
