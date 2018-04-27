package FirstChapter;

/**
 * Created by tomma on 24/04/2018.
 * Write a method to replace all space in a string with %20.
 */
public class URLify {

    public static void main(String[] args) {
        String textString = "test for you and me        ";
        int length = 19;
        char[] text = textString.toCharArray();
        replace(text, length);
        replaceInPlace(text, length);
    }

    private static void replaceInPlace(char[] text, int length) {

        int space = 0;
        for (int i = 0; i < length; i++) {
            if (text[i] == ' ') {
                space++;
            }
        }

        int realLength = length + (2 * space);
        for(int i = length - 1; i >=0; i--) {
            if (text[i] == ' ') {
                text[realLength -  1] = '0';
                text[realLength -  2] = '2';
                text[realLength -  3] = '%';
                realLength -= 3;
            } else {
                text[realLength - 1 ] = text[i];
                realLength--;
            }
        }

        System.out.println(text);

    }

    private static void replace(char[] text, int length) {

        int space = 0;
        for (int i = 0; i < length; i++) {
             if (text[i] == ' ') {
                 space++;
             }
        }

        int realLength = length + (2*space), j = 0;
        char[] finalArray = new char[realLength];

        for (int i = 0; i < length; i++) {
            if (text[i] == ' ') {
                finalArray[j] = '%';
                finalArray[j+1] = '2';
                finalArray[j+2] = '0';
                j += 3;
            } else {
                finalArray[j] = text[i];
                j++;
            }
        }

        System.out.println(finalArray);
    }
}
