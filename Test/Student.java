import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String studentType; // "Undergraduate" or "Graduate"
    private List<Course> registeredCourses = new ArrayList<>();
    private List<Course> waitListedCourses = new ArrayList<>();
    private GroceryList groceryList;

    public Student(String firstName, String lastName, String studentType) {
        super(firstName, lastName, "Student");
        this.studentType = studentType;
        this.groceryList = new GroceryList();
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public void addRegisteredCourse(Course course) {
        if (!this.registeredCourses.contains(course) && course.getEnrolledStudents().size() < course.getMaxEnrollment()) {
            this.registeredCourses.add(course);
            course.getEnrolledStudents().add(this);  // Ensure bidirectional relationship is maintained
        } else {
            this.addWaitListedCourse(course);  // Automatically add to waitlist if full
        }
    }

    public void removeCourse(Course course) {
        if (registeredCourses.contains(course)) {
            this.registeredCourses.remove(course);
            course.getEnrolledStudents().remove(this);  // Maintain bidirectional relationship
        }
    }

    public void addWaitListedCourse(Course course) {
        if (!this.waitListedCourses.contains(course)) {
            this.waitListedCourses.add(course);
        }
    }

    public void removeFromWaitList(Course course) {
        this.waitListedCourses.remove(course);
    }

    public List<Course> getRegisteredCourses() {
        return new ArrayList<>(this.registeredCourses);  // Return a copy for encapsulation
    }

    public List<Course> getWaitListedCourses() {
        return new ArrayList<>(this.waitListedCourses);
    }

    @Override
    public void createGroceryList() {
        this.groceryList = new GroceryList();
    }

    @Override
    public boolean addItemToGroceryList(String itemName, int quantity, GroceryStore store) {
        GroceryItemOrder itemOrder = store.getOrder(itemName, quantity);
        if (itemOrder != null) {
            this.groceryList.add(itemOrder);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeItemFromGroceryList(String itemName) {
        return this.groceryList.removeItem(itemName);
    }

    @Override
    public void viewGroceryList() {
        System.out.println("Grocery List for " + this.getFullName() + ":\n" + this.groceryList);
    }

    @Override
    public String toString() {
        return "Student Name: " + this.getFullName() + " | Type: " + this.getStudentType();
    }
}


// Student Type: Added to differentiate between undergraduate and graduate students.
// Automatic Waitlisting: If a course is full upon trying to register, the student is automatically added to the waitlist.
// Bidirectional Course Management: Ensuring that both the course and student reflect enrollment and de-enrollment changes.
