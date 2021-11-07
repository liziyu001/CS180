
public interface Student {
    public String[] filterCoursesByCatalogTitle(String catalogTitle);

    public String[] filterCoursesByAcademicLevel();

    public boolean canTakeCollegeCourses();

    public boolean canTakeHighSchoolCourses();
}
