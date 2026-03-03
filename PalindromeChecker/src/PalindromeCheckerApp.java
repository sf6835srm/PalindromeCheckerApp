import java.util.Stack;

public class PalindromeCheckerApp {

    // Encapsulated palindrome checking logic
    public boolean checkPalindrome(String word) {

        // Using internal stack for reversal
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromeService service = new PalindromeService();  // Encapsulation / Object

        String word1 = "radar";
        String word2 = "hello";

        System.out.println(word1 + " is Palindrome? " + service.checkPalindrome(word1));
        System.out.println(word2 + " is Palindrome? " + service.checkPalindrome(word2));
    }
}