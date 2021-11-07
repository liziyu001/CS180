package midterm2;
/**
 * Midterm2 - Student
 * <p>
 * Student Interface
 *
 * @author Ziyu Li
 * @version November 1, 2021
 */
public interface Student {
    public String[] filterCoursesByCatalogTitle(String catalogTitle);

    public String[] filterCoursesByAcademicLevel();

    public boolean canTakeCollegeCourses();

    public boolean canTakeHighSchoolCourses();
}
