import java.util.ArrayList;
import java.util.List;

public class Professor extends Person {
    private String department;
    private List<Course> coursesTaught;

    public Professor(String firstName, String lastName, String department) {
        super(firstName, lastName);  // super to initialize Person attributes
        this.department = department;
        this.coursesTaught = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
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
        return new ArrayList<>(coursesTaught);
    }

    @Override
    public String toString() {
        return "Professor Name: " + getFullName() + " | Department: " + getDepartment();
    }
}

