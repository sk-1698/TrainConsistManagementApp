import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Create LinkedList for ordered bogies
        LinkedList<String> consist = new LinkedList<>();

// Add bogies
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

// Insert Pantry Car at position 2
        consist.add(2, "Pantry");

// Remove first and last bogie
        consist.removeFirst();
        consist.removeLast();

// Display final consist
        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(consist);


    }
}