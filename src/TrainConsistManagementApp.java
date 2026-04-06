import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Set<String> bogieIds = new HashSet<>();

// Adding bogie IDs (including duplicate)
        bogieIds.add("B1");
        bogieIds.add("B2");
        bogieIds.add("B3");
        bogieIds.add("B2"); // duplicate
        bogieIds.add("B1"); // duplicate

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);


    }
}