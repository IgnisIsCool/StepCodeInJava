import java.util.Scanner;
public class SimpleTextProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Simple Text Processor ===");
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String sentence = input; // keep original
        int choice;
        do {
            System.out.println("\n--- MENU ---");

            System.out.println("1. Convert to UPPERCASE");
            System.out.println("2. Convert to lowercase");
            System.out.println("3. Count characters and words");
            System.out.println("4. Search for a word");
            System.out.println("5. Replace a word");
            System.out.println("6. Trim spaces");
            System.out.println("7. Split into words");
            System.out.println("8. Reverse sentence");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("UPPERCASE: " + sentence.toUpperCase());
                    break;
                case 2:
                    System.out.println("lowercase: " + sentence.toLowerCase());
                    break;
                case 3:
                    int charCount = sentence.length();
                    String[] words = sentence.trim().split("\\s+");
                    int wordCount = sentence.trim().isEmpty() ? 0 : words.length;
                    System.out.println("Character Count: " + charCount);
                    System.out.println("Word Count: " + wordCount);
                    break;
                case 4:
                    System.out.print("Enter word to search: ");
                    String word = sc.nextLine();
                    if (sentence.toLowerCase().contains(word.toLowerCase())) {
                        System.out.println("'" + word + "' found in the sentence.");
                    } else {
                        System.out.println("'" + word + "' not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter word to replace: ");
                    String oldWord = sc.nextLine();
                    System.out.print("Enter new word: ");
                    String newWord = sc.nextLine();
                    sentence = sentence.replaceAll("(?i)" + oldWord, newWord);
                    System.out.println("Updated sentence: " + sentence);
                    break;
                case 6:
                    sentence = sentence.trim();
                    System.out.println("Trimmed sentence: '" + sentence + "'");
                    break;
                case 7:
                    String[] splitWords = sentence.split(" ");

                    System.out.println("Words:");
                    for (String w : splitWords) {
                        System.out.println(w);
                    }
                    break;
                case 8:
                    String reversed = new StringBuilder(sentence).reverse().toString();
                    System.out.println("Reversed sentence: " + reversed);
                    break;
                case 9:
                    System.out.println("Exiting Text Processor. Goodbye!"); break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);
        sc.close();
    }
}