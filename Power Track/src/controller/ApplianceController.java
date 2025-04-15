package controller;

import model.HomeEnergyTracker;
import views.MenuView;
import views.SummaryView;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class ApplianceController {
    private Scanner scanner;
    private HomeEnergyTracker energyTracker;
    private Map<String, List<String>> userAppliances;
    private MenuView menuView;
    private SummaryView summaryView;

    public ApplianceController(Scanner scanner, HomeEnergyTracker energyTracker) {
        this.scanner = scanner;
        this.energyTracker = energyTracker;
        this.menuView = new MenuView(scanner);
        this.summaryView = new SummaryView();
        this.userAppliances = new HashMap<>();
    }

    private void removeAppliance(String currentUser) {
        System.out.println("Enter appliance name to remove: ");
        String applianceName = scanner.nextLine();
        if (userAppliances.getOrDefault(currentUser, new ArrayList<>()).remove(applianceName)) {
            energyTracker.removeAppliance(applianceName);
            System.out.println("Appliance removed successfully.");
        } else {
            System.out.println("Appliance not found.");
        }
    }

    private void addPowerToExistingAppliance(String currentUser) {
        System.out.println("Enter appliance name: ");
        String applianceName = scanner.nextLine();
        if (userAppliances.getOrDefault(currentUser, new ArrayList<>()).contains(applianceName)) {
            System.out.println("Enter additional power usage (in watts): ");
            double additionalPower = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            energyTracker.addAppliance(applianceName, additionalPower);
            System.out.println("Power added successfully.");
        } else {
            System.out.println("Appliance not found.");
        }
    }

    public void trackUsage() {
        System.out.println("Enter appliance name to track usage: ");
        String applianceToTrack = scanner.nextLine();
        System.out.println("Enter usage duration (in hours): ");
        double usageDuration = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        energyTracker.trackUsage(applianceToTrack, usageDuration);
        System.out.println("Usage tracked successfully.");
    }

    public void displaySummary() {
        summaryView.displaySummary(energyTracker.getAppliances());
    }
}
