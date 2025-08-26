import java.util.Scanner;

public class Q5_VowelsConsonantsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        sc.close();

        int[] result = countVowelsAndConsonants(input);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }

    public static int[] countVowelsAndConsonants(String s) {
        int vowels = 0, consonants = 0;
        int len = getLength(s);

        for (int i = 0; i < len; i++) {
            String type = checkCharacterType(s.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += 32; // Convert to lowercase

        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    // Fixed getLength (no off-by-one)
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
}
