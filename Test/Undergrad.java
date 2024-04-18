public class Undergrad extends Student {
    private int year;
 
    // Updated constructor to match the updated Student class constructor
    public Undergrad(String firstName, String lastName, String studentType, int year) {
       super(firstName, lastName, studentType); // Pass 'Undergraduate' as a studentType from wherever you instantiate this class
       this.setYear(year);
    }
 
    public int getYear() {
       return this.year;
    }
 
    public void setYear(int year) {
       if (year < 1 || year > 4) {
          throw new IllegalArgumentException("Year must be between 1 and 4.");
       }
       this.year = year;
    }

    // Method to get the discount rate for an undergraduate
    public double getDiscountRate() {
        // Undergraduates get no discount
        return 0.0;
    }
 
    @Override
    public String toString() {
       return "Undergraduate: " + getFullName() + " Year: " + getYear();
    }
}
