package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class Professor extends Person {
    private String department;
 
    public Professor(String firstName, String lastName, String department) {
       super(firstName, lastName);
       this.department = department;
    }
 
    public String getDepartment() {
       return this.department;
    }
 
    public void setDepartment(String department) {
       this.department = department;
    }
 
    public String toString() {
       String var10000 = this.getFullName();
       return "Professor Name: " + var10000 + " " + this.getDepartment();
    }
 }
 