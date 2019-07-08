import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    private final String name;
    private final double grade;
    private final String department;
    private final Gender gender;

    private final double PASSING_GRADE = 70.0;

    public Student(String name, double grade, String department, Gender gender) {
        this.name = name;
        this.grade = grade;
        this.department = department;
        this.gender = gender;
    }

    public static Map<String, Double> getAverageGradeByDepartment(Stream<Student> students) {
        return students.collect(
                Collectors.groupingBy(
                        Student::getDepartment, Collectors.averagingDouble(Student::getGrade)));
    }

    public static Map<String, Long> getNumberOfStudentsByDepartment(Stream<Student> students) {
        return students.collect(
                Collectors.groupingBy(Student::getDepartment,
                        Collectors.counting()));
    }

    public static Map<String, List<String>> getStudentNamesByDepartment(Stream<Student> students) {
        return students.collect(
                Collectors.groupingBy(Student::getDepartment,
                        Collectors.mapping(Student::getName, Collectors.toList())));
    }

    public static Map<String, Map<Gender, Long>> getTheNumberOfStudentsByGenderForEachDepartment(Stream<Student> students) {
        return students.collect(
                Collectors.groupingBy(Student::getDepartment,
                        Collectors.groupingBy(Student::getGender, Collectors.counting())));

    }

    private double getGrade() {
        return grade;
    }

    private String getDepartment() {
        return department;
    }

    private String getName() {
        return name;
    }

    private Gender getGender() {
        return gender;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
