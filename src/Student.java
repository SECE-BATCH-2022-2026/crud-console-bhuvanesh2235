import java.util.ArrayList;
import java.util.List;

public class Student {
    private int rollNumber;
    private String name;
    private Department department;          // StudentDepartment
    private List<Course> courses;           // StudentCourse

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Getters / Setters
    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public List<Course> getCourses() { return courses; }

    // Business methods
    public void enrollCourse(Course c) {
        if (c != null && !courses.contains(c)) courses.add(c);
    }

    public void dropCourse(Course c) {
        courses.remove(c);
    }

    @Override
    public String toString() {
        String dept = (department == null) ? "None" : department.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("Roll: ").append(rollNumber)
          .append(", Name: ").append(name)
          .append(", Dept: ").append(dept)
          .append(", Courses: ");
        if (courses.isEmpty()) sb.append("None");
        else {
            for (int i = 0; i < courses.size(); i++) {
                sb.append(courses.get(i).getCode());
                if (i < courses.size() - 1) sb.append("; ");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return this.rollNumber == s.rollNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(rollNumber);
    }
}
