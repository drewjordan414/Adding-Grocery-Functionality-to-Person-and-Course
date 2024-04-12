package Working.Decompiled;

public class Semester {
    private String term;
    private int year;

    public Semester(String term, int year) {
        this.term = term;
        this.year = year;
    }

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
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
        return year == semester.year &&
               (term != null ? term.equals(semester.term) : semester.term == null);
    }

    @Override
    public int hashCode() {
        int result = (term != null ? term.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}

