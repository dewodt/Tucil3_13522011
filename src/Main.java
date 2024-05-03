import dictionary.Dictionary;
import input.Input;
import output.Output;
import solve.Solve;

public class Main {
    public static void main(String[] args) {
        // Print welcome message
        Output.printWelcome();

        // Read dictionary from file
        Dictionary.initializeDictionary();

        // Get input values
        // input object stores the input values
        Input input = new Input();
        input.initializeInputValue();

        // Get the solution
        // solve object stores the solution values
        Solve solve = new Solve();
        solve.calculateSolution(input);

        // Output result
        Output.printResult(solve);
    }
}