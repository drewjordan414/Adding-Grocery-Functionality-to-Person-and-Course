
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Registry implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }
    public boolean enrollStudent(Student student, Course course) {
        if (!students.contains(student) || !courses.contains(course)) {
            return false;
        }
        if (course.enrollStudent(student)) {
            return true;
        } else {
            student.addWaitListed(course);
            return false;
        }
    }
    public void dropStudent(Student student, Course course) {
        if (students.contains(student) && courses.contains(course)) {
            course.removeStudent(student);
            student.removeCourse(course);
            student.removeFromWaitList(course); // enroll waitlisted students
            course.checkWaitList();
        }
    }
    public String toString() {
        String registryInfo = "LOYOLA COMPUTER SCIENCE DEPARTMENT: \n\tRegistry\n";
        for (Student student : students) {
            registryInfo += "\nStudent: " + student.getName() + "\tStudent ID: " + student.getStudentId();
            registryInfo += "\tCourses: ";
            for (Course course : student.getCourse())
                registryInfo += course.getCourseName() + ", ";
            registryInfo += "\nWaitlisted : ";
            for (Course course : student.getWaitListed()) {
                registryInfo += course.getCourseName() + ",";
            }
            registryInfo += "\n";
        }
        registryInfo += "\tCourses:\n";
        for (Course course : courses) {
            registryInfo += "\t" + course + "\n";
        }
        return registryInfo;
    }
    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
