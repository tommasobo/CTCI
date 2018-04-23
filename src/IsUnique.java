import java.util.*;

public class IsUnique {

    public static void main(String[] args) {

        String testString = "This S ";
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
                System.out.println("No all unique chars");
                return;
            }
        }
        System.out.println("All unique chars");
    }
}
