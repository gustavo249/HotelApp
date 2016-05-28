package control;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 28/05/2016.
 */
public class ActivityTracker {
    private static List<String> activities = new ArrayList<>();

    public static void addActivity(String operation) {
        activities.add(operation);
    }

    public static void recordAllActivities() {
       Path file = Paths.get("resources\\DailyRapport.txt");
        try {
            Files.write(file, activities, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
