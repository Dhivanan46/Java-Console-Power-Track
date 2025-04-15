package views;

import java.util.Map;

public class SummaryView {
    public void displaySummary(Map<String, Double> appliances) {
        System.out.println("Energy Consumption Summary:");
        for (Map.Entry<String, Double> entry : appliances.entrySet()) {
            System.out.println("Appliance: " + entry.getKey() + ", Power Usage: " + entry.getValue() + " watts");
        }
    }
}
