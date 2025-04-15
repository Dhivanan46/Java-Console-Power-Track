import controller.AuthController;
import controller.ApplianceController;
import model.HomeEnergyTracker;
import views.MenuView;
import java.util.Scanner;

public class Power_Track {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HomeEnergyTracker energyTracker = new HomeEnergyTracker();
        AuthController authController = new AuthController(scanner);
        ApplianceController applianceController = new ApplianceController(scanner, energyTracker);
        MenuView menuView = new MenuView(scanner);

        String currentUser = authController.authenticate();
        if (currentUser == null) {
            System.out.println("Exiting the application.");
            return;
        }

        while (true) {
            menuView.displayMainMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    authController.displayUserDetails(currentUser);
                    break;
                case 2:
                    applianceController.manageAppliances(currentUser);
                    break;
                case 3:
                    applianceController.trackUsage();
                    break;
                case 4:
                    applianceController.displaySummary();
                    break;
                case 5:
                    System.out.println("Enter your budget (in dollars): ");
                    double budget = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    energyTracker.setBudget(budget);
                    System.out.println("Budget set successfully.");
                    break;
                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
