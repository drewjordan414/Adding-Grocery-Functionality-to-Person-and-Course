import java.util.ArrayList;
import java.util.List;

public class Professor extends Person {
    private String department;
    private int id;
    private List<Course> coursesTaught;

    public Professor(String firstName, String lastName, String department, int id) {
        super(firstName, lastName, "Professor");
        this.department = department;
        this.id = id;
        this.coursesTaught = new ArrayList<>();
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
        return new ArrayList<>(this.coursesTaught);
    }

    public List<Course> getCoursesForSemester(String semester) {
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
        return super.toString() + " | Department: " + department + " | ID: " + id;
    }
}

