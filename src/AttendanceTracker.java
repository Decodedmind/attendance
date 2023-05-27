

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private boolean present;

    public Student(String name) {
        this.name = name;
        this.present = false;
    }

    public String getName() {
        return name;
    }

    public boolean isPresent() {
        return present;
    }

    public void markPresent() {
        this.present = true;
    }

    public void markAbsent() {
        this.present = false;
    }
}

public class AttendanceTracker {
    private Map<String, Student> students;

    public AttendanceTracker() {
        students = new HashMap<>();
    }

    public void addStudent(String name) {
        students.put(name, new Student(name));
    }

    public void markAttendance() {
        Scanner scanner = new Scanner(System.in);

        for (Student student : students.values()) {
            System.out.print("Is " + student.getName() + " present? (y/n): ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("y")) {
                student.markPresent();
            } else {
                student.markAbsent();
            }
        }
    }

    public void displayAttendance() {
        System.out.println("Attendance:");

        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String name = entry.getKey();
            Student student = entry.getValue();
            String status = student.isPresent() ? "Present" : "Absent";
            System.out.println(name + " - " + status);
        }
    }

    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter the name of student " + i + ": ");
            String name = scanner.nextLine();
            tracker.addStudent(name);
        }

        tracker.markAttendance();
        tracker.displayAttendance();
    }
}