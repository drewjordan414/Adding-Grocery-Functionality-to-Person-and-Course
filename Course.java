import java.util.*;

public class Course implements Comparable<Course> {
    private int creditHours;
    private String courseNumber;
    private String courseTitle;
    private int maxEnrollment;
    private Set<Student> enrolledStudents;
    private List<Student> waitList;

    //*Constructors_________________________________________________________________________________________________________
       /*PseudoCode(Course):
       (1) passed creditHours initializes this course instance credit hours
       (2) passed courseNumber initializes this course instance courseNumber
       (3) passed creditTitle initializes this course instance courseTitle
       (4) passed maxEnrollment initializes this course instance maxEnrollment
       (5) Initialize enrolledStudents as a new TreeSet.
       (6) Initialize waitList as a new LinkedList.
       (7) Register this course with the Admin class by calling Admin's getInstance method
   */
    public Course(int creditHours, String courseNumber, String courseTitle, int maxEnrollment) {
        this.creditHours = creditHours;//(1)
        this.courseNumber = courseNumber;//(2)
        this.courseTitle = courseTitle;//(3)
        this.maxEnrollment = maxEnrollment;//(4)
        this.enrolledStudents = new TreeSet<>();//(5)
        this.waitList = new LinkedList<>();//(6)
        Admin.getInstance().addCourse(this);//(7)
    }
    //_______________________________________________________________________________________________________________________

    //*Instance methods______________________________________________________________________________________________________
    /*PseudoCode(registerStudent):
       (1) registerStudent is passed instance of Student
       (2) Check if there is space in the available seats offered: if there is available seats; add the Instance of Student to this instance
           of course enrolledStudents.
       (3) Add this instance of Course to the instance Student registeredCourse List; return true, so user is notified of completion.
       (4) if there was not seats available: add instance of Student to Course instance waitList; do the same for instance Student
            waitList; return false so user is notified that enrollment did not succeed.
   */
    public boolean registerStudent(Student student){//(1)

        if(enrolledStudents.size() < maxEnrollment){
            this.enrolledStudents.add(student);//(2)
            student.addRegisteredCourse(this);//(3)
            return true;
        } else {
            waitList.add(student);
            student.addWaitListedCourse(this);
            return false;//(4)
        }
    }


    /*PseudoCode(removeStudent):
      (1) attempt to remove instance of Student from enrolledStudents
            -if student was removed; student was enrolled in Course; boolean flag set to true.
            -process this Courses waitList; filling in available enrollment seat.
      (2) if student was not found in the enrolledStudents; attempt to remove the student from the course waitList, if student
         is on the waitList remove them.
  */
    public void removeStudent(Student student){
        boolean enrolled = this.enrolledStudents.remove(student);//(1)
        if(!enrolled){
            this.waitList.remove(student);
        } else {
            processWaitList(this);//(2)
        }
    }


    /*PseudoCode(processWaitList):
          (1) Create iterator for the waitList of Course
          (2) iterate through the waitList while there is another element(Student) in the waitList and there are available seats
           for the Course
          (3) Store Student instance in firstStudentOnWaitList; add that student to enrolledStudents and put this Course instance in
            Student instance registeredCourse List
          (4) remove that student from the waitList.
      */
    public void processWaitList(Course course){
        Iterator<Student> iterator = course.getWaitList().iterator();//(1)
        while(iterator.hasNext() && enrolledStudents.size() < maxEnrollment){//(2)
            Student firstStudentOnWaitList = iterator.next();//(3)
            enrolledStudents.add(firstStudentOnWaitList);
            firstStudentOnWaitList.addRegisteredCourse(this);
            iterator.remove();//(4)
        }
    }

    /*PseudoCode(equals):
          (1) Check if the current instance this is the same as the that instance; return true (the two instances are identical).
          (2) Check if that is null or if that is not an instance of the Course class; If either condition is true, return false (the instances are not equal).
          (3) Cast the passed object to the Course class
          (4) Compare courseNumber and courseTitle using Objects.equals to handle nulls safely
      */
    public boolean equals(Object that) {
        if (this == that) { // (1)
            return true;
        }

        // (2)
        if (that == null || this.getClass() != that.getClass()) {
            return false;
        }

        // (3) Cast the passed object to the Course class
        Course thatCourse = (Course) that;

        //(4) Compare courseNumber and courseTitle using Objects.equals to handle nulls safely
        return Objects.equals(this.courseNumber, thatCourse.courseNumber) &&
                Objects.equals(this.courseTitle, thatCourse.courseTitle);
    }

    /*PseudoCode(compareTo):
          (1) Compare the courseNumber of the current instance with that.
                - If courseNumber of the current instance comes after that; return a negative value.
                - If the courseNumber of the current instance comes before that; return a positive value.
                - If the courseNumbers are equal; compare courseTitles.

      */
    public int compareTo(Course that){
        int result = this.courseNumber.compareTo(that.courseNumber);//(1)
        if(result == 0){
            return this.courseTitle.compareTo(that.courseTitle);
        }

        return result;
    }
    //_______________________________________________________________________________________________________________________

    //*Accessors_________________________________________________________________________________________________________
    public int getCreditHours(){
        return this.creditHours;
    }

    public String getCourseNumber(){
        return this.courseNumber;
    }

    public String getCourseTitle(){
        return this.courseTitle;
    }

    public int getMaxEnrollment(){
        return this.maxEnrollment;
    }

    public Set<Student> getEnrolledStudents(){
        return this.enrolledStudents;
    }

    public List<Student> getWaitList(){
        return this.waitList;
    }
}
