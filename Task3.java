import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    private String name;
    private String date;
    private double estimatedCost;

    public Destination(String name, String date, double estimatedCost) {
        this.name = name;
        this.date = date;
        this.estimatedCost = estimatedCost;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Estimated Cost: $" + estimatedCost;
    }
}

class Itinerary {
    private ArrayList<Destination> destinations = new ArrayList<>();

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void displayItinerary() {
        System.out.println("\nYour Travel Itinerary:");
        for (Destination destination : destinations) {
            System.out.println(destination);
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Destination destination : destinations) {
            totalCost += destination.getEstimatedCost();
        }
        return totalCost;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Itinerary itinerary = new Itinerary();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nTravel Itinerary Planner");
            System.out.println("1. Add Destination");
            System.out.println("2. Display Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter travel date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter estimated cost: ");
                    double cost = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    Destination destination = new Destination(name, date, cost);
                    itinerary.addDestination(destination);
                    System.out.println("Destination added!");
                    break;
                case 2:
                    itinerary.displayItinerary();
                    break;
                case 3:
                    double totalCost = itinerary.calculateTotalCost();
                    System.out.printf("Total estimated cost: $%.2f\n", totalCost);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Travel Itinerary Planner.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
