import java.util.Arrays;

/**
 * Created by Tommaso on 24/04/2018.
 * Given two strings, write a method to decide if one is a permutation of the other
 */


public class CheckPermutation {

    public static void main(String[] args) {

        String testString1 = "we";
        String testString2 = "ew";
        isPermutation(testString1, testString2);

    }

    private static void isPermutation(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            System.out.println("Not permutations");
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


}
