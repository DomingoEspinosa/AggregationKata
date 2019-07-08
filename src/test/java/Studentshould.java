import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Studentshould {

    private Student jane;
    private Student galina;
    private Student anton;
    private Student jack;
    private Student mike;
    private Student[] students;

    @BeforeEach
    void setUp() {
        jane = new Student("Jane", 65, "CS", Student.Gender.FEMALE);
        galina = new Student("Galina", 95, "Philology", Student.Gender.FEMALE);
        anton = new Student("Anton", 90, "CS", Student.Gender.MALE);
        jack = new Student("Jack", 82, "Philology", Student.Gender.MALE);
        mike = new Student("Mike", 60, "Philology", Student.Gender.MALE);
        students = new Student[]{galina, anton, jack, mike, jane};

    }

    @Test
    public void obtain_average_grade_by_department() {
        Map<String, Double> expectedGrade = Student.getAverageGradeByDepartment(Arrays.stream(students));
        Map<String, Double> actualGrade = new HashMap<>();
        actualGrade.put("CS", 77.5);
        actualGrade.put("Philology", 79.0);
        assertEquals(expectedGrade, actualGrade);
    }

    @Test
    public void obtain_number_of_students_by_department() {
        Map<String, Long> actual = Student.getNumberOfStudentsByDepartment(Arrays.stream(students));
        Map<String, Long> expected = new HashMap<>();
        expected.put("CS", 2l);
        expected.put("Philology", 3l);
        assertEquals(expected, actual);
    }

    @Test
    public void obtain_student_names_by_department() throws Exception {

        Map<String, List<String>> actual = Student.getStudentNamesByDepartment(Arrays.stream(students));
        List<String> list1 = new ArrayList<>(Arrays.asList("Galina", "Jack", "Mike"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Anton", "Jane"));
        Map<String, List<String>> expected = new HashMap<>();
        expected.put("Philology", list1);
        expected.put("CS", list2);

        assertEquals(expected, actual);
    }

    @Test
    public void obtain_number_of_students_by_gender_for_each_department()  {

        Map<String, Map<Student.Gender, Long>> actual = Student.getTheNumberOfStudentsByGenderForEachDepartment(Arrays.stream(students));
        Map<String, Map<Student.Gender, Long>> expected = new HashMap<>();
        Map<Student.Gender, Long> map1 = new HashMap<>();
        Map<Student.Gender, Long> map2 = new HashMap<>();
        map1.put(Student.Gender.MALE, 1L);
        map1.put(Student.Gender.FEMALE, 1L);
        map2.put(Student.Gender.MALE, 2L);
        map2.put(Student.Gender.FEMALE, 1L);
        expected.put("CS", map1);
        expected.put("Philology", map2);

        assertEquals(expected, actual);
    }

}
