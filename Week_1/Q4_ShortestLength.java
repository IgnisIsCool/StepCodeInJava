import java.util.Scanner;

public class Q4_ShortestLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        sc.close();

        if (input == null || input.trim().isEmpty()) {
            System.out.println("No words found.");
            return;
        }

        String[] words = splitWords(input);
        if (words.length == 0) {
            System.out.println("No words found.");
            return;
        }

        String[][] wordLengthArray = getWordsWithLengths(words);
        int[] result = getMinMaxIndices(wordLengthArray);

        System.out.println("\nShortest Word: " + wordLengthArray[result[0]][0]
                + " (length " + wordLengthArray[result[0]][1] + ")");
        System.out.println("Longest Word: " + wordLengthArray[result[1]][0]
                + " (length " + wordLengthArray[result[1]][1] + ")");
    }

    public static int[] getMinMaxIndices(String[][] arr) {
        int minIdx = 0, maxIdx = 0;
        int minLen = Integer.parseInt(arr[0][1]);
        int maxLen = minLen;

        for (int i = 1; i < arr.length; i++) {
            int len = Integer.parseInt(arr[i][1]);
            if (len < minLen) {
                minLen = len;
                minIdx = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }

    // Splits by spaces but ignores multiple/leading/trailing spaces
    public static String[] splitWords(String s) {
        int len = getLength(s);
        boolean inWord = false;
        int count = 0;

        // Count words robustly
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (s.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[count];
        int idx = 0;
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (temp.length() > 0) {
                    words[idx++] = temp.toString();
                    temp.setLength(0);
                }
            } else {
                temp.append(c);
            }
        }
        if (temp.length() > 0) words[idx] = temp.toString();
        return words;
    }

    // Manual length calculation (fixed — increments only when access succeeds)
    public static int getLength(String s) {
        int count = 0;
        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
}
