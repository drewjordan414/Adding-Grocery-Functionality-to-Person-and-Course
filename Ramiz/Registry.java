import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Registry implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();

    // Add a student to the registry
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Add a course to the registry
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // Add a professor to the registry
    public void addProfessor(Professor professor) {
        if (!professors.contains(professor)) {
            professors.add(professor);
        }
    }

    // Find a professor by name
    public Professor findProfessorByName(String name) {
        return professors.stream()
                .filter(professor -> professor.getFullName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Enroll a student in a course, considering the semester
    public boolean enrollStudent(Student student, Course course, String semester) {
        if (students.contains(student) && courses.contains(course) && course.getSemester().equalsIgnoreCase(semester)) {
            if (course.getEnrolledStudents() != null && course.getEnrolledStudents().size() < course.getMaxEnrollment()) {
                course.enrollStudent(student);
                return true;
            } else {
                student.addWaitListedCourse(course);
                return false;
            }
        }
        return false;
    }

    // Find a student by name
    public Student findStudentByName(String name) {
        return students.stream()
                .filter(student -> student.getFullName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Get courses taught by a specific professor during a specific semester
    public List<Course> getCoursesByProfessorAndSemester(Professor professor, String semester) {
        return courses.stream()
                .filter(course -> course.getProfessor().equals(professor) && course.getSemester().equalsIgnoreCase(semester))
                .sorted((c1, c2) -> {
                    int nameComp = c1.getCourseTitle().compareToIgnoreCase(c2.getCourseTitle());
                    if (nameComp != 0) return nameComp;
                    return c1.getCourseNumber().compareToIgnoreCase(c2.getCourseNumber());
                })
                .collect(Collectors.toList());
    }

    // Remove a student from a course
    public void dropStudent(Student student, Course course) {
        if (students.contains(student) && courses.contains(course)) {
            course.removeStudent(student);
            student.removeCourse(course);
            student.removeFromWaitList(course);
        }
    }

    // Get all courses offered in a particular semester
    public List<Course> getCoursesBySemester(String semester) {
        return courses.stream()
                .filter(course -> course.getSemester().equalsIgnoreCase(semester))
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
            registryInfo.append("\nStudent: ").append(student.getFullName()).append("\tCourses: ");
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
}
