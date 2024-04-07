import java.util.*;

public class CapstoneMain {
    public static void main(String[] args) {
        List<Student> students = createStudents();
        Registry registry = createRegistry();
        List<Course> courses = createCourses();

        addStudentsToRegistry(students, registry);
        addCoursesToRegistry(courses, registry);

        enrollStudentsInCourses(students, courses, registry);
        printEnrollmentInfo(registry);
    }


    // Test functionality of Student and Course interaction
    //(1) Initialize Students for testing
    public static List<Student> createStudents() {
        List<Student> students = new ArrayList<>();//Create List to hold Student instances
        for (int i = 1; i <= 10; i++) {
            String firstName = "StudentFirstName " + i;// for testing; creates firstName i ... n
            String lastName = "StudentLastName " + i;// for testing; creates LastName i ... n
            Person person = new Person(firstName, lastName);//Initialize instances of Students i...n
            students.add(new Student(i, person.getFirstName(), person.getLastName()));//add Students to ArrayList students
        }
        return students;//returns list of students to main
    }
    // Create an instance of Registry to test functionality
    public static Registry createRegistry() {
        return new Registry();
    }

    // Create instance of Courses for testing with Student Objects
    public static List<Course> createCourses() {
        List<Course> courses = new ArrayList<>();//create a list for courses to be held
        for (int i = 1; i <= 10; i++) {
            int creditHours = 3;
            String courseNumber = "CS" + (100 + i);
            String courseName = "Course " + i;
            int maxEnrollment = 5; // Set to 5 to test waitlist functionality
            courses.add(new Course(creditHours, courseNumber, courseName, maxEnrollment));//add all created instances of Course into courses
        }
        return courses;//return courses List
    }

    public static void addStudentsToRegistry(List<Student> students, Registry registry) {
        for (Student student : students) {//for each Student instance in students List, add them to registry.
            registry.addStudent(student);//adding them to registry
        }
    }

    public static void addCoursesToRegistry(List<Course> courses, Registry registry) {
        for (Course course : courses) {
            registry.addCourse(course);// add Courses to Registry
        }
    }

    public static void enrollStudentsInCourses(List<Student> students, List<Course> courses, Registry registry) {
        for (Course course : courses) {
            for (Student student : students) {
                registry.enrollStudent(student, course);//enroll students in courses; method enrollStudent missing course.enrollStudent(student)
            }
        }
    }

    public static void printEnrollmentInfo(Registry registry) {//Printing enrollment information
        System.out.println("Enrollment Information:");
        for (Student student : registry.getStudents()) {
            System.out.println("Student ID: " + student.getStudentId() + " - " + student.getName());
            System.out.println("\tEnrolled in courses:");
            for (Course course : student.getCourse()) {
                System.out.println("\t\t" + course.getCourseNumber() + ": " + course.getCourseName());
            }
            System.out.println("\tWaitlisted for courses:");
            for (Course course : student.getWaitListed()) {
                System.out.println("\t\t" + course.getCourseNumber() + ": " + course.getCourseName());
            }
            System.out.println();
        }
    }
}













