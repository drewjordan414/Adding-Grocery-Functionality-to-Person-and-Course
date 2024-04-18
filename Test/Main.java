import java.util.List;
import java.util.Scanner;

public class Main {
    private static Registry registry = new Registry();
    private static GroceryStore campusMarket = new GroceryStore("Campus Market");

    public static void main(String[] args) {
        // registry.initializeCourses(); // Initialize with predefined data
        initializeSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the University Management System!");
        while (true) {
            System.out.println("Are you a 'Student' or a 'Professor'? Type 'Exit' to exit.");
            String userType = scanner.nextLine().trim().toLowerCase();

            if ("exit".equals(userType)) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            }

            switch (userType) {
                case "student":
                    handleStudent(scanner);
                    break;
                case "professor":
                    handleProfessor(scanner);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeSystem() {
        registry.initializeCourses();  // Make sure this method is public or package-private
    }

    private static void handleStudent(Scanner scanner) {
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine().trim();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine().trim();
        System.out.println("Are you an 'Undergraduate' or 'Graduate' student?");
        String studentType = scanner.nextLine().trim();
        int id = registry.addStudent(new Student(firstName, lastName, studentType)); // Assumes addStudent returns an ID
        System.out.println("Welcome, " + studentType + " Student! Your ID is: " + id);
        // Additional student-specific interactions
    }

    private static void handleProfessor(Scanner scanner) {
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine().trim();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine().trim();
        System.out.println("Enter your department:");
        String department = scanner.nextLine().trim();
        int id = registry.addProfessor(new Professor(firstName, lastName, department)); // Assumes addProfessor returns an ID
        System.out.println("Welcome, Professor! Your ID is: " + id);
        // Additional professor-specific interactions
    }

    // Additional methods for interacting with courses and the grocery system
     // Method to list all courses available for a given semester
     private static void listCourses(String semester) {
        List<Course> courses = registry.getCoursesBySemester(semester);
        if (courses.isEmpty()) {
            System.out.println("No courses available for " + semester);
        } else {
            System.out.println("Available Courses for " + semester + ":");
            for (Course course : courses) {
                System.out.println(course.getCourseNumber() + ": " + course.getCourseTitle());
            }
        }
    }

    // Method to enroll in a course
    private static void enrollInCourse(Student student, String courseNumber, String semester) {
        Course course = registry.findCourseByNumberAndSemester(courseNumber, semester);
        if (course != null && course.enrollStudent(student)) {
            System.out.println("Enrollment successful in " + course.getCourseTitle());
        } else {
            System.out.println("Enrollment failed. Course may be full or does not exist.");
        }
    }

    // Method to drop a course
    private static void dropCourse(Student student, String courseNumber, String semester) {
        Course course = registry.findCourseByNumberAndSemester(courseNumber, semester);
        if (course != null && student.removeCourse(course)) {
            System.out.println("Dropped " + course.getCourseTitle() + " successfully.");
        } else {
            System.out.println("Failed to drop the course. You might not be enrolled.");
        }
    }
    

    // Method to view all enrolled courses
    private static void viewEnrolledCourses(Student student) {
        List<Course> courses = student.getRegisteredCourses();
        if (courses.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
        } else {
            System.out.println("You are currently enrolled in:");
            for (Course course : courses) {
                System.out.println(course.getCourseNumber() + ": " + course.getCourseTitle());
            }
        }
    }

    // Grocery Store interactions

    // Method to view items in the grocery store
    private static void viewGroceryStoreItems() {
        System.out.println(campusMarket);
    }

    // Method to add item to grocery list
    private static void addItemToGroceryList(Person person, String itemName, int quantity) {
        if (person.addItemToGroceryList(itemName, quantity, campusMarket)) {
            System.out.println("Added " + quantity + " of " + itemName + " to your grocery list.");
        } else {
            System.out.println("Failed to add item. It might not be available.");
        }
    }

    // Method to remove item from grocery list
    private static void removeItemFromGroceryList(Person person, String itemName) {
        if (person.removeItemFromGroceryList(itemName)) {
            System.out.println("Removed " + itemName + " from your grocery list.");
        } else {
            System.out.println("Item not found in your grocery list.");
        }
    }

    // Method to view grocery list
    private static void viewGroceryList(Person person) {
        System.out.println(person.getGroceryList());
    }
}
