import java.util.Scanner;
public class StringProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
// Taking input from the user
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
// 1. Display original input
        System.out.println("\nOriginal input: " + input);
// 2. Convert to upper and lower case
        System.out.println("Uppercase: " + input.toUpperCase());
        System.out.println("Lowercase: " + input.toLowerCase());
// 3. Trim leading and trailing spaces
        String trimmed = input.trim();
        System.out.println("Trimmed input: '" + trimmed + "'");

// 4. Length of the string
        System.out.println("Length of input: " + input.length());
// 5. First and last character
        if (input.length() > 0) {
            System.out.println("First character: " + input.charAt(0));
            System.out.println("Last character: " + input.charAt(input.length() - 1));
        }
// 6. Replace all spaces with underscores
        String replaced = input.replace(' ', '_');
        System.out.println("After replacing spaces with underscores: " + replaced);
// 7. Check if the input contains a certain word
        System.out.print("Enter a word to search: ");
        String word = sc.nextLine();
        boolean contains = input.contains(word);
        System.out.println("Contains '" + word + "': " + contains);
// 8. Split the input and display each word
        String[] words = input.split(" ");
        System.out.println("Words in the input:");
        for (String w : words) {
            System.out.println(w);
        }
// 9. Check if input starts or ends with a specific string
        System.out.print("Enter a prefix to check: ");
        String prefix = sc.nextLine();
        System.out.println("Starts with '" + prefix + "': " + input.startsWith(prefix));
        System.out.print("Enter a suffix to check: ");
        String suffix = sc.nextLine();
        System.out.println("Ends with '" + suffix + "': " + input.endsWith(suffix));
        sc.close();
    }
}