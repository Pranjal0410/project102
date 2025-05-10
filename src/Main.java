import datastructures.CriminalArray;
import datastructures.FIRlinkedlist;
import datastructures.Officerqueue;
import java.util.Scanner;
import models.Criminal;
import models.Fir;
import models.Officer;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Officerqueue officerQueue = new Officerqueue();
    private static CriminalArray criminalArray = new CriminalArray();
    private static FIRlinkedlist firList = new FIRlinkedlist();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice (1-8): ");
            
            switch (choice) {
                case 1:
                    addOfficer();
                    break;
                case 2:
                    addCriminal();
                    break;
                case 3:
                    addFIR();
                    break;
                case 4:
                    searchCriminal();
                    break;
                case 5:
                    searchFIR();
                    break;
                case 6:
                    displayAllOfficers();
                    break;
                case 7:
                    displayAllFIRs();
                    break;
                case 8:
                    System.out.println("Thank you for using the Crime Record Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Crime Record Management System ===");
        System.out.println("1. Add New Officer");
        System.out.println("2. Add New Criminal");
        System.out.println("3. Add New FIR");
        System.out.println("4. Search Criminal");
        System.out.println("5. Search FIR");
        System.out.println("6. Display All Officers");
        System.out.println("7. Display All FIRs");
        System.out.println("8. Exit");
    }

    private static void addOfficer() {
        System.out.println("\n=== Add New Officer ===");
        String id = getStringInput("Enter Officer ID: ");
        String name = getStringInput("Enter Officer Name: ");
        String rank = getStringInput("Enter Officer Rank: ");
        
        Officer officer = new Officer(id, name, rank);
        officerQueue.addOfficer(officer);
        System.out.println("Officer added successfully!");
    }

    private static void addCriminal() {
        System.out.println("\n=== Add New Criminal ===");
        String id = getStringInput("Enter Criminal ID: ");
        String name = getStringInput("Enter Criminal Name: ");
        int age = getIntInput("Enter Criminal Age: ");
        String crimeType = getStringInput("Enter Crime Type: ");
        
        Criminal criminal = new Criminal(id, name, age, crimeType);
        criminalArray.insert(criminal);
        System.out.println("Criminal added successfully!");
    }

    private static void addFIR() {
        System.out.println("\n=== Add New FIR ===");
        String firNumber = getStringInput("Enter FIR Number: ");
        String description = getStringInput("Enter Description: ");
        String location = getStringInput("Enter Location: ");
        String criminalId = getStringInput("Enter Criminal ID: ");
        
        Criminal criminal = criminalArray.search(criminalId);
        if (criminal == null) {
            System.out.println("Criminal not found! Please add the criminal first.");
            return;
        }
        
        Fir fir = new Fir(firNumber, description, location, criminal);
        firList.addFIR(fir);
        System.out.println("FIR added successfully!");
    }

    private static void searchCriminal() {
        System.out.println("\n=== Search Criminal ===");
        String id = getStringInput("Enter Criminal ID to search: ");
        Criminal criminal = criminalArray.search(id);
        
        if (criminal != null) {
            System.out.println("\nCriminal found:");
            System.out.println(criminal);
        } else {
            System.out.println("Criminal not found!");
        }
    }

    private static void searchFIR() {
        System.out.println("\n=== Search FIR ===");
        String firNumber = getStringInput("Enter FIR Number to search: ");
        Fir fir = firList.searchFIR(firNumber);
        
        if (fir != null) {
            System.out.println("\nFIR found:");
            System.out.println(fir);
        } else {
            System.out.println("FIR not found!");
        }
    }

    private static void displayAllOfficers() {
        System.out.println("\n=== All Officers ===");
        if (officerQueue.isEmpty()) {
            System.out.println("No officers in the system.");
            return;
        }
        
        while (!officerQueue.isEmpty()) {
            Officer officer = officerQueue.getNextOfficer();
            System.out.println(officer);
            System.out.println("------------------------");
        }
    }

    private static void displayAllFIRs() {
        System.out.println("\n=== All FIRs ===");
        if (firList.isEmpty()) {
            System.out.println("No FIRs in the system.");
            return;
        }
        firList.displayAllFIRs();
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
} 