/**
 * Created by tommaso on 25/04/2018.
 * Check if two strings differs by only one edit, which can be an insert of char, a removal of a char or an edit
 * of a char.
 */
public class OneAway {

    public static void main(String[] args) {

        String firstString = "uu";
        String secondString = "iu";
        checkOneAway(firstString, secondString);

    }

    private static void checkOneAway(String firstString, String secondString) {

        boolean isReplace = checkReplace(firstString, secondString);
        System.out.println("Replace is " + isReplace);

        boolean isInsertorDelete = checkInsertAndDelete(firstString, secondString);
        System.out.println("Insert or Delete is " + isInsertorDelete);

        System.out.println("Is it one edit away? " + (isInsertorDelete || isReplace));
    }

    private static boolean checkInsertAndDelete(String firstString, String secondString) {
        if ((firstString.length() !=  (secondString.length() - 1)) && ((firstString.length() - 1) !=  (secondString.length()))) {
            return false;
        }

        String shortString = firstString.length() < secondString.length() ? firstString : secondString;
        String longString = firstString.length() < secondString.length() ? secondString : firstString;
        int i = 0, j = 0;

        while(i < shortString.length() && j < longString.length()) {
            if (shortString.charAt(i) != longString.charAt(j)) {
                if (i != j) {
                    return false;
                }
                j++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    private static boolean checkReplace(String firstString, String secondString) {
        boolean oneEdit = false;
        if (firstString.length() != secondString.length()) {
            return false;
        }

        for (int i = 0; i < firstString.length(); i++) {
            if (firstString.toCharArray()[i] != secondString.toCharArray()[i]) {
                if (oneEdit) {
                    return false;
                }
                oneEdit = true;
            }
        }
        return true;
    }
}
