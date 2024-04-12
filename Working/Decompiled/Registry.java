
package Working.Decompiled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Registry implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public Registry() {
    }

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
        }
    }

    public void addCourse(Course course) {
        if (!this.courses.contains(course)) {
            this.courses.add(course);
        }
    }

    public boolean enrollStudent(Student student, Course course, Semester semester) {
        if (this.students.contains(student) && this.courses.contains(course) && course.getSemester().equals(semester)) {
            if (course.getEnrolledStudents().size() < course.getMaxEnrollment()) {
                course.enrollStudent(student);
                return true;
            } else {
                student.addWaitListedCourse(course);
                return false;
            }
        } else {
            return false;
        }
    }

    public void dropStudent(Student student, Course course) {
        if (this.students.contains(student) && this.courses.contains(course)) {
            course.removeStudent(student);
            student.removeCourse(course);
            student.removeFromWaitList(course);
            course.checkWaitList();
        }
    }

    // New method to get courses by semester
    public List<Course> getCoursesBySemester(Semester semester) {
        return courses.stream()
                      .filter(course -> course.getSemester().equals(semester))
                      .collect(Collectors.toList());
    }

    // New method to get students by semester
    public List<Student> getStudentsBySemester(Semester semester) {
        List<Student> studentsForSemester = new ArrayList<>();
        for (Course course : getCoursesBySemester(semester)) {
            studentsForSemester.addAll(course.getEnrolledStudents());
        }
        return studentsForSemester.stream().distinct().collect(Collectors.toList()); // Remove duplicates
    }

    @Override
    public String toString() {
        StringBuilder registryInfo = new StringBuilder("LOYOLA COMPUTER SCIENCE DEPARTMENT: \n\tRegistry\n");
        for (Student student : students) {
            registryInfo.append("\nStudent: ").append(student.getFullName())
                        .append("\tStudent ID: ").append(student.getStudentId())
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

    @Override
    public Iterator<Student> iterator() {
        return this.students.iterator();
    }
}

