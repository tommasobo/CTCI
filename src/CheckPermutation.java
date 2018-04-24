import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tommaso on 24/04/2018.
 * Given two strings, write a method to decide if one is a permutation of the other
 */


public class CheckPermutation {

    public static void main(String[] args) {

        String testString1 = "ciao a tutti";
        String testString2 = "iutttaoaic  ";
        isPermutation(testString1, testString2);
        isPermutationWithHash(testString1, testString2);

    }

    private static void isPermutationWithHash(String firstString, String secondString) {

        if (!checkLength(firstString, secondString)) {
            System.out.println("No permutations");
            return;
        }

        HashMap<Character, Integer> lettersCountFirstString = new HashMap<>();
        HashMap<Character, Integer> lettersCountSecondString = new HashMap<>();
        for (int i = 0; i < firstString.length(); i++) {
            lettersCountFirstString.put(firstString.charAt(i), lettersCountFirstString.getOrDefault(firstString.charAt(i), 0) +1);
            lettersCountSecondString.put(secondString.charAt(i), lettersCountSecondString.getOrDefault(secondString.charAt(i), 0) +1);
        }

        if (lettersCountFirstString.equals(lettersCountSecondString)) {
            System.out.println("Yes permutations");
            return;
        }
        System.out.println("No permutations");
    }

    private static void isPermutation(String firstString, String secondString) {

        if (!checkLength(firstString, secondString)) {
            System.out.println("No permutations");
            return;
        }

        char[] firstStringArray = firstString.toCharArray();
        char[] secondStringArray = secondString.toCharArray();

        Arrays.sort(firstStringArray);
        Arrays.sort(secondStringArray);

        /* Possible for loop to use, but it's useless compared to the more elegant solution
        for (int i = 0; i < firstString.length(); i++) {
            if (firstStringArray[i] != secondStringArray[i]) {
                System.out.println("Not permutations");
                return;
            }
        }
        */

        if (Arrays.equals(firstStringArray, secondStringArray)) {
            System.out.println("Yes permutations");
            return;
        }
        System.out.println("No permutations");
    }

    private static boolean checkLength(String firstString, String secondString) {
        return (firstString.length() == secondString.length());
    }


}
