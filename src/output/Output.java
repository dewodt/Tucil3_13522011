package output;

import java.util.List;

import solve.Solve;

public abstract class Output {
	// Method to print result values
	public static void printResult(final Solve result) {
		System.out.println(
				"========================================================================================================================");
		System.out.println();

		// Words
		List<String> solution = result.getSolution();
		if (solution.size() == 0) {
			System.out.println("Result: No solution found!");
		} else {
			System.out.println("Result: ");
			for (int i = 0; i < result.getSolution().size(); i++) {
				System.out.println(i + 1 + ". " + result.getSolution().get(i));
			}
		}

		// Total node traversed
		System.out.println("Total node traversed: " + result.getTotalNodeTraversed());

		// Duration
		System.out.println("Duration: " + result.getDuration() + " ms");

		// Memory used
		System.out.println("Memory used: " + result.getMemoryUsed() + " KB");

		System.out.println();
		System.out.println(
				"========================================================================================================================");
		System.out.println(
				"========================================================================================================================");
	}

	// Method to print welcome message
	public static void printWelcome() {
		System.out.println(
				"========================================================================================================================");
		System.out.println(
				"========================================================================================================================");
		System.out.println(
				"____    __    ____  ______   .______       _______      __          ___       _______   _______   _______ .______");
		System.out.println(
				"\\   \\  /  \\  /   / /  __  \\  |   _  \\     |       \\    |  |        /   \\     |       \\ |       \\ |   ____||   _  \\ ");
		System.out.println(
				" \\   \\/    \\/   / |  |  |  | |  |_)  |    |  .--.  |   |  |       /  ^  \\    |  .--.  ||  .--.  ||  |__   |  |_)  |");
		System.out.println(
				"  \\            /  |  |  |  | |      /     |  |  |  |   |  |      /  /_\\  \\   |  |  |  ||  |  |  ||   __|  |      / ");
		System.out.println(
				"   \\    /\\    /   |  `--'  | |  |\\  \\----.|  '--'  |   |  `----./  _____  \\  |  '--'  ||  '--'  ||  |____ |  |\\  \\----.");
		System.out.println(
				"    \\__/  \\__/     \\______/  | _| `._____||_______/    |_______/__/     \\__\\ |_______/ |_______/ |_______|| _| `._____|");
		System.out.println(
				"                                                                                                                        ");
		System.out.println(
				"                             _______.  ______    __      ____    ____  _______ .______                                 ");
		System.out.println(
				"                            /       | /  __  \\  |  |     \\   \\  /   / |   ____||   _  \\                                ");
		System.out.println(
				"                           |   (----`|  |  |  | |  |      \\   \\/   /  |  |__   |  |_)  |                               ");
		System.out.println(
				"                            \\   \\    |  |  |  | |  |       \\      /   |   __|  |      /                                ");
		System.out.println(
				"                        .----)   |   |  `--'  | |  `----.   \\    /    |  |____ |  |\\  \\----.                           ");
		System.out.println(
				"                        |_______/     \\______/  |_______|    \\__/     |_______|| _| `._____|                           ");
		System.out.println();
		System.out.println(
				"========================================================================================================================");
	}
}
