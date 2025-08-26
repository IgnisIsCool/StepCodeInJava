import java.util.Scanner;

public class Q3_WordsWithLengths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] result = getWordsWithLengths(words);

        System.out.println("\nWord\tLength");
        for (String[] row : result) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }

        sc.close(); // ✅ always close scanner
    }

    // Returns [word, length] pairs
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    // Manually splits sentence into words (handles multiple spaces too)
    public static String[] splitWords(String s) {
        int len = getLength(s), count = 0;

        // Count words manually (skip multiple spaces)
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (s.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[count];
        int wordIndex = 0;
        String temp = "";

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                if (!temp.equals("")) {
                    words[wordIndex++] = temp;
                    temp = "";
                }
            } else {
                temp += s.charAt(i);
            }
        }
        if (!temp.equals("")) words[wordIndex] = temp; // last word
        return words;
    }

    // Manual length calculation (fixed off-by-one error)
    public static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count++);
            }
        } catch (Exception e) {
            // ignore
        }
        return count - 1; // ✅ correct length
    }
}
