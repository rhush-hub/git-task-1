package git.task;

public class Student {
    int id;
    String firstName;
    String lastName;
    int age;

    public Student() {
        // Required for JSON (Gson) deserialization
    }

    public Student(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s %s | Age: %d", id, firstName, lastName, age);
    }
}