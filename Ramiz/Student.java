package Ramiz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student extends Person implements Iterable<Course> {
    private int studentId;
    private List<Course> courses = new ArrayList<>();
    private List<Course> waitListed = new ArrayList<>();

    public Student(int id, String firstName, String lastName) {
        super(firstName, lastName);
        studentId = id;
    }

    public int getStudentId(){
        return studentId;
    }
    /*
    Student record needs to be updated to show course
    The course record needs to be updated to show the students
     */
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }
    public void removeCourse(Course course) {
        courses.remove(course);
    }
    public void moveFromWaitList(Course course) {
        if (waitListed.remove(course)) {
            courses.add(course);
        }
    }
    public void removeFromWaitList(Course course) {
        waitListed.remove(course);
    }
    public void addWaitListed(Course course) {
        if (!waitListed.contains(course)) {
            waitListed.add(course);
        }
    }
    public ArrayList<Course> getCourse() {
        return new ArrayList<>(courses);
    }
    public List<Course> getWaitListed() {
        return new ArrayList<>(waitListed);
    }
    public String toString() {
        String studentInfo = "\tStudent: " + getName() + "\tStudent ID: " + studentId;
        String enrolledCourses = "\nCourses: ";
        for (Course course : courses) {
            enrolledCourses += course.getCourseName() + ", ";
        }
        String waitlistedCourses = "\nWaitlisted Courses: ";
        for (Course course : waitListed) {
            waitlistedCourses += course.getCourseName() + ", ";
        }
        return studentInfo + enrolledCourses + waitlistedCourses;
    }
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Student))
            return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }
    public Iterator<Course> iterator(){
        return courses.iterator();
    }
}