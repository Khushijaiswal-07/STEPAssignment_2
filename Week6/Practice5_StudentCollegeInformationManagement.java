class Student {
    String name;
    double attendance;

    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class Practice5_StudentCollegeInformationManagement {
    public static void main(String[] args) {

        Student student1 = new Student("Khushi", 90);
        Student student2 = new Student("Rahul", 85);

        Student.printCollegeInfo();
    }
}