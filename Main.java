public class Main {
    public static void main(String[] args) {
        // Create grocery stores
        GroceryStore store1 = new GroceryStore("Store1");
        store1.addItem("Apples", 0.99);
        store1.addItem("Bread", 2.49);
        store1.addItem("Milk", 1.49);

        GroceryStore store2 = new GroceryStore("Store2");
        store2.addItem("Apples", 1.09); 
        store2.addItem("Eggs", 2.99);

        // Create persons
        Person person1 = new Person("Doe", "John", 1, 1, 2000);
        person1.createGroceryList();
        person1.addItemToGroceryList("Apples", 5, store1); 
        person1.addItemToGroceryList("Bread", 2, store1);

        // Second person
        Person person2 = new Person("Smith", "Jane", 5, 5, 1995);
        person2.createGroceryList();
        person2.addItemToGroceryList("Apples", 3, store2); 
        person2.addItemToGroceryList("Eggs", 1, store2); 

        // View grocery lists
        System.out.println("Person 1's Grocery List:");
        person1.viewGroceryList();
        System.out.println("\nPerson 2's Grocery List:");
        person2.viewGroceryList();


        // Create courses
        Course course1 = new Course("Math", 101, "Algebra", 30);
        Course course2 = new Course("Science", 201, "Biology", 25);
        Student student1 = new Student("Brown", "Charlie", 12, 12, 1998, "S123456");
        Student student2 = new Student("Van Pelt", "Lucy", 4, 4, 1999, "S654321");

        // Enroll in courses
        boolean enrollmentSuccess1 = student1.enrollCourse(course1);
        boolean enrollmentSuccess2 = student2.enrollCourse(course2);
        System.out.println("\nEnrollment Status:");
        System.out.println("Student 1 enrolled in Math 101: " + enrollmentSuccess1);
        System.out.println("Student 2 enrolled in Science 201: " + enrollmentSuccess2);
        System.out.println("\nEnrolled Students in Math 101:");
        System.out.println(course1.getEnrolledStudents());
        System.out.println("\nEnrolled Students in Science 201:");
        System.out.println(course2.getEnrolledStudents());
    }
}