public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Step 1: Normalize string
        // Convert to lowercase and remove spaces
        String normalized = input
                .toLowerCase()
                .replaceAll("\\s+", "");

        // Step 2: Apply two-pointer logic
        int start = 0;
        int end = normalized.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Step 3: Print result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome (ignoring case & spaces).");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }
    }
}