package Working.Decompiled;

/**
 * Represents an academic semester with a term and a year.
 */
public class Semester {
    private String term;
    private int year;

    /**
     * Constructs a new Semester instance.
     *
     * @param term the academic term, e.g., "Spring", "Summer", "Fall"
     * @param year the academic year
     */
    public Semester(String term, int year) {
        setTerm(term);
        this.year = year;
    }

    public String getTerm() {
        return this.term;
    }

    /**
     * Sets the term for this semester.
     * Only "Spring", "Summer", and "Fall" are allowed.
     *
     * @param term the academic term to set
     * @throws IllegalArgumentException if the term is invalid
     */
    public void setTerm(String term) {
        if (!"Spring".equals(term) && !"Summer".equals(term) && !"Fall".equals(term)) {
            throw new IllegalArgumentException("Invalid term: " + term);
        }
        this.term = term;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Provides the next academic semester following this one.
     * @return the next Semester
     */
    public Semester getNextSemester() {
        switch (this.term) {
            case "Spring":
                return new Semester("Summer", this.year);
            case "Summer":
                return new Semester("Fall", this.year);
            case "Fall":
                return new Semester("Spring", this.year + 1);
            default:
                throw new IllegalStateException("Unexpected term value: " + this.term);
        }
    }

    @Override
    public String toString() {
        return this.term + " " + this.year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Semester semester = (Semester) obj;
        return year == semester.year && term.equals(semester.term);
    }

    @Override
    public int hashCode() {
        return 31 * term.hashCode() + year;
    }
}
