package Drew;
import java.util.LinkedList;
import java.util.List;

public class Student extends Person {
    private String studentId;
    private List<Course> courses;

    public Student(String familyName, String givenNames, int day, int month, int year, String studentId) {
        super(familyName, givenNames, day, month, year);
        this.studentId = studentId;
        this.courses = new LinkedList<>();
    }

    public boolean enrollCourse(Course course) {
        if (course.registerStudent(this)) {
            courses.add(course);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (courses.remove(course)) {
            course.unenrollStudent(this);
            return true;
        }
        return false;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getStudentId() {
        return studentId;
    }

}