import java.util.*;

/*
    Implement an algorithm to determine if a string has all unique chars. What if you can't use
    additional data structures?

 */
public class IsUnique {

    public static void main(String[] args) {

        String testString = "This Ss";
        hashMapSolution(testString);
        sortingSolution(testString);

    }

    private static void hashMapSolution(String testString) {
        HashMap<Character, Integer> countLetters = new HashMap<>();

        for (int i = 0, n = testString.length(); i < n; i++) {
            char c = testString.charAt(i);
            if (c != ' ') {
                countLetters.put(c, countLetters.getOrDefault(c, 0) + 1);
            }
        }

        Set<Map.Entry<Character, Integer>> result = countLetters.entrySet();
        for (Map.Entry<Character, Integer> values : result) {
            if ( values.getValue() > 1) {
                System.out.println("Not all unique chars");
                return;
            }
        }
        System.out.println("All unique chars");
    }

    private static void sortingSolution(String testString) {
        char[] testChar = testString.toCharArray();
        Arrays.sort(testChar);
        for (int i = 0; i < testChar.length - 1; i++) {
            if (testChar[i] == testChar[i+1]) {
                System.out.println("Not all unique chars");
                return;
            }
        }
        System.out.println("All unique chars");
    }
}
