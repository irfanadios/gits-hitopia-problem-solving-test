public class HighestPalindromeSolution {
    public static void main(String[] args) {
        String test = "3994929345214993";
        String result = findPalindrome(test, 2);
        System.out.println(result);
    }

    private static String findPalindrome(String test, int replacement) {
        if (test.length() == 0 || test.length() == 1) return test; // handle empty or 1 length string.
        int stringLength = test.length();
        char first = test.charAt(0), last = test.charAt(stringLength - 1); // get first and last char
        if (replacement > 0 && first != last) { // before continue, check if first and last is not same and check replacement count
            replacement--;
            int firstInt = Character.getNumericValue(first);
            int lastInt = Character.getNumericValue(last);
            char max = (char) (Math.max(firstInt, lastInt) + '0'); // check max of first or last
            // set max value between first and last
            first = max;
            last = max;
            // after this, first and last is same so can check palindrome again;
        }
        String palindromeResult = findPalindrome(test.substring(1, stringLength - 1), replacement);
        // if result found "-1", return "-1" for all recursion, else return palindrome value
        if (first == last && !palindromeResult.equalsIgnoreCase("-1")) return first + palindromeResult + last;
        return "-1";
    }
}
