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
        String testLowerCase = test.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        String currentChar = "";
        for (int i = 0; i < testLowerCase.length(); i++) {
            if (currentChar.contains(String.valueOf(testLowerCase.charAt(i)))) {
                String oldChar = currentChar;
                currentChar += String.valueOf(testLowerCase.charAt(i));
                map.put(currentChar, map.get(oldChar) + (testLowerCase.charAt(i) - 96));
            } else {
                currentChar = String.valueOf(testLowerCase.charAt(i));
                map.put(currentChar, testLowerCase.charAt(i) - 96);
            }
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
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