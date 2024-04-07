public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Bruce", "Wayne");
        Student student1 = new Student("Tony", "Stark", 123);
        Professor prof1 = new Professor("Leo", "Irakliatos", "Computer Science");
        Undergrad under = new Undergrad("Ham", "Hame", 1234, 4);

        System.out.println(person1);
        System.out.println(student1);
        System.out.println(prof1);
        System.out.println(under);

    }
}