import java.util.ArrayList;
import java.util.Arrays;


public class TrainConsistManagementApp {

    public static void main(String[] args)  {

        String[] bogieIdsArr = {"B1", "B2", "B3", "B4", "B5"};


        String searchKey = "B3";

        boolean found = false;

        for (String id : bogieIdsArr) {
            if (id.equals(searchKey)) {
                found = true;
                break;
            }
        }


        if (found) {
            System.out.println("\nBogie ID " + searchKey + " found.");
        } else {
            System.out.println("\nBogie ID " + searchKey + " not found.");
        }

