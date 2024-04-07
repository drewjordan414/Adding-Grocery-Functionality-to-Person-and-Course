import java.util.*;

public class Course implements Comparable<Course>, Iterable<Student> {
    private int creditHours;
    private String courseNumber;
    private String courseName;
    private int maxEnrollment;
    private Set<Student> enrolledStudents;
    private List<Student> waitList;

    public Course(int creditHours, String courseNumber, String courseName, int maxEnrollment) {
        this.creditHours = creditHours;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.maxEnrollment = maxEnrollment;
        this.enrolledStudents = new TreeSet<>();
        this.waitList = new LinkedList<>();
    }

    public boolean registerStudent(Student student){

        if(enrolledStudents.size() < maxEnrollment){
            this.enrolledStudents.add(student);
            student.addRegisteredCourse(this);
            return true;
        } else {
            waitList.add(student);
            return false;
        }
    }

    public void removeStudent(Student student){
        boolean enrolled = this.enrolledStudents.remove(student);//(1)
        if(!enrolled){
            this.waitList.remove(student);
        } else {
            processWaitList(this);//(2)
        }
    }

    public void processWaitList(Course course){
        Iterator<Student> iterator = course.getWaitList().iterator();//(1) Iterator created for Wait list of each Course.
        while(iterator.hasNext() && enrolledStudents.size() < maxEnrollment){//(2) if there exist Student objects in Course wait list
            Student firstStudentOnWaitList = iterator.next();//(3) grab next Student instance from wait list
            enrolledStudents.add(firstStudentOnWaitList);//(4) add that Student instance 'this' Course objects enrolled Students
            firstStudentOnWaitList.addRegisteredCourse(this);//(5) Update the Student's Registered Courses field
            iterator.remove();//(4)
        }
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }

        if (that == null || this.getClass() != that.getClass()) {
            return false;
        }

        Course thatCourse = (Course) that;

        return Objects.equals(this.courseNumber, thatCourse.courseNumber) &&
                Objects.equals(this.courseName, thatCourse.courseName);
    }

    public int compareTo(Course that){
        int result = this.courseNumber.compareTo(that.courseNumber);//(1)
        if(result == 0){
            return this.courseName.compareTo(that.courseName);
        }

        return result;
    }

    public int getCreditHours(){
        return this.creditHours;
    }

    public String getCourseNumber(){
        return this.courseNumber;
    }

    public String getCourseName(){
        return this.courseName;
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

    @Override
    public Iterator<Student> iterator() {
        return enrolledStudents.iterator();
    }

    public Iterator<Student> waitListIterator() {
        return waitList.iterator();
    }

    public void checkWaitList() {
        // Iterate through the waitList as long as there is space available in the course
        while (!waitList.isEmpty() && enrolledStudents.size() < maxEnrollment) {
            Student firstStudentOnWaitList = waitList.remove(0);

            enrolledStudents.add(firstStudentOnWaitList);

            firstStudentOnWaitList.addRegisteredCourse(this);

            firstStudentOnWaitList.removeFromWaitList(this);
        }
    }

}