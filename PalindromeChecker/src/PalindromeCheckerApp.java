import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        for (char c : cleaned.toCharArray()) stack.push(c);
        for (char c : cleaned.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }
}

// Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        for (char c : cleaned.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}

// Context to inject strategy
class PalindromeContext {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean checkPalindrome(String input) {
        if (strategy == null) throw new IllegalStateException("Strategy not set!");
        return strategy.isPalindrome(input);
    }
}

// Main class for performance comparison
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeContext context = new PalindromeContext();

        // Test input
        String testStr = "A man a plan a canal Panama";

        // StackStrategy performance
        context.setStrategy(new StackStrategy());
        long startStack = System.nanoTime();
        boolean resultStack = context.checkPalindrome(testStr);
        long endStack = System.nanoTime();
        System.out.println("StackStrategy result: " + resultStack + ", Time: " + (endStack - startStack) + " ns");

        // DequeStrategy performance
        context.setStrategy(new DequeStrategy());
        long startDeque = System.nanoTime();
        boolean resultDeque = context.checkPalindrome(testStr);
        long endDeque = System.nanoTime();
        System.out.println("DequeStrategy result: " + resultDeque + ", Time: " + (endDeque - startDeque) + " ns");
    }
}