import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Course implements Comparable<Course> {
    private int creditHours;
    private String courseNumber;
    private String courseTitle;
    private int maxEnrollment;
    private Set<Student> enrolledStudents;
    private LinkedList<Student> waitList;
    private String semester; // Semester is now represented as a string (e.g., "Fall 2024")
    private Professor professor;
    private String level;

    public Course(int creditHours, String courseNumber, String courseTitle, int maxEnrollment, String semester, Professor professor, String level) {
        this.creditHours = creditHours;
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.maxEnrollment = maxEnrollment;
        this.semester = semester;
        this.professor = professor;
        this.level = level;
        this.enrolledStudents = new TreeSet<>(Comparator.comparing(Student::getFullName)); // Compare by full name
        this.waitList = new LinkedList<>();
    }

    public String getSemester() {
        return this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean enrollStudent(Student student) {
        if (this.enrolledStudents.size() < this.maxEnrollment) {
            this.enrolledStudents.add(student);
            student.addRegisteredCourse(this);
            return true;
        } else {
            this.waitList.add(student);
            student.addWaitListedCourse(this);
            return false;
        }
    }

    public void removeStudent(Student student) {
        if (this.enrolledStudents.remove(student)) {
            student.removeCourse(this);
            this.checkWaitList();
        } else {
            this.waitList.remove(student);
            student.removeFromWaitList(this);
        }
    }

    public void checkWaitList() {
        while(!this.waitList.isEmpty() && this.enrolledStudents.size() < this.maxEnrollment) {
            Student student = this.waitList.poll();
            this.enrolledStudents.add(student);
            student.addRegisteredCourse(this);
        }
    }

    public Set<Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }

    public LinkedList<Student> getWaitList() {
        return this.waitList;
    }

    @Override
    public int compareTo(Course o) {
        int comparison = this.courseNumber.compareTo(o.courseNumber);
        if (comparison != 0) return comparison;
        return this.courseTitle.compareTo(o.courseTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return creditHours == course.creditHours &&
               maxEnrollment == course.maxEnrollment &&
               courseNumber.equals(course.courseNumber) &&
               courseTitle.equals(course.courseTitle) &&
               Objects.equals(semester, course.semester) &&
               Objects.equals(professor, course.professor) &&
               Objects.equals(level, course.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditHours, courseNumber, courseTitle, maxEnrollment, semester, professor, level);
    }

    @Override
    public String toString() {
        return "Course{" +
               "creditHours=" + creditHours +
               ", courseNumber='" + courseNumber + '\'' +
               ", courseTitle='" + courseTitle + '\'' +
               ", maxEnrollment=" + maxEnrollment +
               ", semester='" + semester + '\'' +
               ", level='" + level + '\'' +
               ", professor=" + professor +
               '}';
    }
}
