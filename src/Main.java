import initialize.Initialize;
import input.Input;
import solve.Solve;

public class Main {
    public static void main(String[] args) {
        // Print initial message
        Initialize.printWelcomeMessage();

        // Input values
        Input input = new Input();
        input.initializeInputValue();

        // Solve
        Solve solve = new Solve();
        solve.calculateSolution(input);

        // Output result
        solve.printResult();
    }
}