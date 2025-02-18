import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private int maxEnrollment;
    private Set<String> prerequisites;
    private Set<String> enrolledStudents;
    
    public Course(String name, int maxEnrollment, Set<String> prerequisites) {
        this.name = name;
        this.maxEnrollment = maxEnrollment;
        this.prerequisites = prerequisites;
        this.enrolledStudents = new HashSet<>();
    }
    
    public void enrollStudent(String student, Set<String> completedCourses) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents.size() >= maxEnrollment) {
            throw new CourseFullException("Course is full: " + name);
        }
        if (!completedCourses.containsAll(prerequisites)) {
            throw new PrerequisiteNotMetException("Prerequisites not met for: " + name);
        }
        enrolledStudents.add(student);
        System.out.println("Student " + student + " enrolled in " + name);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Set<String> prerequisites = new HashSet<>();
        prerequisites.add("Math 101");
        
        Course course = new Course("Computer Science 101", 2, prerequisites);
        
        Set<String> student1Courses = new HashSet<>();
        student1Courses.add("Math 101");
        
        Set<String> student2Courses = new HashSet<>();
        
        try {
            course.enrollStudent("Alice", student1Courses);
            course.enrollStudent("Bob", student2Courses);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}