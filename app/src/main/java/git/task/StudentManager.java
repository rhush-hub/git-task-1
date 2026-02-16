package git.task;

import java.io.*;
import java.util.*;

public class StudentManager {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        loadStudents(); // Load from text file

        while (true) {
            System.out.println("=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            String line = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    saveStudents();
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    // ---------------- ADD ----------------
    static void addStudent() {
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine().trim();

        int age = readInt("Enter age: ");

        int id = nextId();

        students.add(new Student(id, firstName, lastName, age));
        System.out.println("Student added successfully!");
    }

    // ---------------- VIEW ----------------
    static void viewStudents() {
        System.out.println("--- Student List ---");
        if (students.isEmpty()) {
            System.out.println("(no students yet)");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // ---------------- UPDATE ----------------
    static void updateStudent() {
        int id = readInt("Enter ID to update: ");

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new first name (leave blank to keep '" + s.firstName + "'): ");
                String fn = sc.nextLine().trim();
                if (!fn.isBlank())
                    s.firstName = fn;

                System.out.print("Enter new last name (leave blank to keep '" + s.lastName + "'): ");
                String ln = sc.nextLine().trim();
                if (!ln.isBlank())
                    s.lastName = ln;

                System.out.print("Enter new age (leave blank to keep " + s.age + "): ");
                String ageLine = sc.nextLine().trim();
                if (!ageLine.isBlank()) {
                    try {
                        s.age = Integer.parseInt(ageLine);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age. Keeping previous value.");
                    }
                }

                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // ---------------- DELETE ----------------
    static void deleteStudent() {
        int id = readInt("Enter ID to delete: ");
        boolean removed = students.removeIf(s -> s.id == id);
        if (removed) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // ---------------- SAVE (TEXT FILE) ----------------
    static void saveStudents() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                // id,firstName,lastName,age
                pw.println(s.id + "," + s.firstName + "," + s.lastName + "," + s.age);
            }
            System.out.println("Saved to " + FILE_NAME);
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // ---------------- LOAD (TEXT FILE) ----------------
    static void loadStudents() {
        File f = new File(FILE_NAME);
        if (!f.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Expecting: id,firstName,lastName,age
                String[] p = line.split(",");
                if (p.length < 4)
                    continue; // skip bad lines
                int id = Integer.parseInt(p[0].trim());
                String firstName = p[1].trim();
                String lastName = p[2].trim();
                int age = Integer.parseInt(p[3].trim());
                students.add(new Student(id, firstName, lastName, age));
            }
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // ---------------- HELPERS ----------------
    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static int nextId() {
        int max = 0;
        for (Student s : students) {
            if (s.id > max)
                max = s.id;
        }
        return max + 1;
    }
}