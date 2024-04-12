package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      Registry registry = new Registry();

      // Define semesters for the courses
      Semester fall2024 = new Semester("Fall", 2024);
      Semester spring2025 = new Semester("Spring", 2025);

      // Create courses with semesters
      Course cs101 = new Course(3, "CS101", "Intro to Computer Science", 30, fall2024);
      Course math101 = new Course(4, "MATH101", "Calculus I", 30, spring2025);

      // Add courses to registry
      registry.addCourse(cs101);
      registry.addCourse(math101);

      // Create students and professor
      Student alice = new Student("Alice", "Smith", 10001);
      Undergrad bob = new Undergrad("Bob", "Jones", 10002, 1);
      Professor sheldon = new Professor("Sheldon", "Cooper", "Physics");

      // Add students to registry
      registry.addStudent(alice);
      registry.addStudent(bob);

      // Enroll students in courses for specified semesters
      registry.enrollStudent(alice, cs101, fall2024);
      registry.enrollStudent(bob, math101, spring2025);

      // Enroll additional students in CS101 for Fall 2024
      for (int i = 0; i < 10; ++i) {
         Student tempStudent = new Student("Temp", "Student" + i, 20000 + i);
         registry.addStudent(tempStudent);
         registry.enrollStudent(tempStudent, cs101, fall2024);
      }

      // Display enrolled and waitlisted students for CS101
      System.out.println("Enrolled in CS101 for " + cs101.getSemester() + ":");
      cs101.getEnrolledStudents().forEach(student -> System.out.println(student.getFullName()));

      System.out.println("\nWaitlisted for CS101 for " + cs101.getSemester() + ":");
      cs101.getWaitList().forEach(student -> System.out.println(student.getFullName()));

      // Initialize a grocery store and assign shopping tasks
      GroceryStore store = new GroceryStore("Campus Market");
      store.addItem("Apples", 0.99);
      store.addItem("Milk", 2.49);

      // Alice creates and views her grocery list
      alice.createGroceryList();
      alice.addItemToGroceryList("Apples", 5, store);
      alice.addItemToGroceryList("Milk", 1, store);
      alice.viewGroceryList();

      // Output registry information
      System.out.println("\n" + registry);
   }

}
