import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Ask user to enter a sentence with mixed formatting
        System.out.println("Enter a sentence with mixed formatting:");
        String input = scanner.nextLine();

        // 1. trim() - Remove leading/trailing spaces
        String trimmed = input.trim();
        System.out.println("Trimmed: " + trimmed);

        // 2. replace() - Replace all spaces with underscores
        String withUnderscores = trimmed.replace(" ", "_");
        System.out.println("Spaces replaced: " + withUnderscores);

        // 3. replaceAll() - Remove all digits using regex
        String noDigits = trimmed.replaceAll("\\d", "");
        System.out.println("No digits: " + noDigits);

        // 4. split() - Split sentence into words
        String[] words = trimmed.split("\\s+"); // split on one or more spaces
        System.out.println("Words: " + Arrays.toString(words));

        // 5. join() - Rejoin words with " | " separator
        String joined = String.join(" | ", words);
        System.out.println("Joined: " + joined);

        // Additional processing:
        // Remove punctuation
        String noPunctuation = removePunctuation(trimmed);
        System.out.println("No punctuation: " + noPunctuation);

        // Capitalize first letter of each word
        String capitalized = capitalizeWords(noPunctuation);
        System.out.println("Capitalized: " + capitalized);

        // Reverse the order of words
        String reversedOrder = reverseWordOrder(noPunctuation);
        System.out.println("Reversed order: " + reversedOrder);

        // Count word frequency
        System.out.println("Word frequency:");
        countWordFrequency(noPunctuation);

        scanner.close();
    }

    // Remove punctuation
    public static String removePunctuation(String text) {
        return text.replaceAll("[^a-zA-Z\\s]", ""); // keep letters and spaces only
    }

    // Capitalize each word
    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Reverse word order
    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    // Count word frequency
    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
