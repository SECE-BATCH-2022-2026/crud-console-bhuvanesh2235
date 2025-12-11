import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    // In-memory repositories
    private List<Student> students = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem sys = new StudentManagementSystem();
        sys.seedSampleData(); // optional sample data
        sys.runMenu();
    }

    private void seedSampleData() {
        departments.add(new Department("CSE", "Computer Science"));
        departments.add(new Department("ECE", "Electronics"));
        departments.add(new Department("ME", "Mechanical"));

        courses.add(new Course("CSE101", "Programming I", 4));
        courses.add(new Course("CSE102", "Data Structures", 4));
        courses.add(new Course("ECE101", "Circuit Theory", 3));

        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
    }

    private void runMenu() {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Department");
            System.out.println("2. Add Course");
            System.out.println("3. Add Student");
            System.out.println("4. Assign Department to Student");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Display All Students");
            System.out.println("7. Display Departments");
            System.out.println("8. Display Courses");
            System.out.println("9. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": addDepartment(); break;
                case "2": addCourse(); break;
                case "3": addStudent(); break;
                case "4": assignDeptToStudent(); break;
                case "5": enrollStudentInCourse(); break;
                case "6": displayAllStudents(); break;
                case "7": displayDepartments(); break;
                case "8": displayCourses(); break;
                case "9": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option");
            }
        }
    }

    private void addDepartment() {
        System.out.print("Dept code: ");
        String code = sc.nextLine().trim();
        System.out.print("Dept name: ");
        String name = sc.nextLine().trim();
        Department d = new Department(code, name);
        if (!departments.contains(d)) {
            departments.add(d);
            System.out.println("Department added.");
        } else System.out.println("Department already exists.");
    }

    private void addCourse() {
        System.out.print("Course code: ");
        String code = sc.nextLine().trim();
        System.out.print("Course title: ");
        String title = sc.nextLine().trim();
        System.out.print("Credits: ");
        int credits = Integer.parseInt(sc.nextLine().trim());
        Course c = new Course(code, title, credits);
        if (!courses.contains(c)) {
            courses.add(c);
            System.out.println("Course added.");
        } else System.out.println("Course already exists.");
    }

    private void addStudent() {
        System.out.print("Roll number (int): ");
        int roll = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Student name: ");
        String name = sc.nextLine().trim();
        Student s = new Student(roll, name);
        if (!students.contains(s)) {
            students.add(s);
            System.out.println("Student added.");
        } else System.out.println("Student with this roll already exists.");
    }

    private void assignDeptToStudent() {
        Student s = findStudentByRoll();
        if (s == null) return;
        Department d = chooseDepartment();
        if (d == null) return;
        s.setDepartment(d);
        System.out.println("Department assigned.");
    }

    private void enrollStudentInCourse() {
        Student s = findStudentByRoll();
        if (s == null) return;
        Course c = chooseCourse();
        if (c == null) return;
        s.enrollCourse(c);
        System.out.println("Enrolled in course.");
    }

    private Student findStudentByRoll() {
        System.out.print("Enter roll number: ");
        int roll = Integer.parseInt(sc.nextLine().trim());
        for (Student s : students) {
            if (s.getRollNumber() == roll) return s;
        }
        System.out.println("Student not found.");
        return null;
    }

    private Department chooseDepartment() {
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
            return null;
        }
        System.out.println("Departments:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i));
        }
        System.out.print("Choose number: ");
        int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
        if (idx < 0 || idx >= departments.size()) {
            System.out.println("Invalid choice.");
            return null;
        }
        return departments.get(idx);
    }

    private Course chooseCourse() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return null;
        }
        System.out.println("Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
        System.out.print("Choose number: ");
        int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
        if (idx < 0 || idx >= courses.size()) {
            System.out.println("Invalid choice.");
            return null;
        }
        return courses.get(idx);
    }

    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void displayDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No departments.");
            return;
        }
        for (Department d : departments) {
            System.out.println(d);
        }
    }

    private void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses.");
            return;
        }
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}
