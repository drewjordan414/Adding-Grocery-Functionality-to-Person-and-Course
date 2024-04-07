// public class Student extends Person {
//     private String firstName;
//     private String lastName;
//     private int studentId;

//     public Student(String firstName, String lastName, int id) {
//         super(firstName, lastName);
//         studentId = id;
//     }

//     public int getStudentId() {
//         return studentId;
//     }

//     public String toString() {
//         return "Student Name: " + getFullName() + " Student ID: " + getStudentId();
//     }
// }



// refractored code:
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Shopper {
    private int studentId;
    private List<Course> registeredCourses = new ArrayList<>();
    private List<Course> waitListedCourses = new ArrayList<>();
    private GroceryList groceryList; // Attribute to hold the student's grocery list

    public Student(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.studentId = id;
        this.groceryList = new GroceryList(); // Initialize the grocery list
    }

    public int getStudentId() {
        return studentId;
    }

    public void addRegisteredCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
        }
    }

    public void removeCourse(Course course) {
        registeredCourses.remove(course);
    }

    public void addWaitListedCourse(Course course) {
        if (!waitListedCourses.contains(course)) {
            waitListedCourses.add(course);
        }
    }

    public void removeFromWaitList(Course course) {
        waitListedCourses.remove(course);
    }

    public List<Course> getRegisteredCourses() {
        return new ArrayList<>(registeredCourses);
    }

    public List<Course> getWaitListedCourses() {
        return new ArrayList<>(waitListedCourses);
    }

    @Override
    public void createGroceryList() {
        this.groceryList = new GroceryList();
    }

    @Override
    public void addItemToGroceryList(String itemName, int quantity, GroceryStore store) {
        GroceryItemOrder itemOrder = store.getOrder(itemName, quantity);
        if (itemOrder != null) {
            this.groceryList.add(itemOrder);
        } else {
            System.out.println("Item " + itemName + " could not be added to the list (not found in store).");
        }
    }

    @Override
    public void viewGroceryList() {
        System.out.println("Grocery List for " + getFullName() + ":\n" + this.groceryList);
    }

    @Override
    public String toString() {
        return "Student Name: " + getFullName() + " | Student ID: " + getStudentId();
    }
}
