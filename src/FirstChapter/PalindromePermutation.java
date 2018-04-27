package FirstChapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommaso on 24/04/2018.
 * Check if a permutation of a string is palindrome
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        String string = "mom mom";
        System.out.println(IsPalindromePermutation(string));

    }


    private static boolean IsPalindromePermutation(String text) {

        char[] textArray = text.toCharArray();
        HashMap<Character, Integer> mapChar = new HashMap<>();
        boolean isOdd = false;

        // Check if the string is already a palindrome
        if (new StringBuilder(text).reverse().toString().equals(text)) {
            return true;
        }

        // Create hashmap to store characters count
        for (char aTextArray : textArray) {
            mapChar.put(aTextArray, mapChar.getOrDefault(aTextArray, 0) + 1);
        }

        // Check how many chars are repeated a number of odd times
        for (Map.Entry<Character, Integer> pair : mapChar.entrySet()) {
            if (((pair.getValue() % 2) != 0)) {
                if (isOdd) {
                    return false;
                }
                isOdd = true;
            }
        }
        return isOdd;
    }
}


