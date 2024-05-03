package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    // Dictionary map (to validate words with O(1) complexity)
    public static Map<String, Boolean> dictionaryMap;

    // Constructor
    public static void initializeDictionary() {
        // Initialize dictionary
        dictionaryMap = new HashMap<>();

        // Load dictionary from file
        try {
            File file = new File("./src/dictionary/words_alpha.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                dictionaryMap.put(word, true);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // File not found
            System.out.println("An error occurred: file not found");
            e.printStackTrace();
            System.exit(0);
        }
    }

    // Check if word is in dictionary
    public static boolean isWordInDictionary(String word) {
        return dictionaryMap.containsKey(word);
    }

    // Generate usable words from dictionary
    public static List<String> generateUsableDictionaryWords(int length) {
        List<String> usableDictionaryWords = new ArrayList<>();

        // Iterate through dictionary map
        dictionaryMap.keySet().forEach(word -> {
            if (word.length() == length) {
                usableDictionaryWords.add(word);
            }
        });

        return usableDictionaryWords;
    }
}
