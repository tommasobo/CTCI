package FirstChapter;

/**
 * Created by tommaso on 27/04/2018.
 * Implement a method to perform basic string compression using the counts of repeated chars.
 * For example aabccccaaa -> a2b1c5a3
 * Return the smallest string between the original one and the compressed one.
 */
public class StringCompression {

    public static void main(String[] args) {

        String text = "aabbsssrrrrraa";
        System.out.println("Shortest string is " + compress(text));

    }

    // Commented code not using StringBuilder (the latter is O(n) fast, while normal String concatenation is O(n^2)
    private static String compress(String text) {

        int countRepeated = 1;
        //String newString = "";
        StringBuilder compressedString = new StringBuilder();
        char[] stringArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            if ((i + 1 < text.length() && (stringArray[i] == stringArray[i+1]))) {
                countRepeated++;
            } else {
                //newString = newString + stringArray[i] + countRepeated;
                compressedString.append(stringArray[i]);
                compressedString.append(countRepeated);
                countRepeated = 1;
            }
        }
        return compressedString.length() < text.length() ? compressedString.toString() : text;
    }
}
