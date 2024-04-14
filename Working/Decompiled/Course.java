// package Working.Decompiled;

// import java.util.Comparator;
// import java.util.Iterator;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Objects;
// import java.util.Set;
// import java.util.TreeSet;

// public class Course implements Comparable<Course> {
//     private int creditHours;
//     private String courseNumber;
//     private String courseTitle;
//     private int maxEnrollment;
//     private Set<Student> enrolledStudents;
//     private List<Student> waitList;
//     private Semester semester;

//     public Course(int creditHours, String courseNumber, String courseTitle, int maxEnrollment, Semester semester) {
//         this.creditHours = creditHours;
//         this.courseNumber = courseNumber;
//         this.courseTitle = courseTitle;
//         this.maxEnrollment = maxEnrollment;
//         this.semester = semester;
//         this.enrolledStudents = new TreeSet<>(Comparator.comparing(Student::getStudentId));
//         this.waitList = new LinkedList<>();
//     }

//     public Semester getSemester() {
//         return this.semester;
//     }

//     public void setSemester(Semester semester) {
//         this.semester = semester;
//     }

//     public boolean enrollStudent(Student student) {
//         if (this.enrolledStudents.size() < this.maxEnrollment) {
//             this.enrolledStudents.add(student);
//             student.addRegisteredCourse(this);
//             return true;
//         } else {
//             this.waitList.add(student);
//             student.addWaitListedCourse(this);
//             return false;
//         }
//     }

//     public void removeStudent(Student student) {
//         if (this.enrolledStudents.remove(student)) {
//             student.removeCourse(this);
//             this.checkWaitList();
//         } else {
//             this.waitList.remove(student);
//             student.removeFromWaitList(this);
//         }
//     }

//     public void checkWaitList() {
//         Iterator<Student> iterator = this.waitList.iterator();
//         while(iterator.hasNext() && this.enrolledStudents.size() < this.maxEnrollment) {
//             Student student = iterator.next();
//             this.enrolledStudents.add(student);
//             student.addRegisteredCourse(this);
//             iterator.remove();
//         }
//     }

//     public List<Student> getWaitList() {
//         return this.waitList;
//     }

//     public int getCreditHours() {
//         return this.creditHours;
//     }

//     public String getCourseNumber() {
//         return this.courseNumber;
//     }

//     public String getCourseTitle() {
//         return this.courseTitle;
//     }

//     public int getMaxEnrollment() {
//         return this.maxEnrollment;
//     }

//     public Set<Student> getEnrolledStudents() {
//         return this.enrolledStudents;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj) return true;
//         if (obj == null || getClass() != obj.getClass()) return false;
//         Course course = (Course) obj;
//         return Objects.equals(courseNumber, course.courseNumber) &&
//                Objects.equals(courseTitle, course.courseTitle) &&
//                Objects.equals(semester, course.semester);
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(courseNumber, courseTitle, semester);
//     }

//     @Override
//     public int compareTo(Course o) {
//         int courseNumberComparison = courseNumber.compareTo(o.courseNumber);
//         if (courseNumberComparison != 0) return courseNumberComparison;
//         return courseTitle.compareTo(o.courseTitle);
//     }
// }

// package Working.Decompiled;

// import java.util.Comparator;
// import java.util.Iterator;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Objects;
// import java.util.Set;
// import java.util.TreeSet;

// public class Course implements Comparable<Course> {
//     private int creditHours;
//     private String courseNumber;
//     private String courseTitle;
//     private int maxEnrollment;
//     private Set<Student> enrolledStudents;
//     private List<Student> waitList;
//     private Semester semester;
//     private Professor professor; // New reference to Professor

//     public Course(int creditHours, String courseNumber, String courseTitle, 
//                   int maxEnrollment, Semester semester, Professor professor) {
//         this.creditHours = creditHours;
//         this.courseNumber = courseNumber;
//         this.courseTitle = courseTitle;
//         this.maxEnrollment = maxEnrollment;
//         this.semester = semester;
//         this.professor = professor; // Initialize the professor
//         this.enrolledStudents = new TreeSet<>(Comparator.comparing(Student::getStudentId));
//         this.waitList = new LinkedList<>();
//     }

//     public Semester getSemester() {
//         return this.semester;
//     }

//     public void setSemester(Semester semester) {
//         this.semester = semester;
//     }

//     public Professor getProfessor() {
//         return this.professor;
//     }

//     public void setProfessor(Professor professor) {
//         this.professor = professor;
//     }

//     public boolean enrollStudent(Student student) {
//         if (this.enrolledStudents.size() < this.maxEnrollment) {
//             this.enrolledStudents.add(student);
//             student.addRegisteredCourse(this);
//             return true;
//         } else {
//             this.waitList.add(student);
//             student.addWaitListedCourse(this);
//             return false;
//         }
//     }

//     public void removeStudent(Student student) {
//         if (this.enrolledStudents.remove(student)) {
//             student.removeCourse(this);
//             this.checkWaitList();
//         } else {
//             this.waitList.remove(student);
//             student.removeFromWaitList(this);
//         }
//     }

//     public void checkWaitList() {
//         Iterator<Student> iterator = this.waitList.iterator();
//         while(iterator.hasNext() && this.enrolledStudents.size() < this.maxEnrollment) {
//             Student student = iterator.next();
//             this.enrolledStudents.add(student);
//             student.addRegisteredCourse(this);
//             iterator.remove();
//         }
//     }

//     public List<Student> getWaitList() {
//         return this.waitList;
//     }

//     public int getCreditHours() {
//         return this.creditHours;
//     }

//     public String getCourseNumber() {
//         return this.courseNumber;
//     }

//     public String getCourseTitle() {
//         return this.courseTitle;
//     }

//     public int getMaxEnrollment() {
//         return this.maxEnrollment;
//     }

//     public Set<Student> getEnrolledStudents() {
//         return this.enrolledStudents;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj) return true;
//         if (obj == null || getClass() != obj.getClass()) return false;
//         Course course = (Course) obj;
//         return creditHours == course.creditHours &&
//                maxEnrollment == course.maxEnrollment &&
//                Objects.equals(courseNumber, course.courseNumber) &&
//                Objects.equals(courseTitle, course.courseTitle) &&
//                Objects.equals(semester, course.semester) &&
//                Objects.equals(professor, course.professor);
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(courseNumber, courseTitle, creditHours, maxEnrollment, semester, professor);
//     }

//     @Override
//     public int compareTo(Course o) {
//         int courseNumberComparison = courseNumber.compareTo(o.courseNumber);
//         if (courseNumberComparison != 0) return courseNumberComparison;
//         return courseTitle.compareTo(o.courseTitle);
//     }
// }



package Working.Decompiled;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Course implements Comparable<Course> {
    private int creditHours;
    private String courseNumber;
    private String courseTitle;
    private int maxEnrollment;
    private Set<Student> enrolledStudents;
    private List<Student> waitList;
    private Semester semester;
    private Professor professor; // Reference to Professor who teaches the course
    private String level; // Level of the course, e.g., "Undergrad" or "Graduate"

    public Course(int creditHours, String courseNumber, String courseTitle, 
                  int maxEnrollment, Semester semester, Professor professor, String level) {
        this.creditHours = creditHours;
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.maxEnrollment = maxEnrollment;
        this.semester = semester;
        this.professor = professor;
        this.level = level;
        this.enrolledStudents = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        this.waitList = new LinkedList<>();
    }

    public Semester getSemester() {
        return this.semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean enrollStudent(Student student) {
        if (this.enrolledStudents.size() < this.maxEnrollment) {
            this.enrolledStudents.add(student);
            student.addRegisteredCourse(this);
            return true;
        } else {
            this.waitList.add(student);
            student.addWaitListedCourse(this);
            return false;
        }
    }

    public void removeStudent(Student student) {
        if (this.enrolledStudents.remove(student)) {
            student.removeCourse(this);
            this.checkWaitList();
        } else {
            this.waitList.remove(student);
            student.removeFromWaitList(this);
        }
    }

    public void checkWaitList() {
        Iterator<Student> iterator = this.waitList.iterator();
        while(iterator.hasNext() && this.enrolledStudents.size() < this.maxEnrollment) {
            Student student = iterator.next();
            this.enrolledStudents.add(student);
            student.addRegisteredCourse(this);
            iterator.remove();
        }
    }

    public List<Student> getWaitList() {
        return this.waitList;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public String getCourseNumber() {
        return this.courseNumber;
    }

    public String getCourseTitle() {
        return this.courseTitle;
    }

    public int getMaxEnrollment() {
        return this.maxEnrollment;
    }

    public Set<Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return creditHours == course.creditHours &&
               maxEnrollment == course.maxEnrollment &&
               Objects.equals(courseNumber, course.courseNumber) &&
               Objects.equals(courseTitle, course.courseTitle) &&
               Objects.equals(semester, course.semester) &&
               Objects.equals(professor, course.professor) &&
               Objects.equals(level, course.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseNumber, courseTitle, creditHours, maxEnrollment, semester, professor, level);
    }

    @Override
    public int compareTo(Course o) {
        int courseNumberComparison = courseNumber.compareTo(o.courseNumber);
        if (courseNumberComparison != 0) return courseNumberComparison;
        return courseTitle.compareTo(o.courseTitle);
    }
}



