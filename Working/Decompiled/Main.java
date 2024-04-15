// package Working.Decompiled;

// // Source code is decompiled from a .class file using FernFlower decompiler.
// public class Main {
//    public Main() {
//    }

//    public static void main(String[] args) {
//       Registry registry = new Registry();

//       // Define semesters for the courses
//       Semester fall2024 = new Semester("Fall", 2024);
//       Semester spring2025 = new Semester("Spring", 2025);

//       // Create courses with semesters
//       Course cs101 = new Course(3, "CS101", "Intro to Computer Science", 30, fall2024);
//       Course math101 = new Course(4, "MATH101", "Calculus I", 30, spring2025);

//       // Add courses to registry
//       registry.addCourse(cs101);
//       registry.addCourse(math101);

//       // Create students and professor
//       Student alice = new Student("Alice", "Smith", 10001);
//       Undergrad bob = new Undergrad("Bob", "Jones", 10002, 1);
//       Professor sheldon = new Professor("Sheldon", "Cooper", "Physics");

//       // Add students to registry
//       registry.addStudent(alice);
//       registry.addStudent(bob);

//       // Enroll students in courses for specified semesters
//       registry.enrollStudent(alice, cs101, fall2024);
//       registry.enrollStudent(bob, math101, spring2025);

//       // Enroll additional students in CS101 for Fall 2024
//       for (int i = 0; i < 10; ++i) {
//          Student tempStudent = new Student("Temp", "Student" + i, 20000 + i);
//          registry.addStudent(tempStudent);
//          registry.enrollStudent(tempStudent, cs101, fall2024);
//       }

//       // Display enrolled and waitlisted students for CS101
//       System.out.println("Enrolled in CS101 for " + cs101.getSemester() + ":");
//       cs101.getEnrolledStudents().forEach(student -> System.out.println(student.getFullName()));

//       System.out.println("\nWaitlisted for CS101 for " + cs101.getSemester() + ":");
//       cs101.getWaitList().forEach(student -> System.out.println(student.getFullName()));

//       // Initialize a grocery store and assign shopping tasks
//       GroceryStore store = new GroceryStore("Campus Market");
//       store.addItem("Apples", 0.99);
//       store.addItem("Milk", 2.49);

//       // Alice creates and views her grocery list
//       alice.createGroceryList();
//       alice.addItemToGroceryList("Apples", 5, store);
//       alice.addItemToGroceryList("Milk", 1, store);
//       alice.viewGroceryList();

//       // Output registry information
//       System.out.println("\n" + registry);
//    }

// }

package Working.Decompiled;

import java.util.Scanner;
import java.util.List;

public class Main {
   private static Registry registry = new Registry();
   private static GroceryStore campusMarket = new GroceryStore("Campus Market");
   private static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
      initializeTestData();
      // Initialize the system with courses, students, professors, etc.
      // ...

      while (true) {
         System.out.println("Are you a 'Student' or a 'Professor'? Type 'Exit' to exit.");
         String userType = scanner.nextLine().trim().toLowerCase();

         if ("exit".equals(userType)) {
            System.out.println("Exiting the system. Goodbye!");
            break;
         }

         switch (userType) {
            case "student":
               handleStudent();
               break;
            case "professor":
               handleProfessor();
               break;
            default:
               System.out.println("Invalid option. Please try again.");
         }
      }
      scanner.close();
   }

   private static void initializeTestData() {
      // Create semesters
      Semester fall2024 = new Semester("Fall", 2024);
      Semester spring2025 = new Semester("Spring", 2025);

      // Create professors
      Professor prof1 = new Professor("John", "Doe", "Computer Science");
      Professor prof2 = new Professor("Jane", "Smith", "Mathematics");
      // prof1.setId(9001);  // Method setId should be defined in Professor class
      // prof2.setId(9002);
      registry.addProfessor(prof1);
      registry.addProfessor(prof2);

      // Create courses
      Course cs101 = new Course(3, "CS101", "Intro to Computer Science", 30, fall2024, prof1);
      Course math101 = new Course(4, "MATH101", "Calculus I", 30, spring2025, prof2);
      registry.addCourse(cs101);
      registry.addCourse(math101);

      // Create students
      Student student1 = new Student("Alice", "Johnson");
      Student student2 = new Student("Bob", "Brown");
      registry.addStudent(student1);
      registry.addStudent(student2);

      // Enroll students in courses
      registry.enrollStudent(student1, cs101, fall2024);
      registry.enrollStudent(student2, math101, spring2025);

      // Add grocery items to the market
      campusMarket.addItem("Apples", 0.99);
      campusMarket.addItem("Milk", 2.49);
      campusMarket.addItem("Bread", 1.99);

      // Initialize grocery lists for a test run
      student1.createGroceryList();
      student1.addItemToGroceryList("Apples", 5, campusMarket);
      student1.addItemToGroceryList("Milk", 1, campusMarket);

      student2.createGroceryList();
      student2.addItemToGroceryList("Bread", 2, campusMarket);
  }

   private static Semester getCurrentSemester() {
      // Return a new instance of Semester with current year and term
      return new Semester("Fall", 2023); // Adjust this based on your needs
  }
  
   private static void handleStudent() {
      System.out.println("Enter your student ID:");
      int studentId = Integer.parseInt(scanner.nextLine().trim());

      Student student = registry.findStudentById(studentId);
      if (student == null) {
         System.out.println("Student not found. Please try again.");
         return;
      }

      System.out.println("Are you an 'Undergrad' or 'Graduate' student?");
      String studentType = scanner.nextLine().trim().toLowerCase();

      Semester currentSemester = getCurrentSemester(); // Placeholder for getting the current semester

      switch (studentType) {
         case "undergrad":
            List<Course> undergradCourses = registry.getCoursesByLevelAndSemester("Undergrad", currentSemester);
            System.out.println("Undergraduate Courses available:");
            printCourses(undergradCourses);
            enrollInCourse(student, undergradCourses);
            break;
         case "graduate":
            List<Course> graduateCourses = registry.getCoursesByLevelAndSemester("Graduate", currentSemester);
            System.out.println("Graduate Courses available:");
            printCourses(graduateCourses);
            enrollInCourse(student, graduateCourses);
            break;
         default:
            System.out.println("Invalid student type. Please try again.");
            break;
      }

      handleGroceryList(student);
   }

   private static void printCourses(List<Course> courses) {
      if (courses.isEmpty()) {
         System.out.println("No courses available for this category and semester.");
         return;
      }

      for (Course course : courses) {
         System.out.println(course.getCourseNumber() + ": " + course.getCourseTitle() + " - " + course.getSemester());
      }
   }

   private static void enrollInCourse(Student student, List<Course> courses) {
      System.out.println("Enter the course number you wish to enroll in:");
      String courseNumber = scanner.nextLine().trim();

      Course selectedCourse = courses.stream()
            .filter(c -> c.getCourseNumber().equals(courseNumber))
            .findFirst()
            .orElse(null);

      if (selectedCourse == null) {
         System.out.println("Course not found. Please try again.");
         return;
      }

      if (registry.enrollStudent(student, selectedCourse, selectedCourse.getSemester())) {
         System.out.println("Enrollment successful.");
      } else {
         System.out.println("Enrollment failed. The course may be full or you are already enrolled.");
      }
   }

   private static void handleProfessor() {
      System.out.println("Enter your professor ID:");
      int professorId = Integer.parseInt(scanner.nextLine().trim());

      Professor professor = registry.findProfessorById(professorId); // Assuming there is a method to find professors by
                                                                     // ID
      if (professor == null) {
         System.out.println("Professor not found. Please try again.");
         return;
      }

      // Display the courses the professor is teaching
      List<Course> coursesTeaching = registry.getCoursesByProfessor(professor); // Assuming this method exists
      if (coursesTeaching.isEmpty()) {
         System.out.println("You are not teaching any courses this semester.");
      } else {
         System.out.println("You are teaching the following courses:");
         for (Course course : coursesTeaching) {
            System.out
                  .println(course.getCourseNumber() + ": " + course.getCourseTitle() + " - " + course.getSemester());
         }
      }

      // Handle grocery list after managing courses
      handleGroceryList(professor); // Passing the professor object to handle their grocery list
   }

   private static void handleGroceryList(Shopper shopper) {
      System.out.println("Would you like to manage your grocery list? (yes/no)");
      String response = scanner.nextLine().trim().toLowerCase();

      if ("yes".equals(response)) {
         String action = "";
         while (!"done".equals(action)) {
            System.out.println(
                  "Type 'add' to add an item, 'remove' to remove an item, 'view' to view your list, or 'done' to finish:");
            action = scanner.nextLine().trim().toLowerCase();

            switch (action) {
               case "add":
                  addItemToGroceryList(shopper);
                  break;
               case "remove":
                  removeItemFromGroceryList(shopper);
                  break;
               case "view":
                  shopper.viewGroceryList();
                  break;
               case "done":
                  System.out.println("Finished managing grocery list.");
                  break;
               default:
                  System.out.println("Invalid action. Please try again.");
                  break;
            }
         }
      }
   }

   private static void addItemToGroceryList(Shopper shopper) {
      System.out.println("Enter the item name to add:");
      String itemName = scanner.nextLine().trim();
      System.out.println("Enter the quantity:");
      int quantity = Integer.parseInt(scanner.nextLine().trim());

      shopper.addItemToGroceryList(itemName, quantity, campusMarket); // Assuming the Shopper interface has this method
      System.out.println("Item added to the grocery list.");
   }

   private static void removeItemFromGroceryList(Shopper shopper) {
      System.out.println("Enter the item name to remove:");
      String itemName = scanner.nextLine().trim();

      shopper.removeItemFromGroceryList(itemName); // Assuming the Shopper interface has this method
      System.out.println("Item removed from the grocery list.");
   }

}
