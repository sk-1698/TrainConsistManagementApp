import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
class InvalidCapacityException extends Exception {
    InvalidCapacityException(String message) {
        super(message);
    }
}
class CargoSafetyException extends RuntimeException {
    CargoSafetyException(String message) {
        super(message);
    }
}

public class TrainConsistManagementApp {
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than 0");
            }
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }
    public static void main(String[] args) throws InvalidCapacityException {
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
        // ================= UC10 START =================

// Calculate total seating capacity
        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

// Display total capacity
        System.out.println("\nTotal Seating Capacity: " + totalCapacity);

// ================= UC10 END =================
        // ================= UC11 START =================

        Scanner sc = new Scanner(System.in);

// Input
        System.out.print("\nEnter Train ID: ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

// Regex patterns
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

// Matching
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

// Validation result
        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID");
        } else {
            System.out.println("Invalid Train ID");
        }

        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code");
        } else {
            System.out.println("Invalid Cargo Code");
        }

// ================= UC11 END =================
        // ================= UC12 START =================

// Create goods bogies
        List<GoodsBogie> goods = new ArrayList<>();

        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Rectangular", "Coal"));
        goods.add(new GoodsBogie("Cylindrical", "Petroleum")); // valid
// goods.add(new GoodsBogie("Cylindrical", "Water")); // try invalid

// Safety check
        boolean isSafe = goods.stream()
                .allMatch(g ->
                        !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum")
                );

// Display result
        if (isSafe) {
            System.out.println("\nTrain is SAFETY COMPLIANT");
        } else {
            System.out.println("\nTrain is NOT SAFE");
        }

// ================= UC12 END =================
        // ================= UC13 START =================

// Prepare data (reuse Bogie list or create new)
        List<Bogie> testBogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            testBogies.add(new Bogie("Sleeper", 72));
            testBogies.add(new Bogie("AC Chair", 60));
        }

// 🔹 Loop-based filtering
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : testBogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();

// 🔹 Stream-based filtering
        long startStream = System.nanoTime();

        List<Bogie> streamResult = testBogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        long endStream = System.nanoTime();

// Display time taken
        System.out.println("\nLoop Time: " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Time: " + (endStream - startStream) + " ns");

// ================= UC13 END =================
        // ================= UC14 START =================

        try {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 60));
            bogies.add(new Bogie("First Class", 40));

            // Invalid example
            bogies.add(new Bogie("Invalid", -10));

        } catch (InvalidCapacityException e) {
            System.out.println("\nError: " + e.getMessage());
        }

// ================= UC14 END =================
        // ================= UC15 START =================

        String type = "Rectangular";
        String cargo = "Petroleum"; // unsafe case

        try {
            // Validate cargo assignment
            if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Petroleum not allowed in Rectangular bogie");
            }

            System.out.println("\nCargo assigned safely");

        } catch (CargoSafetyException e) {
            System.out.println("\nError: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment process completed.");
        }

// ================= UC15 END =================
    }
}