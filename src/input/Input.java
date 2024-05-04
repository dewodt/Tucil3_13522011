package input;

import java.util.Scanner;

import dictionary.Dictionary;
import lib.Utils;

public class Input {
    // Attributes
    private String startInput;
    private String endInput;
    private int methodInput;

    // Intiialize the input
    public void initializeInputValue() {
        System.out.println(
                "========================================================================================================================");

        // Initialize scanner
        Scanner sc = new Scanner(System.in);

        // Get start word
        System.out.println();
        System.out.print("Enter the start word: ");
        this.startInput = sc.nextLine().toLowerCase();
        // Validate start word
        while (!Utils.isAlphabetic(this.startInput) // Check if the start word is alphabetic
                || this.startInput.length() == 0 // Check if the start word is not empty
                || !Dictionary.isWordInDictionary(startInput) // Check if the start word is in the dictionary
        ) {
            // Message for invalid input
            if (!Utils.isAlphabetic(this.startInput))
                System.out.println("The start word must be alphabetic!");
            else if (this.startInput.length() == 0)
                System.out.println("The start word must not be empty!");
            else if (!Dictionary.isWordInDictionary(startInput))
                System.out.println("The start word be in the dictionary!");

            // Get new start word
            System.out.println();
            System.out.print("Enter the start word: ");
            this.startInput = sc.nextLine().toLowerCase();
        }

        // Get end word
        System.out.println();
        System.out.print("Enter the end word: ");
        this.endInput = sc.nextLine().toLowerCase();

        // Validation end word
        while (!Utils.isAlphabetic(this.endInput) // Check if the end word is alphabetic
                || this.endInput.length() != this.startInput.length() // Check end word length vs the start word
                || !Dictionary.isWordInDictionary(endInput) // Check if the end word is in the dictionary
                || this.startInput.equals(this.endInput) // Check if the end word is not the same as the start word
        ) {
            // Message
            if (!Utils.isAlphabetic(this.endInput))
                System.out.println("The end word must be alphabetic!");
            else if (this.endInput.length() != this.startInput.length())
                System.out.println("The end word must have the same length as the start word!");
            else if (!Dictionary.isWordInDictionary(endInput))
                System.out.println("The end word must be in the dictionary!");
            else if (this.startInput.equals(this.endInput))
                System.out.println("The end word must not be the same as the start word!");

            // Get new end word
            System.out.println();
            System.out.print("Enter the end word: ");
            this.endInput = sc.nextLine().toLowerCase();
        }

        // Get method
        // 1. Uniform Cost Search (UCS)
        // 2. Greedy Best First Search (GBFS)
        // 3. A* Search
        System.out.println();
        System.out.println("Choose the method: ");
        System.out.println("1. Uniform Cost Search (UCS)");
        System.out.println("2. Greedy Best First Search (GBFS)");
        System.out.println("3. A* Search");
        System.out.print("Enter the method: ");
        String methodInputStr = sc.nextLine();

        // Validate method
        // Must be 1, 2, or 3 and a integer
        while (!Utils.isNumeric(methodInputStr) // Check if the method is a number
                || (Integer.parseInt(methodInputStr) < 1 || Integer.parseInt(methodInputStr) > 3) // 1 <= x <= 3
        ) {
            // Message
            if (!Utils.isNumeric(methodInputStr))
                System.out.println("The method must be a number!");
            else if (Integer.parseInt(methodInputStr) < 1 || Integer.parseInt(methodInputStr) > 3)
                System.out.println("The method must be 1, 2, or 3!");

            // Get new method
            System.out.println();
            System.out.print("Enter the method: ");
            methodInputStr = sc.nextLine();
        }
        this.methodInput = Integer.parseInt(methodInputStr);

        // Close scanner
        sc.close();

        System.out.println();
        System.out.println(
                "========================================================================================================================");
    }

    // Getter
    public String getStartInput() {
        return this.startInput;
    }

    public String getEndInput() {
        return this.endInput;
    }

    public int getMethodInput() {
        return this.methodInput;
    }
}
