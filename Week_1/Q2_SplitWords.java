import java.util.Scanner;

public class Q2_SplitWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] manualWords = splitWords(input);
        String[] builtInWords = input.split(" ");

        System.out.println("\nManual Split:");
        for (String word : manualWords) System.out.println(word);

        System.out.println("\nBuilt-in Split:");
        for (String word : builtInWords) System.out.println(word);

        System.out.println("\nArrays are equal: " + compareArrays(manualWords, builtInWords));
    }

    public static String[] splitWords(String s) {
        int wordCount = 1;
        int len = getLength(s);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') wordCount++;
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        String temp = "";
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                words[wordIndex++] = temp;
                temp = "";
            } else {
                temp += c;
            }
        }
        words[wordIndex] = temp;
        return words;
    }

    public static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    public static boolean compareArrays(String[] a1, String[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++) {
            if (!a1[i].equals(a2[i])) return false;
        }
        return true;
    }
}
