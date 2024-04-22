import java.util.List;
import java.util.Scanner;

public class Main {
    private static Registry registry = new Registry();
    private static GroceryStore campusMarket = new GroceryStore("Campus Market");

    public static void main(String[] args) {
        initializeSystem(); // Initialize with predefined data
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the University Management System!");
        while (true) {
            System.out.println("Are you a 'Student' or a 'Professor'? Type 'Exit' to exit.");
            String userType = scanner.nextLine().trim().toLowerCase();

            if ("exit".equals(userType)) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            }
            if (userType.equals("student")) {
                handleStudent(scanner);
            } else if (userType.equals("professor")) {
                handleProfessor(scanner);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void handleProfessor(Scanner scanner) {
        System.out.println("Enter your first name or type 'Exit' to quit:");
        String firstName = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(firstName)) {
            System.out.println("Exiting registration.");
            return; // Exits the method early
        }


        System.out.println("Enter your last name or type 'Exit' to quit:");
        String lastName = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(lastName)) {
            System.out.println("Exiting registration.");
            return; // Exits the method early
        }


        System.out.println("Enter your department or type 'Exit' to quit:");
        String department = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(department)) {
            System.out.println("Exiting registration.");
            return; // Exits the method early
        }
        Professor professor = new Professor(firstName, lastName, department);
        int id = registry.addProfessor(professor);
        System.out.println("Welcome, Professor! Your ID is: " + id);


        boolean done = false;
        while (!done) {
            System.out.println("Would you like to (1) view grocery list, (2) add item to grocery list, (3) remove item from grocery list, (4) manage courses, or (5) exit?");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    viewGroceryList(professor);
                    break;
                case "2":
                    addItemToGroceryList(scanner, professor);
                    break;
                case "3":
                    removeItemFromGroceryList(scanner, professor);
                    break;
                case "4":
                    handleProfessorCourses(scanner, professor);
                    break;
                case "5":
                    System.out.println("Exiting professor services.");
                    done = true; // This ensures we exit the loop entirely
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }




    public static void handleProfessorCourses(Scanner scanner, Professor professor) {
        boolean done = false;
        System.out.println("Entering course management for Professor: " + professor.getFullName());
        while (!done) {
            System.out.println("Choose an option: (1) Assign to course, (2) List courses by semester, (3) Exit");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("Which course would you like to assign to " + professor.getFullName() + "? Enter the course number:");
                    String courseNumber = scanner.nextLine().trim();
                    System.out.println("Enter the semester for the course assignment:");
                    String semester = scanner.nextLine().trim();
                    if (registry.courseExists(courseNumber, semester)) {
                        registry.assignProfessorToCourse(professor.getFullName(), courseNumber, semester);
                        System.out.println("Assignment successful.");
                    } else {
                        System.out.println("Course or semester does not exist.");
                    }
                    break;
                case "2":
                    registry.listCoursesByProfessor(scanner, professor);
                    break;
                case "3":
                    System.out.println("Exiting course management.");
                    done = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }


    private static void initializeSystem() {
        // Initialize courses and other startup settings
        registry.initializeCourses();  // Make sure this method is appropriately defined and accessible
    }

    private static void handleStudent(Scanner scanner) {
        System.out.println("Enter your first name or type 'Exit' to quit:");
        String firstName = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(firstName)) {
            System.out.println("Exiting registration.");
            return; // Exits the method early
        }
    
        System.out.println("Enter your last name or type 'Exit' to quit:");
        String lastName = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(lastName)) {
            System.out.println("Exiting registration.");
            return; // Exits the method early
        }
    
        System.out.println("Are you an 'Undergraduate' or 'Graduate' student? Type 'Exit' to quit:");
        String studentType = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(studentType)) {
            System.out.println("Exiting registration.");
            return; // Exits the method early
        }
        Student student = new Student(firstName, lastName, studentType);
        int id = registry.addStudent(student); // Ensure this method correctly assigns and returns an ID
        System.out.println("Welcome, " + studentType + " Student! Your ID is: " + id);

        boolean done = false;
        while (!done) {
            System.out.println("Choose an option: (1) Manage courses, (2) Manage grocery list, (3) Exit");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    manageCourses(scanner, student);
                    break;
                case "2":
                    manageGroceryList(scanner, student);
                    break;
                case "3":
                    System.out.println("Exiting student services.");
                    done = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void manageCourses(Scanner scanner, Student student) {
        boolean done = false;
        while (!done) {
            System.out.println("Select an option: (1) View available courses, (2) Enroll in a course, (3) Drop a course, (4) View enrolled courses, (5) Exit course management");
            String option = scanner.nextLine().trim();
            switch (option) {
                case "1":
                    viewCourses();
                    break;
                case "2":
                    enrollInCourse(scanner, student);
                    break;
                case "3":
                    dropCourse(scanner, student);
                    break;
                case "4":
                    viewEnrolledCourses(student);
                    break;
                case "5":
                    System.out.println("Exiting course management.");
                    done = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void viewCourses() {
        System.out.println("Available Courses:");
        List<Course> courses = registry.getAllCourses(); // This method should be implemented in Registry to return all courses
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                System.out.println(course.getCourseNumber() + ": " + course.getCourseTitle() + " - " + course.getSemester());
            }
        }
    }

    private static void enrollInCourse(Scanner scanner, Student student) {
        System.out.println("Enter the course number you wish to enroll in:");
        String courseNumber = scanner.nextLine().trim();
        System.out.println("Enter the semester:");
        String semester = scanner.nextLine().trim();
        Course course = registry.findCourseByNumberAndSemester(courseNumber, semester);
        if (course != null && course.enrollStudent(student)) {
            System.out.println("Enrollment successful in " + course.getCourseTitle());
        } else {
            System.out.println("Enrollment failed. Course may be full or does not exist.");
        }
    }

    private static void dropCourse(Scanner scanner, Student student) {
        System.out.println("Enter the course number you wish to drop:");
        String courseNumber = scanner.nextLine().trim();
        System.out.println("Enter the semester:");
        String semester = scanner.nextLine().trim();
        Course course = registry.findCourseByNumberAndSemester(courseNumber, semester);
        if (course != null && student.removeCourse(course)) {
            System.out.println("Dropped " + course.getCourseTitle() + " successfully.");
        } else {
            System.out.println("Failed to drop the course. You might not be enrolled.");
        }
    }

    private static void manageGroceryList(Scanner scanner, Person person) {
        boolean done = false;
        while (!done) {
            System.out.println("Would you like to (1) view grocery list, (2) add item to grocery list, (3) remove item from grocery list, or (4) exit?");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    viewGroceryList(person);
                    break;
                case "2":
                    addItemToGroceryList(scanner, person);
                    break;
                case "3":
                    removeItemFromGroceryList(scanner, person);
                    break;
                case "4":
                    System.out.println("Exiting grocery list management.");
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }






    private static void addItemToGroceryList(Scanner scanner, Person person) {
        System.out.println("Enter the item name to add:");
        String itemName = scanner.nextLine().trim();
        System.out.println("Enter the quantity:");
        int quantity = Integer.parseInt(scanner.nextLine().trim());

        if (person.addItemToGroceryList(itemName, quantity, campusMarket)) {
            System.out.println("Added " + quantity + " of " + itemName + " to your grocery list.");
        } else {
            System.out.println("Failed to add item. It might not be available.");
        }
    }

    private static void removeItemFromGroceryList(Scanner scanner, Person person) {
        System.out.println("Enter the item name to remove:");
        String itemName = scanner.nextLine().trim();

        if (person.removeItemFromGroceryList(itemName)) {
            System.out.println("Removed " + itemName + " from your grocery list.");
        } else {
            System.out.println("Item not found in your grocery list.");
        }
    }

    private static void viewGroceryList(Person person) {
        System.out.println(person.getGroceryList());
    }


    // Additional methods for interacting with courses and the grocery system
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

    private static void enrollInCourse(Student student, String courseNumber, String semester) {
        Course course = registry.findCourseByNumberAndSemester(courseNumber, semester);
        if (course != null && course.enrollStudent(student)) {
            System.out.println("Enrollment successful in " + course.getCourseTitle());
        } else {
            System.out.println("Enrollment failed. Course may be full or does not exist.");
        }
    }

    private static void dropCourse(Student student, String courseNumber, String semester) {
        Course course = registry.findCourseByNumberAndSemester(courseNumber, semester);
        if (course != null && student.removeCourse(course)) {
            System.out.println("Dropped " + course.getCourseTitle() + " successfully.");
        } else {
            System.out.println("Failed to drop the course. You might not be enrolled.");
        }
    }

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
}
