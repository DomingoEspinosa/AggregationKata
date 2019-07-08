import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Studentshould {
    @Test
    public void basicTestGetAverageGradeByDepartment() {

        Student galina = new Student("Galina", 95, "Philology", "Female");
        Student anton = new Student("Anton", 90, "CS", "Male");
        Student jack = new Student("Jack", 82, "Philology", "Male");
        Student mike = new Student("Mike", 60, "Philology", "Male");
        Student jane = new Student("Jane", 65, "CS", "Female");
        Student[] students = new Student[]{galina, anton, jack, mike, jane};
        
        Map<String, Double> expectedGrade = Student.getAverageGradeByDepartment(Arrays.stream(students));
        Map<String, Double> actualGrade = new HashMap<>();
        actualGrade.put("CS", 77.5);
        actualGrade.put("Philology", 79.0);
        assertEquals(expectedGrade, actualGrade);
    }
}
