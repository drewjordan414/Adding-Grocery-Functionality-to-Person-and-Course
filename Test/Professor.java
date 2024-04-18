import java.util.ArrayList;
import java.util.List;

public class Professor extends Person {
    private String department;
    private String semester;
    private List<Course> coursesTaught;  // List of courses the professor teaches

    public Professor(String firstName, String lastName, String department,String semester) {
        super(firstName, lastName, "Professor"); // Assume all instances of Professor have a role of "Professor"
        this.department = department;
        this.semester = semester;
        this.coursesTaught = new ArrayList<>(); // Initialize the list of courses taught
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addCourse(Course course) {
        if (!coursesTaught.contains(course)) {
            coursesTaught.add(course);
        }
    }

    public void removeCourse(Course course) {
        coursesTaught.remove(course);
    }

    public List<Course> getCoursesTaught() {
        return new ArrayList<>(this.coursesTaught); // Return a copy for encapsulation
    }

    public List<Course> getCoursesForSemester (String semester) {
        // Return a list of courses that this professor is teaching for a specific semester
        List<Course> coursesForSemester = new ArrayList<>();
        for (Course course : coursesTaught) {
            if (course.getSemester().equals(semester)) {
                coursesForSemester.add(course);
            }
        }
        return coursesForSemester;
    }

    @Override
    public String toString() {
        // Show basic info along with department
        return super.toString() + " | Department: " + getDepartment();
    }
}
