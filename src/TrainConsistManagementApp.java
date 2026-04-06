import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {


        System.out.println("=== Train Consist Management App ===");
        List<String> train = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + train.size());



        // Add passenger bogies
        train.add("Sleeper");
        train.add("Sleeper");
        train.add("AC Chair");
        train.add("First Class");

        System.out.println("\nAfter adding bogies:");
        System.out.println(train);


        train.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(train);


        if (train.contains("Sleeper")) {
            System.out.println("\nSleeper bogie exists in the train.");
        } else {
            System.out.println("\nSleeper bogie not found.");
        }

        // Final state
        System.out.println("\nFinal Train Consist:");
        System.out.println(train);


    }
}