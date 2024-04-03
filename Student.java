import java.util.*;

public class Student extends Person implements Comparable<Person> {
    private int studentId;
    private int totalCreditHours;
    private Set<Course> registeredCourses;
    private List<Course> waitListedCourses;

    public Student(String firstName, String familyName, int studentId){
        super(firstName, familyName);
        this.studentId = studentId;
        this.registeredCourses = new TreeSet<>();
        this.totalCreditHours = 0;
        this.waitListedCourses = new LinkedList<>();
        Admin.getInstance().addStudent(this);
    }


    public Student(Person person, int studentId){
        super(person.getFirstName(), person.getLastName());
        this.studentId = studentId;
        this.registeredCourses = new TreeSet<>();
        this.totalCreditHours = 0;
        Admin.getInstance().addStudent(this);
    }

    public void addRegisteredCourse(Course course) {
        this.registeredCourses.add(course);
        this.totalCreditHours += course.getCreditHours();
    }

    public void addWaitListedCourse(Course course) {
        this.waitListedCourses.add(course);
    }

    public void dropCourse(Course course){
        if(this.registeredCourses.contains(course)) {
            this.registeredCourses.remove(course);
            this.totalCreditHours -= course.getCreditHours();
            course.removeStudent(this);
        }
    }

    public String toString(){
        return this.getLastName()+", "+getFirstName();
    }


    public int compareTo(Student other){
            int compareLastName = this.getLastName().compareTo(other.getLastName());
            if (compareLastName != 0) {
                return compareLastName;
            }
            return this.getFirstName().compareTo(other.getFirstName());
    }

    public double applyMyDiscount() {
        GroceryList myGroceryList = getGroceryList();
        if (myGroceryList == null) return 0;
        double totalCost = myGroceryList.currentBalance();
        return totalCost * 0.9; // Apply a 10% discount for UnderGrad students
    }

   public Set<Course> getRegisteredCourses(){
        return this.registeredCourses;
   }

    public int getStudentId(){
        return this.studentId;
   }

   public int getCreditHours(){
        return this.totalCreditHours;

    }
}

