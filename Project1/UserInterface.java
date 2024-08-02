package Project1;
import java.util.Scanner;

public class UserInterface {
    private UserService userService;
    private ExamService examService;

    public UserInterface() {
        userService = new UserService();
        examService = new ExamService();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.login(username, password)) {
            System.out.println("Login successful.");
            userDashboard(scanner, username);
        } else {
            System.out.println("Login failed. Try again.");
        }
    }

    private void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (userService.register(username, password, email)) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed. Try again.");
        }
    }

    private void userDashboard(Scanner scanner, String username) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("1. Update Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    updateProfile(scanner, username);
                    break;
                case 2:
                    changePassword(scanner, username);
                    break;
                case 3:
                    examService.startExam(scanner);
                    break;
                case 4:
                    loggedIn = false;
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void updateProfile(Scanner scanner, String username) {
        System.out.print("Enter new email: ");
        String newEmail = scanner.nextLine();

        if (userService.updateProfile(username, newEmail)) {
            System.out.println("Profile updated successfully.");
        } else {
            System.out.println("Profile update failed.");
        }
    }

    private void changePassword(Scanner scanner, String username) {
        System.out.print("Enter current password: ");
        String currentPassword = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        if (userService.changePassword(username, currentPassword, newPassword)) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Password change failed.");
        }
    }
}
