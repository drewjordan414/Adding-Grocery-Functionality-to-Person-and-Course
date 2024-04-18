import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Registry implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();
    private List<Semester> semesters = new ArrayList<>(); // Manage semesters directly

    public Registry() {
        initializeSemesters();
        initializeCourses();
    }


    private void initializeSemesters() {
        // Assuming semesters start from a specific year and generate forward
        int startYear = 2024;
        semesters.add(new Semester("Spring", startYear));
        semesters.add(new Semester("Summer", startYear));
        semesters.add(new Semester("Fall", startYear));
        semesters.add(new Semester("Spring", startYear + 1));
        semesters.add(new Semester("Summer", startYear + 1));
        semesters.add(new Semester("Fall", startYear + 1));
        // Continue adding as needed
    }


    private void initializeCourses() {
        // Sample professors
        Professor prof1 = new Professor("John", "Doe", "Computer Science", 1);
        Professor prof2 = new Professor("Jane", "Smith", "Mathematics", 2);
        addProfessor(prof1);
        addProfessor(prof2);

        // Sample courses
        Course course1 = new Course(3, "CS101", "Introduction to Computer Science", 5, "Fall 2024", prof1, "Undergraduate");
        Course course2 = new Course(4, "MATH101", "Calculus I", 5, "Spring 2025", prof2, "Undergraduate");
        addCourse(course1);
        addCourse(course2);
    }
    


    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void addProfessor(Professor professor) {
        if (!professors.contains(professor)) {
            professors.add(professor);
        }
    }

    public Professor findProfessorByName(String name) {
        return professors.stream()
                         .filter(professor -> professor.getFullName().equalsIgnoreCase(name))
                         .findFirst()
                         .orElse(null);
    }

    public Student findStudentByName(String name) {
        return students.stream()
                       .filter(student -> student.getFullName().equalsIgnoreCase(name))
                       .findFirst()
                       .orElse(null);
    }

    public boolean enrollStudent(Student student, Course course, Semester semester) {
        if (students.contains(student) && courses.contains(course) && course.getSemester().equals(semester)) {
            return course.enrollStudent(student);
        }
        return false;
    }

    public void dropStudent(Student student, Course course) {
        if (students.contains(student) && courses.contains(course)) {
            course.removeStudent(student);
            student.removeCourse(course);
        }
    }

    public List<Course> getCoursesByLevelAndSemester(String level, Semester semester) {
        return courses.stream()
                      .filter(course -> course.getLevel().equalsIgnoreCase(level) && course.getSemester().equals(semester))
                      .collect(Collectors.toList());
    }

    public List<Course> getCoursesByProfessor(Professor professor) {
        return professors.stream()
                         .flatMap(prof -> prof.getCoursesTaught().stream())
                         .collect(Collectors.toList());
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    @Override
    public String toString() {
        StringBuilder registryInfo = new StringBuilder("LOYOLA COMPUTER SCIENCE DEPARTMENT: \n\tRegistry\n");
        for (Student student : students) {
            registryInfo.append("\nStudent: ").append(student.getFullName())
                        .append("\tCourses: ");
            for (Course course : student.getRegisteredCourses()) {
                registryInfo.append(course.getCourseTitle()).append(" (")
                            .append(course.getSemester()).append("), ");
            }
            registryInfo.append("\nWaitlisted: ");
            for (Course course : student.getWaitListedCourses()) {
                registryInfo.append(course.getCourseTitle()).append(" (")
                            .append(course.getSemester()).append("), ");
            }
            registryInfo.append("\n");
        }
        registryInfo.append("\tCourses:\n");
        for (Course course : courses) {
            registryInfo.append("\t").append(course.getCourseTitle()).append(" - ")
                        .append(course.getSemester()).append("\n");
        }
        return registryInfo.toString();
    }

    // Nested class to manage Semester within Registry
    public class Semester {
        private String term;
        private int year;

        public Semester(String term, int year) {
            this.term = term;
            this.year = year;
        }

        public String getTerm() {
            return term;
        }

        public int getYear() {
            return year;
        }

        @Override
        public String toString() {
            return term + " " + year;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Semester)) return false;
            Semester other = (Semester) obj;
            return year == other.year && term.equals(other.term);
        }

        @Override
        public int hashCode() {
            return 31 * term.hashCode() + year;
        }
    }
}

