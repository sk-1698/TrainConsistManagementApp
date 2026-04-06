import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;



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
        // ================= UC8 START =================

// Filter bogies with capacity > 60
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

// Display filtered bogies
        System.out.println("\nFiltered Bogies (capacity > 60):");

        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }

// ================= UC8 END =================
        // ================= UC9 START =================

// Group bogies by type (using name as category)
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

// Display grouped bogies
        System.out.println("\nGrouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

// ================= UC9 END =================
    }
}