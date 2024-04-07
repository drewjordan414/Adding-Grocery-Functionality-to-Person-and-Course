
public class Main {
    public static void main(String[] args) {
        // Registry setup
        Registry registry = new Registry();
        
        // Creating courses
        Course cs101 = new Course(3, "CS101", "Intro to Computer Science", 30);
        Course math101 = new Course(4, "MATH101", "Calculus I", 30);
        
        // Adding courses to registry
        registry.addCourse(cs101);
        registry.addCourse(math101);
        
        // Creating students and professor
        Student alice = new Student("Alice", "Smith", 10001);
        Undergrad bob = new Undergrad("Bob", "Jones", 10002, 1);
        Professor drCooper = new Professor("Sheldon", "Cooper", "Physics");
        
        // Adding students to registry
        registry.addStudent(alice);
        registry.addStudent(bob);
        
        // Enrolling students in courses
        registry.enrollStudent(alice, cs101);
        registry.enrollStudent(bob, math101);
        
        // Attempting to enroll a student in a full course to test waitlisting
        for (int i = 0; i < 30; i++) {
            Student tempStudent = new Student("Temp", "Student" + i, 20000 + i);
            registry.addStudent(tempStudent);
            registry.enrollStudent(tempStudent, cs101);
        }
        
        // Print enrolled students and waitlisted students for CS101
        System.out.println("Enrolled in CS101:");
        cs101.getEnrolledStudents().forEach(s -> System.out.println(s.getFullName()));
        
        System.out.println("\nWaitlisted for CS101:");
        cs101.getWaitList().forEach(s -> System.out.println(s.getFullName()));
        
        // Grocery shopping simulation
        GroceryStore store = new GroceryStore("Campus Market");
        store.addItem("Apples", 0.99);
        store.addItem("Milk", 2.49);
        
        // Assuming Student implements Shopper, if not, adjust accordingly
        alice.createGroceryList();
        alice.addItemToGroceryList("Apples", 5, store);
        alice.addItemToGroceryList("Milk", 1, store);
        alice.viewGroceryList();
        
        // Print registry
        System.out.println("\n" + registry);
    }
}
