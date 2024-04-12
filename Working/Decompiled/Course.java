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

   public Course(int creditHours, String courseNumber, String courseTitle, int maxEnrollment, Semester semester) {
      this.creditHours = creditHours;
      this.courseNumber = courseNumber;
      this.courseTitle = courseTitle;
      this.maxEnrollment = maxEnrollment;
      this.semester = semester; // Initialize the semester
      this.enrolledStudents = new TreeSet<>(Comparator.comparing(Student::getStudentId));
      this.waitList = new LinkedList();
   }

   // getter method for Semester
   public Semester getSemester() {
      return semester;
   }

   // setter method for Semester
   public void setSemester(Semester semester) {
      this.semester = semester;
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
         Student student = (Student)iterator.next();
         this.enrolledStudents.add(student);
         student.addRegisteredCourse(this);
         iterator.remove();
      }

   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj != null && this.getClass() == obj.getClass()) {
         Course course = (Course)obj;
         return Objects.equals(this.courseNumber, course.courseNumber) && Objects.equals(this.courseTitle, course.courseTitle);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.courseNumber, this.courseTitle});
   }

   public int compareTo(Course o) {
      int courseNumberComparison = this.courseNumber.compareTo(o.courseNumber);
      return courseNumberComparison != 0 ? courseNumberComparison : this.courseTitle.compareTo(o.courseTitle);
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

   public List<Student> getWaitList() {
      return this.waitList;
   }
}

