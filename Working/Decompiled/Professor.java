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
 

package Working.Decompiled;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Person {
    private String department;
    private List<Course> coursesTaught; // A list to keep track of courses the professor teaches

    public Professor(String firstName, String lastName, String department) {
        super(firstName, lastName);
        this.department = department;
        this.coursesTaught = new ArrayList<>(); // Initialize the list of courses
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Method to add a course to the list of courses taught by the professor
    public void addCourse(Course course) {
        if (!this.coursesTaught.contains(course)) {
            this.coursesTaught.add(course);
        }
    }

    // Method to remove a course from the list of courses taught by the professor
    public void removeCourse(Course course) {
        this.coursesTaught.remove(course);
    }

    // Method to get the list of courses taught by the professor
    public List<Course> getCoursesTaught() {
        return this.coursesTaught;
    }

    @Override
    public String toString() {
        return "Professor Name: " + getFullName() + " | Department: " + getDepartment();
    }
}
