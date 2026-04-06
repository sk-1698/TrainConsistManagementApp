import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainConsistManagementApp {
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }
    public static void main(String[] args) {
        // ================= UC7 START =================

// Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

// Sort by capacity
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

// Display sorted bogies
        System.out.println("\nBogies sorted by capacity:");

        for (Bogie b : bogies) {
            System.out.println(b);
        }

// ================= UC7 END =================
    }
}