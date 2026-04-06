import java.util.ArrayList;
import java.util.Arrays;


public class TrainConsistManagementApp {

    public static void main(String[] args)  {
        // ================= UC19 START =================

// Sorted array of bogie IDs
        String[] sortedIds = {"B1", "B2", "B3", "B4", "B5"};

// Search key
        String key = "B3";

        int low = 0;
        int high = sortedIds.length - 1;
        boolean foundBinary = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            int compare = key.compareTo(sortedIds[mid]);

            if (compare == 0) {
                foundBinary = true;
                break;
            } else if (compare > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

// Display result
        if (foundBinary) {
            System.out.println("\n(BINARY SEARCH) Bogie ID " + key + " found.");
        } else {
            System.out.println("\n(BINARY SEARCH) Bogie ID " + key + " not found.");
        }

// ================= UC19 END =================
    }
}

