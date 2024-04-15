package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class Undergrad extends Student {
    private int year;
 
    public Undergrad(String firstName, String lastName, int id, int year) {
       super(firstName, lastName);
       this.setYear(year);
    }
 
    public int getYear() {
       return this.year;
    }
 
    public void setYear(int year) {
       if (year >= 1 && year <= 4) {
          this.year = year;
       } else {
          throw new IllegalArgumentException("Invalid input!");
       }
    }
 
    public String toString() {
       String var10000 = this.getFullName();
      //  return "Undergraduate: " + var10000 + " Student ID: " + this.getStudentId() + " Year: " + this.getYear();
       return "Undergraduate: " + var10000 + " Year: " + this.getYear();
    }
 }
 