
// package Working.Decompiled;

// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.List;
// import java.util.stream.Collectors;

// public class Registry implements Iterable<Student> {
//     private List<Student> students = new ArrayList<>();
//     private List<Course> courses = new ArrayList<>();

//     public Registry() {
//     }

//     public void addStudent(Student student) {
//         if (!this.students.contains(student)) {
//             this.students.add(student);
//         }
//     }

//     public void addCourse(Course course) {
//         if (!this.courses.contains(course)) {
//             this.courses.add(course);
//         }
//     }

//     public boolean enrollStudent(Student student, Course course, Semester semester) {
//         if (this.students.contains(student) && this.courses.contains(course) && course.getSemester().equals(semester)) {
//             if (course.getEnrolledStudents().size() < course.getMaxEnrollment()) {
//                 course.enrollStudent(student);
//                 return true;
//             } else {
//                 student.addWaitListedCourse(course);
//                 return false;
//             }
//         } else {
//             return false;
//         }
//     }

//     public void dropStudent(Student student, Course course) {
//         if (this.students.contains(student) && this.courses.contains(course)) {
//             course.removeStudent(student);
//             student.removeCourse(course);
//             student.removeFromWaitList(course);
//             course.checkWaitList();
//         }
//     }

//     // New method to get courses by semester
//     public List<Course> getCoursesBySemester(Semester semester) {
//         return courses.stream()
//                       .filter(course -> course.getSemester().equals(semester))
//                       .collect(Collectors.toList());
//     }

//     // New method to get students by semester
//     public List<Student> getStudentsBySemester(Semester semester) {
//         List<Student> studentsForSemester = new ArrayList<>();
//         for (Course course : getCoursesBySemester(semester)) {
//             studentsForSemester.addAll(course.getEnrolledStudents());
//         }
//         return studentsForSemester.stream().distinct().collect(Collectors.toList()); // Remove duplicates
//     }

//     @Override
//     public String toString() {
//         StringBuilder registryInfo = new StringBuilder("LOYOLA COMPUTER SCIENCE DEPARTMENT: \n\tRegistry\n");
//         for (Student student : students) {
//             registryInfo.append("\nStudent: ").append(student.getFullName())
//                         .append("\tStudent ID: ").append(student.getStudentId())
//                         .append("\tCourses: ");
//             for (Course course : student.getRegisteredCourses()) {
//                 registryInfo.append(course.getCourseTitle()).append(" (")
//                             .append(course.getSemester()).append("), ");
//             }
//             registryInfo.append("\nWaitlisted: ");
//             for (Course course : student.getWaitListedCourses()) {
//                 registryInfo.append(course.getCourseTitle()).append(" (")
//                             .append(course.getSemester()).append("), ");
//             }
//             registryInfo.append("\n");
//         }
//         registryInfo.append("\tCourses:\n");
//         for (Course course : courses) {
//             registryInfo.append("\t").append(course.getCourseTitle()).append(" - ")
//                         .append(course.getSemester()).append("\n");
//         }
//         return registryInfo.toString();
//     }

//     @Override
//     public Iterator<Student> iterator() {
//         return this.students.iterator();
//     }
// }




// // imporved Registry
package Working.Decompiled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Registry implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>(); // List to keep track of professors

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

    public boolean enrollStudent(Student student, Course course, Semester semester) {
        if (students.contains(student) && courses.contains(course) && course.getSemester().equals(semester)) {
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

    public Professor findProfessorById(int professorId) {
        return professors.stream()
                        //  .filter(professor -> professor.getId() == professorId)
                         .findFirst()
                         .orElse(null);
    }

    public Student findStudentById(int studentId) {
        return students.stream()
                    //    .filter(student -> student.getStudentId() == studentId)
                       .findFirst()
                       .orElse(null);
    }

    public List<Course> getCoursesByLevelAndSemester(String level, Semester semester) {
        return courses.stream()
                      .filter(course -> course.getLevel().equalsIgnoreCase(level) && course.getSemester().equals(semester))
                      .collect(Collectors.toList());
    }

    public List<Course> getCoursesByProfessor(Professor professor) {
        return courses.stream()
                      .filter(course -> course.getProfessor().equals(professor))
                      .collect(Collectors.toList());
    }

    public void dropStudent(Student student, Course course) {
        if (students.contains(student) && courses.contains(course)) {
            course.removeStudent(student);
            student.removeCourse(course);
            student.removeFromWaitList(course);
            course.checkWaitList();
        }
    }

    public List<Course> getCoursesBySemester(Semester semester) {
        return courses.stream()
                      .filter(course -> course.getSemester().equals(semester))
                      .collect(Collectors.toList());
    }

    public List<Student> getStudentsBySemester(Semester semester) {
        List<Student> studentsForSemester = new ArrayList<>();
        for (Course course : getCoursesBySemester(semester)) {
            studentsForSemester.addAll(course.getEnrolledStudents());
        }
        return studentsForSemester.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder registryInfo = new StringBuilder("LOYOLA COMPUTER SCIENCE DEPARTMENT: \n\tRegistry\n");
        for (Student student : students) {
            registryInfo.append("\nStudent: ").append(student.getFullName())
                        // .append("\tStudent ID: ").append(student.getStudentId())
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
        return students.iterator();
    }
}

