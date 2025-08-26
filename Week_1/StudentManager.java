import java.util.Scanner;
public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_STUDENTS = 100;
        String[] students = new String[MAX_STUDENTS];
        int count = 0; // Number of students currently in the list
        while (true) {
            System.out.println("\n--- Student Name Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student Name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear newline
            switch (choice) {
                case 1:
                    if (count >= MAX_STUDENTS) {
                        System.out.println("Student list is full.");
                    } else {
                        System.out.print("Enter student name to add: ");
                        String name = sc.nextLine();
                        students[count++] = name;
                        System.out.println("Student added.");
                    }
                    break;
                case 2:
                    System.out.println("List of Students:");
                    if (count == 0) {
                        System.out.println("No students in the list.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + students[i]);
                        }

                    }
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].equalsIgnoreCase(searchName)) {
                            System.out.println("Student found at position: " + (i + 1));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    int deleteIndex = -1;
                    for (int i = 0; i < count; i++) {
                        if (students[i].equalsIgnoreCase(deleteName)) {
                            deleteIndex = i;
                            break;
                        }
                    }
                    if (deleteIndex != -1) {
                        for (int i = deleteIndex; i < count - 1; i++) {
                            students[i] = students[i + 1];
                        }
                        count--;
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the current name: ");
                    String currentName = sc.nextLine();

                    System.out.print("Enter the new name: ");
                    String newName = sc.nextLine();
                    boolean updated = false;
                    for (int i = 0; i < count; i++)
                    {
                        if (students[i].equalsIgnoreCase(currentName)) {
                            students[i] = newName;
                            updated = true;
                            System.out.println("Name updated.");
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}