public class Undergrad extends Student {
    private int year;


    public Undergrad(String firstName, String lastName, int id, int year) {
        super(firstName, lastName, id);
        setYear(year);
    }

    public int getYear() {
        return year;
    }
    /*
    needs to be able to go up to 4 years since undergrad is a 4 year process
     */
    public void setYear(int year) {
        if (year < 1 || year > 4)
            throw new IllegalArgumentException("Invalid input!");
        this.year = year;
    }
    public String toString() {
        return "Undergraduate: " + getFullName() + " " + "Student ID: " + getStudentId() + " Year: " + getYear();
    }
}
