import java.util.*;

public class Admin {
    /*PseudoCode(Why did I choose a Static instance for my Admin instantiation?):
        -I chose this approach as I believe limiting the instances of the Admin Class to a single instance is a good
        option for encapsulation, as it limits the clients programs usage of the Admin Class; it can be used as a central
        database to track all instances of Course and Student objects.
    */
    private static Admin instance = new Admin();
    private Set<Course> allCourses;
    private Set<Student> allStudents;

    public Admin() {
        this.allCourses = new TreeSet<>();
        this.allStudents = new TreeSet<>();
    }

    /*PseudoCode(reportRegistration):
       (1) Create a list of students from Admins TreeSet of allStudents
       (2) Input students into Collections.sort which will utilize my Student class compareTo to sort by last then first name.
       (3) Initialize an empty List for String type, so I can start building my List of Students to report to user
       (4) use a for each loop to iterate through my List<Student> students list; each student is pulled from students
           and that instances get methods are utilized to display each student's lastName, FirstName - Registered: # of classes they are registered for.
       (5) return List of Strings studentsRegistered to the user after all instances of Student iterated through.
   */
    public List<String> reportRegistration() {
        List<Student> students = new ArrayList<>(allStudents);//(1)

        Collections.sort(students);//(2)

        List<String> studentsRegistered = new ArrayList<>();//(3)

        for (Student student : students) {//(4)
            String registrationInfoBuilder = student.getLastName() + ", " + student.getFirstName() + " - Registered: " + student.getRegisteredCourses().size();
            studentsRegistered.add(registrationInfoBuilder);
        }
        return studentsRegistered;
    }

       /*PseudoCode(reportWaitListed):
       (1) Create an empty String Arraylist(waitListedStudentsInfo)
       (2) Iterate allCourses pulling each instance of Course into a for each loop
       (3) for each instance of Course; access it's waitList and iterate over it's contents; pull every Student instance in the waitList
           and access it's gettter methods for LastName, FirstName, and CourseTitle; waitList is zero based, so position is index plus 1 in waitlist
       (4) Add each String of info(contain data on each Student) into our String List waitListedStudentsInfo
       (5) Input String List waitListedStudentsInfo into Collection.sort for natural ordering; since I placed the
           lastName first in the String List waitListedStudentsInfo, it should sort by lastName then firstName.
       (6) Return waitListedStudentsInfo to user
   */
    public List<String> reportWaitListed() {
        List<String> waitListedStudentsInfo = new ArrayList<>();//(1)

        // Iterate over all courses
        for (Course course : allCourses) {//(2)
            // Iterate over the waitlist for each course
            for (int i = 0; i < course.getWaitList().size(); i++) {//(3)
                Student student = course.getWaitList().get(i);
                // (4)
                String info = student.getLastName() + ", " + student.getFirstName() + " - Waitlisted for " + course.getCourseTitle() + ", Position: " + (i + 1);
                waitListedStudentsInfo.add(info);
            }
        }

        //(5)
        Collections.sort(waitListedStudentsInfo);
        //(6)
        return waitListedStudentsInfo;
    }
    //Allow for objects of Student to be directly added into Admin field allStudents
    public void addStudent(Student student) {
        allStudents.add(student);
    }
    //Allow for objects of Course to be directly added into Admin field allCourses
    public void addCourse(Course course) {
        allCourses.add(course);
    }
    //Gives the ability to access the only instantiated Admin
    public static Admin getInstance(){
        return instance;
    }
}
