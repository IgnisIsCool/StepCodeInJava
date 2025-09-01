public class StringBuiltInMethods {
    public static void main(String[] args){
        String sampleText = " Java Programming is Fun and Challenging! ";
        // TODO: Use built-in methods to perform the following operations:
        // 1. Display original string length including spaces
        // 2. Remove leading and trailing spaces, show new length
        // 3. Find and display the character at index 5
        // 4. Extract substring "Programming" from the text
        // 5. Find the index of the word "Fun"
        // 6. Check if the string contains "Java" (case-sensitive)
        // 7. Check if the string starts with "Java" (after trimming)
        // 8. Check if the string ends with an exclamation mark
        // 9. Convert the entire string to uppercase
        // 10. Convert the entire string to lowercase
        // TODO: Create a method that counts vowels using charAt()
        // TODO: Create a method that finds all occurrences of a character
        // TODO: Display all results in a formatted manner

        System.out.print("1. Length : " + sampleText.length());
        String trimmedText = sampleText.trim();
        System.out.println("\n2. Trimmed text: \"" + trimmedText + "\"");
        System.out.println("   Length after trimming: " + trimmedText.length());
        System.out.println("3. Character at index 5: '" + sampleText.charAt(5) + "'");
        String sub = sampleText.substring(6, 17);
        System.out.println("4. Substring 'Programming': " + sub);
        int funIndex = sampleText.indexOf("Fun");
        System.out.println("5. Index of 'Fun': " + funIndex);
        System.out.println("6. Contains 'Java'? " + sampleText.contains("Java"));
        System.out.println("7. Starts with 'Java' after trimming? " + trimmedText.startsWith("Java"));
        System.out.println("8. Ends with '!'? " + sampleText.endsWith("!"));
        System.out.println("9. Uppercase: " + sampleText.toUpperCase());
        System.out.println("10. Lowercase: " + sampleText.toLowerCase());

        int vowelCount = countVowels(sampleText);
        System.out.println("11. Vowel count: " + vowelCount);

        char targetChar = 'a';
        System.out.print("12. Occurrences of '" + targetChar + "': ");
        findOccurrences(sampleText, targetChar);
    }


    public static int countVowels(String str) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }


    public static void findOccurrences(String str, char ch) {
        boolean found = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
}
