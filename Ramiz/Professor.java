public class Professor extends Person {
    private String department;

    public Professor(String firstName, String lastName, String department) {
        super(firstName, lastName);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String toString() {
        return "Professor Name: " + getFullName() + " " + getDepartment();
    }


}
