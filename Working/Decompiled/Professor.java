// package Working.Decompiled;

// // Source code is decompiled from a .class file using FernFlower decompiler.
// public class Professor extends Person {
//     private String department;
 
//     public Professor(String firstName, String lastName, String department) {
//        super(firstName, lastName);
//        this.department = department;
//     }
 
//     public String getDepartment() {
//        return this.department;
//     }
 
//     public void setDepartment(String department) {
//        this.department = department;
//     }
 
//     public String toString() {
//        String var10000 = this.getFullName();
//        return "Professor Name: " + var10000 + " " + this.getDepartment();
//     }
//  }
 

// package Working.Decompiled;

// import java.util.ArrayList;
// import java.util.List;

// public class Professor extends Person implements Shopper {
//     private String department;
//     private List<Course> coursesTaught; // A list to keep track of courses the professor teaches

//     public Professor(String firstName, String lastName, String department) {
//         super(firstName, lastName);
//         this.department = department;
//         this.coursesTaught = new ArrayList<>(); // Initialize the list of courses
//     }

//     public String getDepartment() {
//         return this.department;
//     }

//     public void setDepartment(String department) {
//         this.department = department;
//     }

//     // Method to add a course to the list of courses taught by the professor
//     public void addCourse(Course course) {
//         if (!this.coursesTaught.contains(course)) {
//             this.coursesTaught.add(course);
//         }
//     }

//     // Method to remove a course from the list of courses taught by the professor
//     public void removeCourse(Course course) {
//         this.coursesTaught.remove(course);
//     }

//     // Method to get the list of courses taught by the professor
//     public List<Course> getCoursesTaught() {
//         return this.coursesTaught;
//     }

//     @Override
//     public String toString() {
//         return "Professor Name: " + getFullName() + " | Department: " + getDepartment();
//     }
// }



package Working.Decompiled;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Person implements Shopper {
//    private int id;
    private String department;
    private List<Course> coursesTaught;
    private GroceryList groceryList;

    public Professor(String firstName, String lastName, String department) {
        super(firstName, lastName);
        this.department = department;
        this.coursesTaught = new ArrayList<>();
        this.groceryList = new GroceryList();
    }

//     public int getId() {
//       return id;
//   }

//   public void setId(int id) {
//       this.id = id;
//   }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addCourse(Course course) {
        if (!coursesTaught.contains(course)) {
            coursesTaught.add(course);
        }
    }

    public void removeCourse(Course course) {
        coursesTaught.remove(course);
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    @Override
    public void createGroceryList() {
        this.groceryList = new GroceryList();
    }

    @Override
    public boolean addItemToGroceryList(String itemName, int quantity, GroceryStore store) {
        GroceryItemOrder item = store.getOrder(itemName, quantity);
        if (item != null) {
            groceryList.add(item);
            return true;
        }
        return false;
    }

    @Override
    public void viewGroceryList() {
        System.out.println("Grocery List for " + getFullName() + ":\n" + groceryList);
    }

    @Override
    public boolean removeItemFromGroceryList(String itemName) {
        return groceryList.removeItem(itemName);
    }

    @Override
    public String toString() {
    //   return "Professor Name: " + getFullName() + " | Department: " + getDepartment() + " | ID: " + getId();
      return "Professor Name: " + getFullName() + " | Department: " + getDepartment();  
    }
}
