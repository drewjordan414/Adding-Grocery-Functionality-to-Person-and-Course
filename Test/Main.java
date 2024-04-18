import java.util.Scanner;

public class Main {
    private static Registry registry = new Registry();
    private static GroceryStore campusMarket = new GroceryStore("Campus Market");
    
    public static void main(String[] args) {
        initializeSystem(); // This should setup your system with initial data
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the University System");
            System.out.println("Are you a 'Student' or a 'Professor'? (Enter 'Exit' to exit)");
            String userType = scanner.nextLine().trim().toLowerCase();

            if ("exit".equals(userType)) {
                System.out.println("Exiting the system. Goodbye!");
                return;
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
                    break;
            }
        } // Scanner is auto-closed here
    }
    
    private static void initializeSystem() {
        // Initialize the system with test data
        Course course1 = new Course("COMP-271", "Capstone Project");
        Course course2 = new Course("COMP-101", "Introduction to Programming");
        Course course3 = new Course("COMP-201", "Data Structures");
        
        Student student1 = new Student("John Doe", "123456");
        Student student2 = new Student("Jane Smith", "789012");
        
        Professor professor1 = new Professor("Dr. Johnson", "A123");
        Professor professor2 = new Professor("Dr. Anderson", "B456");
        
        campusMarket.addCourse(course1);
        campusMarket.addCourse(course2);
        campusMarket.addCourse(course3);
        
        campusMarket.addStudent(student1);
        campusMarket.addStudent(student2);
        
        campusMarket.addProfessor(professor1);
        campusMarket.addProfessor(professor2);
        
        registry.addCourse(course1);
        registry.addCourse(course2);
        registry.addCourse(course3);
        
        registry.addStudent(student1);
        registry.addStudent(student2);
        
        registry.addProfessor(professor1);
        registry.addProfessor(professor2);
    }
    
    private static void handleStudent(Scanner scanner) {
        System.out.println("Please enter your full name:");
        String name = scanner.nextLine().trim();
    
        Student student = registry.findStudentByName(name);
        if (student == null) {
            // Create a new student if not found
            student = new Student(name.split(" ")[0], name.split(" ")[1]);
            registry.addStudent(student);
        }
    
        System.out.println("Are you an 'Undergraduate' or 'Graduate' student?");
        String studentType = scanner.nextLine().trim().toLowerCase();
        if ("undergraduate".equals(studentType)) {
            // handle undergraduate specific logic
        } else if ("graduate".equals(studentType)) {
            // handle graduate specific logic
        } else {
            System.out.println("Invalid student type. Please enter 'Undergraduate' or 'Graduate'.");
        }
    
        // ... Additional logic for enrolling in courses, managing grocery list, etc.
    }
    
    private static void handleProfessor(Scanner scanner) {
        System.out.println("Please enter your full name:");
        String name = scanner.nextLine().trim();
    
        Professor professor = registry.findProfessorByName(name);
        if (professor == null) {
            // Create a new professor if not found
            System.out.println("Please enter your department:");
            String department = scanner.nextLine().trim();
            professor = new Professor(name.split(" ")[0], name.split(" ")[1], department);
            registry.addProfessor(professor);
        }
    
        // Display the courses the professor is teaching
        List<Course> coursesTeaching = registry.getCoursesByProfessor(professor);
        if (coursesTeaching.isEmpty()) {
            System.out.println("You are not teaching any courses this semester.");
        } else {
            System.out.println("You are teaching the following courses:");
            for (Course course : coursesTeaching) {
                System.out.println(course.getCourseNumber() + ": " + course.getCourseTitle());
            }
        }
    
        // ... Additional logic for managing grocery list, including discounts if applicable
    }
    
    // Additional methods for student and professor operations...
}
