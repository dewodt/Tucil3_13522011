package solve;

import java.util.ArrayList;
import java.util.List;

import input.Input;

public class Solve {
    private List<String> solution;
    private int totalNodeTraversed;
    private double duration;

    public Solve() {
        this.solution = new ArrayList<>();
        this.totalNodeTraversed = 0;
        this.duration = 0;
    }

    public void calculateSolution(Input inputValue) {
        // Get start word
        String startWord = inputValue.getStartInput();

        // Get end word
        String endWord = inputValue.getEndInput();

        // Get method
        int method = inputValue.getMethodInput();

        // Get start time
        long startTime = System.nanoTime();

        // Solve
        if (method == 1) {
            // Using UCS
            UCS ucs = new UCS();
            ucs.search(startWord, endWord);
            this.solution = ucs.getSolution();
            this.totalNodeTraversed = ucs.getTotalNodeTraversed();
        } else if (method == 2) {
            // Solve using GBFS
            GBFS gbfs = new GBFS();
            gbfs.search(startWord, endWord);
            this.solution = gbfs.getSolution();
            this.totalNodeTraversed = gbfs.getTotalNodeTraversed();
        } else if (method == 3) {
            // Solve using A*
            AStar aStar = new AStar();
            aStar.search(startWord, endWord);
            this.solution = aStar.getSolution();
            this.totalNodeTraversed = aStar.getTotalNodeTraversed();
        }

        // Get end time
        long endTime = System.nanoTime();

        // Calculate duration
        this.duration = (endTime - startTime) / 1000000.0;
    }

    public List<String> getSolution() {
        return this.solution;
    }

    public int getTotalNodeTraversed() {
        return this.totalNodeTraversed;
    }

    public double getDuration() {
        return this.duration;
    }

    public void printResult() {
        System.out.println(
                "====================================================================================================================================");
        System.out.println();

        System.out.println("Result: ");
        for (int i = 0; i < this.solution.size(); i++) {
            System.out.println(i + 1 + " " + this.solution.get(i));
        }
        System.out.println("Total node traversed: " + this.totalNodeTraversed);
        System.out.println("Duration: " + this.duration + " ms");

        System.out.println();
        System.out.println(
                "====================================================================================================================================");

    }
}
