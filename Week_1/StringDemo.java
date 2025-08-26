public class StringDemo {
    public static void main(String[] args) {
// 1. Creating Strings
        String s1 = "Hello"; // Using string literal
        String s2 = new String("World"); // Using new keyword
        char[] charArray = { 'J', 'a', 'v', 'a' };
        String s3 = new String(charArray); // Using character array
// Printing created strings
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("String 3: " + s3);
// 2. String Concatenation
        String s4 = s1 + " " + s2;
        System.out.println("Concatenated String: " + s4);
// 3. String Length
        System.out.println("Length of s3: " + s3.length());
// 4. Substring
        System.out.println("Substring of s4 (0 to 5): " + s4.substring(0, 5));
// 5. Changing Case
        System.out.println("Uppercase: " + s3.toUpperCase());
        System.out.println("Lowercase: " + s3.toLowerCase());
// 6. String Comparison
        String s5 = "Hello";
        System.out.println("s1 equals s5: " + s1.equals(s5));
        System.out.println("s1 == s5: " + (s1 == s5)); // Reference comparison
        System.out.println("s1 equalsIgnoreCase s5: " + s1.equalsIgnoreCase("HELLO"));
// 7. Character at specific index
        System.out.println("Character at index 1 in s1: " + s1.charAt(1));

// 8. Replace characters
        System.out.println("s2 with 'o' replaced by '@': " + s2.replace('o', '@'));
// 9. Trim whitespaces
        String s6 = " Trim Me ";
        System.out.println("Before trim: '" + s6 + "'");
        System.out.println("After trim: '" + s6.trim() + "'");
// 10. Split String
        String sentence = "Java is fun";
        String[] words = sentence.split(" ");
        System.out.println("Words in sentence:");
        for(String word : words) {
            System.out.println(word);
        }
    }
}