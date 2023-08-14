import java.util.HashMap;
import java.util.Map;

/**
 * WeightedStringsSolution
 */
public class WeightedStringsSolution {
    public static void main(String[] args) {
        String test = "abbcccd";
        int[] queries = {1, 3, 9, 8};
        String[] result = weightedStrings(test, queries);
        print(result);
    }

    private static String[] weightedStrings(String test, int[] queries) {
        String testLowerCase = test.toLowerCase(); // lower case so A-Z can be checked too
        Map<String, Integer> map = new HashMap<>();
        String lastChar = ""; // string lastChar initialization
        for (int i = 0; i < testLowerCase.length(); i++) { // checking letter one by one
            char currentChar = testLowerCase.charAt(i);
            if (lastChar.contains(String.valueOf(currentChar))) { // if lastChar contains currentChar
                String prevChar = lastChar; // set prevChar so the map can get value of prevChar
                lastChar += String.valueOf(currentChar); // add character to string
                map.put(lastChar, map.get(prevChar) + (currentChar - 96)); // insert with previous value
            } else {
                lastChar = String.valueOf(currentChar); // currentChar is different from lastChar, set lastChar to currentChar
                map.put(lastChar, currentChar - 96); // insert new value
            }
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) { // display result yes or no
            result[i] = map.containsValue(queries[i]) ? "Yes" : "No";
        }
        return result;
    }

    private static void print(String[] stringArray) {
        System.out.print("[");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i]);
            if (i != stringArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}