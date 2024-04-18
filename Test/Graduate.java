public class Graduate extends Student {
    private int year;

    // Constructor for Graduate students, assuming year could be relevant for their program as well
    public Graduate(String firstName, String lastName, String studentType, int year) {
        super(firstName, lastName, studentType); // Pass 'Graduate' as a studentType from wherever you instantiate this class
        this.setYear(year);
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if (year < 1) {  // Assuming graduate years might be less strictly defined, e.g., for PhD students
            throw new IllegalArgumentException("Year must be at least 1.");
        }
        this.year = year;
    }

    // Method to get the discount rate for a graduate
    public double getDiscountRate() {
        // Graduates get a 10% discount
        return 0.10;
    }

    @Override
    public String toString() {
        return "Graduate: " + getFullName() + " Year: " + getYear();
    }
}
