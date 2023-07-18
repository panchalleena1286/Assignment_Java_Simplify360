import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        // Define the log file path and target job and timestamp
        String logFilePath = "trace.log";
        String targetJob = "J1";
        String targetTimestamp = "2023-06-29 04:04:04";

        // Create a date formatter in the format ("yyyy-MM-dd HH:mm:ss") for parsing log timestamps
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Create a TreeMap to store log entries sorted by timestamp
        TreeMap<Date, String> logEntries = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            Date targetDate = dateFormat.parse(targetTimestamp);

            while ((line = reader.readLine()) != null) {
                // Split the log line into 4 parts (date, time, job name, log text) using space delimiter
                String[] parts = line.split(" ", 4);
                // Parse the logTimestamp from date and time components
                Date logTimestamp = dateFormat.parse(parts[0] + " " + parts[1]);
                // Check if line has all four components as expected
                if (parts.length == 4) {
                    logEntries.put(logTimestamp, line);
                }
                logEntries.put(logTimestamp, line);
            }

            // Find the first log entry with a timestamp greater than the target timestamp
            Map.Entry<Date, String> entry = logEntries.higherEntry(targetDate);
            while (entry != null && !entry.getValue().contains(targetJob)) {
                entry = logEntries.higherEntry(entry.getKey());
            }

            // If a matching log entry is found, print it
            if (entry != null) {
                System.out.println(entry.getValue());
            }
            else{
                System.out.println("No logs found for targetJob " + targetJob + " after " + targetTimestamp);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

