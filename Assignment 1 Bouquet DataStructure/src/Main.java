import java.util.*;

public class Main {
    public static void main(String[] args) {

        // data structure to store bouquet and flower information
        Map<String, Map<String, Set<String>>> bouquetData = new HashMap<>();

        // Populate the data structure with bouquet and flower information
        // Bouquet1
        Map<String, Set<String>> bouquet1 = new HashMap<>();
        Set<String> bouquet1RoseColors = new HashSet<>(Arrays.asList("Red", "White", "Yellow"));
        Set<String> bouquet1TulipColors = new HashSet<>(Arrays.asList("White", "Purple"));
        Set<String> bouquet1LilyColors = new HashSet<>(Collections.singletonList("White"));
        bouquet1.put("Rose", bouquet1RoseColors);
        bouquet1.put("Tulip", bouquet1TulipColors);
        bouquet1.put("Lily", bouquet1LilyColors);
        bouquetData.put("Bouquet1", bouquet1);

        // Bouquet2
        Map<String, Set<String>> bouquet2 = new HashMap<>();
        Set<String> bouquet2RoseColors = new HashSet<>(Arrays.asList("Pink", "Orange"));
        Set<String> bouquet2ChrysanthemumColors = new HashSet<>(Collections.singletonList("Yellow"));
        Set<String> bouquet2BalsamColors = new HashSet<>(Collections.singletonList("Pink"));
        bouquet2.put("Rose", bouquet2RoseColors);
        bouquet2.put("Chrysanthemum", bouquet2ChrysanthemumColors);
        bouquet2.put("Balsam", bouquet2BalsamColors);
        bouquetData.put("Bouquet2", bouquet2);

        //to take input from user uncomment below lines and comment line 37 to 40 and line 43
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input: ");
//        String input = scanner.nextLine();
//        scanner.close();
//        String output = checkIfExists(bouquetData, input);

        String input = "Red Rose";
        String input2 = "Pink Lily";
        String output = checkIfExists(bouquetData, input);
        String output2 = checkIfExists(bouquetData, input2);

        System.out.println("Input: " + input + " ; Output: " + output);
        System.out.println("Input: " + input2 + " ; Output: " + output2);
    }

    public static String checkIfExists(Map<String, Map<String, Set<String>>> data, String inputFlower) {

        String[] flowerParts = inputFlower.split(" ");
        if (flowerParts.length != 2) {
            System.out.println("Invalid input format");
        }

        String flower = flowerParts[1];
        String color = flowerParts[0];

        for (Map.Entry<String, Map<String, Set<String>>> bouquetEntry : data.entrySet()) {
            String bouquetName = bouquetEntry.getKey();
            Map<String, Set<String>> flowers = bouquetEntry.getValue();
            Set<String> colors = flowers.get(flower);

            if (colors != null  && flowers.containsKey(flower) && colors.contains(color)) {
                return bouquetName; // Exit the loop after finding a match
            }
        }
        return "None";
    }
}