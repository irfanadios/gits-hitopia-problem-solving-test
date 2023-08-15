import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBracketSolution {
    public static void main(String[] args) {
        String test = "{ ( ( [ ] ) [ ] ) [ ] }";
        String result = isBalancedBracket(test);
        System.out.println(result);
    }

    private static String isBalancedBracket(String test) {
        Deque<Character> deque = new ArrayDeque<>(); // LIFO (Last In First Out)

        char[] testCharArr = test.toCharArray();

        for (int i = 0; i < testCharArr.length; i++) {
            if (
                testCharArr[i] == '{' ||
                testCharArr[i] == '[' ||
                testCharArr[i] == '('
            ) { // check if char at i is open bracket or not
                deque.push(testCharArr[i]); // push to deque
            } else if (
                !deque.isEmpty() && ( // closed without open bracket will not be checked
                    // pairing closed bracket with open bracket
                    (testCharArr[i] == '}' && deque.peekFirst() == '{') ||
                    (testCharArr[i] == ']' && deque.peekFirst() == '[') ||
                    (testCharArr[i] == ')' && deque.peekFirst() == '(')
                )
            ) {
                deque.pop(); // delete first deque
            }
        }
        
        return deque.isEmpty() ? "YES" : "NO"; // check if deque is not empty then bracket is not balanced, return NO. Otherwise return YES.
    }
}
