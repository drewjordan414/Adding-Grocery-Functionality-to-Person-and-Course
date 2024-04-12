package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Registry implements Iterable<Student> {
   private List<Student> students = new ArrayList();
   private List<Course> courses = new ArrayList();

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

   public String toString() {
      StringBuilder registryInfo = new StringBuilder("LOYOLA COMPUTER SCIENCE DEPARTMENT: \n\tRegistry\n");
      Iterator var2 = this.students.iterator();

      while(var2.hasNext()) {
         Student student = (Student)var2.next();
         registryInfo.append("\nStudent: ").append(student.getFullName()).append("\tStudent ID: ").append(student.getStudentId());
         registryInfo.append("\tCourses: ");
         Iterator var4 = student.getRegisteredCourses().iterator();

         Course course;
         while(var4.hasNext()) {
            course = (Course)var4.next();
            registryInfo.append(course.getCourseTitle()).append(", ");
         }

         registryInfo.append("\nWaitlisted : ");
         var4 = student.getWaitListedCourses().iterator();

         while(var4.hasNext()) {
            course = (Course)var4.next();
            registryInfo.append(course.getCourseTitle()).append(",");
         }

         registryInfo.append("\n");
      }

      registryInfo.append("\tCourses:\n");
      var2 = this.courses.iterator();

      while(var2.hasNext()) {
         Course course = (Course)var2.next();
         registryInfo.append("\t").append(course.getCourseTitle()).append("\n");
      }

      return registryInfo.toString();
   }

   public Iterator<Student> iterator() {
      return this.students.iterator();
   }
}
