import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLogin {

    // Store registered users: username -> password
    private static Map<String, String> userDB = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Online Shopping - User Login System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerUser(sc);
                    break;
                case 2:
                    loginUser(sc);
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    // Register a new user
    private static void registerUser(Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter new username: ");
        String username = sc.nextLine();

        if (userDB.containsKey(username)) {
            System.out.println("Username already exists! Try a different one.");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        userDB.put(username, password);
        System.out.println("Registration successful! You can now login.");
    }

    // Login existing user
    private static void loginUser(Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (userDB.containsKey(username) && userDB.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username + ".");
        } else {
            System.out.println("Invalid username or password. Try again.");
        }
    }
}