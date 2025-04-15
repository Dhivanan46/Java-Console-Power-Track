package views;

import java.util.Scanner;

public class MenuView {
     Scanner scanner;

    public MenuView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        System.out.println("Welcome to the Home Energy Consumption Tracker!");
        System.out.println("1. User Details");
        System.out.println("2. My Appliances");
        System.out.println("3. Track Usage");
        System.out.println("4. View Summary");
        System.out.println("5. Set Budget");
        System.out.println("6. Logout");
        System.out.print("Choose an option: ");
    }

    public void displayApplianceMenu() {
        System.out.println("My Appliances:");
        System.out.println("1. Add Appliance");
        System.out.println("2. Remove Appliance");
        System.out.println("3. Add Power Consumption to Existing Appliance");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose an option: ");
    }
}
