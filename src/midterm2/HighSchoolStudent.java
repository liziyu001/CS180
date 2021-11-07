package midterm2;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Midterm2 - HighSchoolStudent
 * <p>
 * HighSchoolStudents Class
 *
 * @author Ziyu Li
 * @version November 1, 2021
 */
public class HighSchoolStudent implements Student {
    private final String[] courses;
    private final String name;
    private final boolean approval;

    public HighSchoolStudent(String name, String[] courses, boolean approval) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.courses = courses;
        this.approval = approval;
    }

    public String getName() {
        return name;
    }

    public String[] getCourses() {
        return courses;
    }

    public String[] filterCoursesByCatalogTitle(String catalogTitle) {
        return null;
    }

    @Override
    public String[] filterCoursesByAcademicLevel() {
        ArrayList selection = new ArrayList();
        for (int i = 0; i < courses.length; i++) {
            String[] splited = courses[i].split(" - ");
            if (splited[0].equals("HS")) {
                selection.add(courses[i]);
            }
        }
        String[] selected = new String[selection.size()];
        for (int i = 0; i < selected.length; i++) {
            selected[i] = (String) selection.get(i);
        }
        return selected;
    }

    public boolean canTakeCollegeCourses() {
        return approval;
    }

    public boolean canTakeHighSchoolCourses() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighSchoolStudent that = (HighSchoolStudent) o;
        return approval == that.approval && Arrays.equals(courses, that.courses) && that.name.equals(this.name);
    }

    @Override
    public String toString() {
        String c = "";
        for (int i = 0; i < courses.length; i++) {
            c = c + courses[i] + ", ";
        }
        c = c.substring(0, c.length() - 2);
        return "CollegeStudent{name=" + name + "', courses=[" + c + "]}";
    }

}
