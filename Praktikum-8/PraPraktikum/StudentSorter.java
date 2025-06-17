import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class StudentSorter {
    public static class Student {
        String name;
        Map<String, Integer> courseGrades;

        public Student(String name) {
            this.name = name;
            this.courseGrades = new HashMap<>();
        }

        public void addCourseGrade(String course, int grade) {
            courseGrades.put(course, grade);
        }

        public double getGPA() {
            if (courseGrades.isEmpty()) {
                return 0.0;
            }
            double total = 0.0;
            for (int grade : courseGrades.values()) {
                total += grade;
            }
            return total / courseGrades.size();
        }

        public String getName() {
            return name;
        }
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s1.getGPA(), s2.getGPA());
        }
    }

    public static List<Student> sortStudentsByGPA(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return new ArrayList<>();
        }
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents, new StudentComparator());
        return sortedStudents;
    }
}