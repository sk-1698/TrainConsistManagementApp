import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        // ================= UC20 START =================

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

        if (bogies == null || bogies.isEmpty()) {
            throw new IllegalStateException("Cannot perform search: No bogies available in the train");
        }

        String searchId = "Sleeper";
        boolean foundUC20 = false;

        for (Bogie b : bogies) {
            if (b.name.equals(searchId)) {
                foundUC20 = true;
                break;
            }
        }

        if (foundUC20) {
            System.out.println("(UC20) Bogie found: " + searchId);
        } else {
            System.out.println("(UC20) Bogie not found: " + searchId);
        }

        // ================= UC20 END =================
    }
}