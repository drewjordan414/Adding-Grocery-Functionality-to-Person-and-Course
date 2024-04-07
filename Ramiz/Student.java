public class Student extends Person {
    private String firstName;
    private String lastName;
    private int studentId;

    public Student(String firstName, String lastName, int id) {
        super(firstName, lastName);
        studentId = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public String toString() {
        return "Student Name: " + getFullName() + " Student ID: " + getStudentId();
    }
}
