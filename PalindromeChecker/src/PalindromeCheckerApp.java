import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// 1️⃣ Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// 2️⃣ Stack-based Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// 3️⃣ Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// 4️⃣ Context to inject strategy
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        if (strategy == null) throw new IllegalStateException("Strategy not set!");
        return strategy.isPalindrome(input);
    }
}

// 5️⃣ Main to test strategies
public class PalimdromeCheckerApp {
    public static void main(String[] args) {
        PalindromeContext context = new PalindromeContext();
        String testStr = "A man a plan a canal Panama";

        // Using StackStrategy
        context.setStrategy(new StackStrategy());
        System.out.println("StackStrategy: " + context.checkPalindrome(testStr));

        // Using DequeStrategy
        context.setStrategy(new DequeStrategy());
        System.out.println("DequeStrategy: " + context.checkPalindrome(testStr));
    }
}