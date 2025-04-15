package controller;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class AuthController {
    private Scanner scanner;
    private Map<String, String> userDatabase = new HashMap<>();
    private Map<String, String> userDetails = new HashMap<>();

    public AuthController(Scanner scanner) {
        this.scanner = scanner;
    }

    public String authenticate() {
        boolean authenticated = false;
        String currentUser = "";

        while (!authenticated) {
            System.out.println("Welcome to the Home Energy Consumption Tracker!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int authOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (authOption) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    currentUser = loginUser();
                    authenticated = currentUser != null;
                    break;
                case 3:
                    return null;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        return currentUser;
    }

    private void registerUser() {
        System.out.println("Enter username to register: ");
        String registerUsername = scanner.nextLine();
        if (userDatabase.containsKey(registerUsername)) {
            System.out.println("Username already exists. Please try again.");
            return;
        }
        System.out.println("Enter password: ");
        String registerPassword = scanner.nextLine();
        String email;
        while (true) {
            System.out.println("Enter email: ");
            email = scanner.nextLine();
            if (Pattern.matches("^[a-z0-9]+@(gmail.com)$", email)) {
                break;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }
        String phoneNumber;
        while (true) {
            System.out.println("Enter phone number (10 digits): ");
            phoneNumber = scanner.nextLine();
            if (Pattern.matches("^\\d{10}$", phoneNumber)) {
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a 10-digit phone number.");
            }
        }
        userDatabase.put(registerUsername, registerPassword);
        userDetails.put(registerUsername, "Email: " + email + "\nPhone: " + phoneNumber);
        System.out.println("Registration successful. Please login.");
    }

    private String loginUser() {
        System.out.println("Enter username to login: ");
        String loginUsername = scanner.nextLine();
        System.out.println("Enter password: ");
        String loginPassword = scanner.nextLine();
        if (userDatabase.containsKey(loginUsername)) {
            if (userDatabase.get(loginUsername).equals(loginPassword)) {
                System.out.println("Login successful.");
                return loginUsername;
            } else {
                System.out.println("Invalid password. Would you like to change your password? (yes/no)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    System.out.println("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    userDatabase.put(loginUsername, newPassword);
                    System.out.println("Password updated successfully. Please login again.");
                } else {
                    System.out.println("Please try again.");
                }
            }
        } else {
            System.out.println("Invalid username. Please try again.");
        }
        return null;
    }

    public void displayUserDetails(String username) {
        System.out.println("User Details:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + userDatabase.get(username));
        System.out.println(userDetails.get(username));
    }
}
