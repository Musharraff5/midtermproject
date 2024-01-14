import java.util.ArrayList;
import java.util.Scanner;

class BloodPressureRecord {
    private final int userId;
    private String userName;
    private int systolic;
    private int diastolic;

    public BloodPressureRecord(int userId, String userName, int systolic, int diastolic) {
        this.userId = userId;
        this.userName = userName;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getSystolic() {
        return systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void display() {
        System.out.println("User ID: " + userId + ", User Name: " + userName +
                           ", Systolic: " + systolic + ", Diastolic: " + diastolic);
    }
}

public class Tester {
    private static ArrayList<BloodPressureRecord> records = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("\nBlood pressure monitor");
        System.out.println("======================");
        System.out.println("1. Create a record");
        System.out.println("2. Show blood pressure data for all users");
        System.out.println("3. Show blood pressure data for a selected user");
        System.out.println("4. Delete all");
        System.out.println("5. Exit");
        System.out.print("Please Enter Your Choice: ");
    }

    public static void index() {
        System.out.println("Showing blood pressure data for all users");
        for (BloodPressureRecord record : records) {
            record.display();
        }
    }

    public static void view(int id) {
        boolean found = false;
        for (BloodPressureRecord record : records) {
            if (record.getUserId() == id) {
                record.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Record not found for user ID: " + id);
        }
    }

    public static void create() {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter systolic pressure: ");
        int systolic = scanner.nextInt();

        System.out.print("Enter diastolic pressure: ");
        int diastolic = scanner.nextInt();

        BloodPressureRecord record = new BloodPressureRecord(userId, userName, systolic, diastolic);
        records.add(record);

        System.out.println("Record created successfully.");
    }

    public static void delete() {
        records.clear();
        System.out.println("All records deleted.");
    }

    public static void exit() {
        System.out.println("Thank you for using the Blood pressure monitor");
        System.exit(0);
    }

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    index();
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    view(userId);
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}
