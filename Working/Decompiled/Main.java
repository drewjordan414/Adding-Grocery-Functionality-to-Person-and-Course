package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class Main {
    public Main() {
    }
 
    public static void main(String[] args) {
       Registry registry = new Registry();
       Course cs101 = new Course(3, "CS101", "Intro to Computer Science", 30);
       Course math101 = new Course(4, "MATH101", "Calculus I", 30);
       registry.addCourse(cs101);
       registry.addCourse(math101);
       Student alice = new Student("Alice", "Smith", 10001);
       Undergrad bob = new Undergrad("Bob", "Jones", 10002, 1);
       new Professor("Sheldon", "Cooper", "Physics");
       registry.addStudent(alice);
       registry.addStudent(bob);
       registry.enrollStudent(alice, cs101);
       registry.enrollStudent(bob, math101);
 
       for(int i = 0; i < 30; ++i) {
          Student tempStudent = new Student("Temp", "Student" + i, 20000 + i);
          registry.addStudent(tempStudent);
          registry.enrollStudent(tempStudent, cs101);
       }
 
       System.out.println("Enrolled in CS101:");
       cs101.getEnrolledStudents().forEach((s) -> {
          System.out.println(s.getFullName());
       });
       System.out.println("\nWaitlisted for CS101:");
       cs101.getWaitList().forEach((s) -> {
          System.out.println(s.getFullName());
       });
       GroceryStore store = new GroceryStore("Campus Market");
       store.addItem("Apples", 0.99);
       store.addItem("Milk", 2.49);
       alice.createGroceryList();
       alice.addItemToGroceryList("Apples", 5, store);
       alice.addItemToGroceryList("Milk", 1, store);
       alice.viewGroceryList();
       System.out.println("\n" + registry);
    }
 }
 