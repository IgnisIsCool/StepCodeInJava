import java.util.Scanner;

public class Q1_StringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int manualLength = getLength(input);
        int builtInLength = input.length();

        System.out.println("Manual Length: " + manualLength);
        System.out.println("Built-in Length: " + builtInLength);
    }

    public static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Reached out of bounds
        }
        return count;
    }
}
