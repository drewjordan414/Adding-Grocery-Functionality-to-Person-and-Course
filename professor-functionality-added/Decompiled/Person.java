package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class Person {
    private String firstName;
    private String lastName;
 
    public Person(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
    }
 
    public String getFirstName() {
       return this.firstName;
    }
 
    public void setFirstName(String firstName) {
       this.firstName = firstName;
    }
 
    public String getLastName() {
       return this.lastName;
    }
 
    public void setLastName(String lastName) {
       this.lastName = lastName;
    }
 
    public String getFullName() {
       String var10000 = this.getFirstName();
       return var10000 + " " + this.getLastName();
    }
 
    public String toString() {
       return "Name: " + this.getFullName();
    }
 }
 