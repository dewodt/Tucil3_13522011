package input;

import java.util.Scanner;

import lib.Utils;

public class Input {
    // Attributes
    private String startInput;
    private String endInput;
    private int methodInput;

    // Intiialize the input
    public void initializeInputValue() {
        System.out.println(
                "====================================================================================================================================");

        // Initialize scanner
        Scanner sc = new Scanner(System.in);

        // Get start word
        System.out.print("Enter the start word: ");
        this.startInput = sc.nextLine();
        System.out.println();

        // Validate start word
        // Must be alphabetic and not empty
        while (!Utils.isAlphabetic(this.startInput) || this.startInput.length() == 0) {
            // Message for invalid input
            if (!Utils.isAlphabetic(this.startInput))
                System.out.println("The start word must be alphabetic!");
            else if (this.startInput.length() == 0)
                System.out.println("The start word must not be empty!");

            // Get new start word
            System.out.print("Enter the start word: ");
            this.startInput = sc.nextLine();
            System.out.println();
        }

        // Get end word
        System.out.print("Enter the end word: ");
        this.endInput = sc.nextLine();
        System.out.println();

        // Validation end word
        // Must be alphabetic, has the same length as the start word, and not the same
        // as the start word
        while (!Utils.isAlphabetic(this.endInput)
                || this.endInput.length() != this.startInput.length()
                || this.startInput.equals(this.endInput)) {
            // Message
            if (!Utils.isAlphabetic(this.endInput))
                System.out.println("The end word must be alphabetic!");
            else if (this.endInput.length() != this.startInput.length())
                System.out.println("The end word must have the same length as the start word!");
            else if (this.startInput.equals(this.endInput))
                System.out.println("The end word must not be the same as the start word!");

            // Get new end word
            System.out.print("Enter the end word: ");
            this.endInput = sc.nextLine();
            System.out.println();
        }

        // Get method
        // 1. Uniform Cost Search (UCS)
        // 2. Greedy Best First Search (GBFS)
        // 3. A* Search
        System.out.println("Choose the method:");
        System.out.println("1. Uniform Cost Search (UCS)");
        System.out.println("2. Greedy Best First Search (GBFS)");
        System.out.println("3. A* Search");
        System.out.print("Enter the method: ");
        String methodInputStr = sc.nextLine();
        System.out.println();

        // Validate method
        // Must be 1, 2, or 3 and a integer
        while (!Utils.isNumeric(methodInputStr)
                || (Integer.parseInt(methodInputStr) < 1 || Integer.parseInt(methodInputStr) > 3)) {
            // Message
            if (!Utils.isNumeric(methodInputStr))
                System.out.println("The method must be a number!");
            else if (Integer.parseInt(methodInputStr) < 1 || Integer.parseInt(methodInputStr) > 3)
                System.out.println("The method must be 1, 2, or 3!");

            // Get new method
            System.out.print("Enter the method: ");
            methodInputStr = sc.nextLine();
            System.out.println();
        }
        this.methodInput = Integer.parseInt(methodInputStr);

        // Close scanner
        sc.close();

        System.out.println(
                "====================================================================================================================================");
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
