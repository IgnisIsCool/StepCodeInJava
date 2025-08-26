import java.util.Scanner;

public class Q6_CharacterClassification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = classifyCharacters(input);
        displayResult(result);
    }

    // Method to classify each character
    public static String checkCharacterType(char ch) {
        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1) {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to classify entire string, returns 2D array [char, classification]
    public static String[][] classifyCharacters(String s) {
        int length = getLength(s);
        String[][] arr = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            arr[i][0] = String.valueOf(ch);
            arr[i][1] = checkCharacterType(ch);
        }
        return arr;
    }

    // Method to display the 2D array in tabular format
    public static void displayResult(String[][] arr) {
        System.out.println("Char\tType");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
        }
    }

    // Method to get string length without using length()
    public static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Index out of bounds reached
        }
        return count;
    }
}
