import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Comparable<Student> {
    private int studentId;
    private List<Course> registeredCourses = new ArrayList<>();
    private List<Course> waitListedCourses = new ArrayList<>();

    public Student(String firstName, String lastName, int studentId) {
        super(firstName, lastName);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void addRegisteredCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
        }
    }

    public void removeCourse(Course course) {
        registeredCourses.remove(course);
        waitListedCourses.remove(course); // Also consider if it should be removed from waitlisted courses
    }

    public void addWaitListedCourse(Course course) {
        if (!waitListedCourses.contains(course)) {
            waitListedCourses.add(course);
        }
    }

    public void removeFromWaitList(Course course) {
        waitListedCourses.remove(course);
    }

    public List<Course> getRegisteredCourses() {
        return new ArrayList<>(registeredCourses);
    }

    public List<Course> getWaitListedCourses() {
        return new ArrayList<>(waitListedCourses);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentId, other.studentId);
    }

    @Override
    public String toString() {
        return "Student Name: " + getFullName() + " | Student ID: " + studentId;
    }
}