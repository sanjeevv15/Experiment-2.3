import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 85),
            new Student("Alice", 70),
            new Student("Bob", 90),
            new Student("Diana", 60),
            new Student("Eve", 95)
        );

        System.out.println("Students with marks > 75 sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}
