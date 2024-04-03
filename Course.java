import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Course {
    private String departmentName;
    private int number;
    private String title;
    private int maxEnrollment;
    private Set<Student> enrolledStudents;
    private Queue<Student> waitlist;

    public Course(String departmentName, int number, String title, int maxEnrollment) {
        this.departmentName = departmentName;
        this.number = number;
        this.title = title;
        this.maxEnrollment = maxEnrollment;
        this.enrolledStudents = new HashSet<>();
        this.waitlist = new LinkedList<>();
    }

    // Registers a student to the course. Returns true if successful, false if waitlisted.
    public boolean registerStudent(Student student) {
        if (enrolledStudents.size() < maxEnrollment) {
            return enrolledStudents.add(student);
        } else {
            waitlist.offer(student);
            return false; // Student is waitlisted
        }
    }

    // Unenrolls a student from the course or waitlist. Returns true if successful.
    public boolean unenrollStudent(Student student) {
        boolean removed = enrolledStudents.remove(student);
        if (!removed) {
            // Try to remove from waitlist if not found in enrolledStudents
            return waitlist.remove(student);
        }
        
        // If a student was removed from enrolled, check if we can enroll someone from the waitlist
        if (!waitlist.isEmpty()) {
            Student nextStudent = waitlist.poll(); 
            if (nextStudent != null) {
                enrolledStudents.add(nextStudent);
            }
        }
        return true;
    }

    // Getters and Setters
    public String getCourseCode() {
        return departmentName + " " + number;
    }

    public String getTitle() {
        return title;
    }

    public Set<Student> getEnrolledStudents() {
        return new HashSet<>(enrolledStudents);
    }

    public Queue<Student> getWaitlist() {
        return new LinkedList<>(waitlist);
    }
    
    @Override
    public String toString() {
        return "Course{" +
                "departmentName='" + departmentName + '\'' +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", maxEnrollment=" + maxEnrollment +
                ", enrolledStudents=" + enrolledStudents.size() +
                ", waitlistSize=" + waitlist.size() +
                '}';
    }
}