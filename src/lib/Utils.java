package lib;

public abstract class Utils {
    // Check if the string is numeric
    public static boolean isNumeric(final String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Check if string is alphabetic
    public static boolean isAlphabetic(final String str) {
        return str.matches("[a-zA-Z]+");
    }

    // Check how many characters are different between two strings
    // Initial state: Both strings have the same length
    public static int countDifferentCharacters(final String str1, final String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
