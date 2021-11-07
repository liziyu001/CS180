package midterm2;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Midterm2 - CollegeStudent
 * <p>
 * CollegeStudent Class
 *
 * @author Ziyu Li
 * @version November 1, 2021
 */
public class CollegeStudent implements Student {
    private final String name;
    private final String[] courses;

    public CollegeStudent(String name, String[] courses) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.courses = courses;
    }

    public String[] getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public boolean canTakeCollegeCourses() {
        return true;
    }

    public boolean canTakeHighSchoolCourses() {
        return false;
    }

    @Override
    public String[] filterCoursesByAcademicLevel() {
        ArrayList selection = new ArrayList();
        for (int i = 0; i < courses.length; i++) {
            String[] splited = courses[i].split(" - ");
            if (splited[0].equals("COL")) {
                selection.add(courses[i]);
            }
        }
        String[] selected = new String[selection.size()];
        for (int i = 0; i < selected.length; i++) {
            selected[i] = (String) selection.get(i);
        }
        return selected;
    }

    @Override
    public String[] filterCoursesByCatalogTitle(String catalogTitle) {
        ArrayList selection = new ArrayList();
        for (int i = 0; i < courses.length; i++) {
            String[] splited = courses[i].split(" - ");
            if (splited[1].equals(catalogTitle)) {
                selection.add(courses[i]);
            }
        }
        String[] selected = new String[selection.size()];
        for (int i = 0; i < selected.length; i++) {
            selected[i] = (String) selection.get(i);
        }
        return selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollegeStudent that = (CollegeStudent) o;
        return that.name.equals(this.name) && Arrays.equals(courses, that.courses);
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
