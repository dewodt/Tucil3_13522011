package lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
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

    // Read from dictionary and filter for usable words (word that has the same
    // length as the input star / finish word)
    public static List<String> getUsableWordsFromDictionary(int startFinishWordLength) {
        // Initialize dictionary
        List<String> usableDictionaryWords = new ArrayList<>();

        // Read file
        try {
            File file = new File("./dictionary/words_alpha.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                if (word.length() == startFinishWordLength) {
                    usableDictionaryWords.add(word);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // File not found
            System.out.println("An error occurred: file not found");
            e.printStackTrace();
        }

        return usableDictionaryWords;
    }
}
