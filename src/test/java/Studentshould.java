import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Studentshould {

    private Student jane;
    private Student galina;
    private Student anton;
    private Student jack;
    private Student mike;

    @BeforeEach
    void setUp() {
        jane = new Student("Jane", 65, "CS", "Female");
        galina = new Student("Galina", 95, "Philology", "Female");
        anton = new Student("Anton", 90, "CS", "Male");
        jack = new Student("Jack", 82, "Philology", "Male");
        mike = new Student("Mike", 60, "Philology", "Male");
    }

    @Test
    public void basicTestGetAverageGradeByDepartment() {

        Student[] students = new Student[]{galina, anton, jack, mike, jane};

        Map<String, Double> expectedGrade = Student.getAverageGradeByDepartment(Arrays.stream(students));
        Map<String, Double> actualGrade = new HashMap<>();
        actualGrade.put("CS", 77.5);
        actualGrade.put("Philology", 79.0);
        assertEquals(expectedGrade, actualGrade);
    }

    @Test
    public void basicTestGetNumberOfStudentsByDepartment() {
        Student[] students = new Student[]{galina, anton, jack, mike, jane};
        Map<String, Long> actual = Student.getNumberOfStudentsByDepartment(Arrays.stream(students));
        Map<String, Long> expected = new HashMap<>();
        expected.put("CS", 2l);
        expected.put("Philology", 3l);

        assertEquals(expected, actual);
    }
}
