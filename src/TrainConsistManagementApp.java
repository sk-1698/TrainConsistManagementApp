import java.util.ArrayList;
import java.util.Arrays;


public class TrainConsistManagementApp {

    public static void main(String[] args)  {
        // ================= UC17 START =================

// Array of bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "Cargo", "Guard"};

// Sort using Arrays.sort()
        Arrays.sort(bogieNames);

// Display sorted names
        System.out.println("\nSorted Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

// ================= UC17 END =================
    }
}