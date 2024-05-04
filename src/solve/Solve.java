package solve;

import java.util.ArrayList;
import java.util.List;

import input.Input;
import solve.search.AStar;
import solve.search.GBFS;
import solve.search.UCS;

public class Solve {
    // Store solution
    private List<String> solution;
    private int totalNodeTraversed;
    private double duration;
    private long memoryUsed;

    // Constructor
    public Solve() {
        this.solution = new ArrayList<>();
        this.totalNodeTraversed = 0;
        this.duration = 0;
    }

    // Calculate solution
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

        // Calculate memory usage
        Runtime rt = Runtime.getRuntime();
        long memory = rt.totalMemory() - rt.freeMemory();
        System.out.println("Memory used: " + memory / 1024 + " KB");
        this.memoryUsed = memory / 1024;
    }

    // Getters
    // Get solution
    public List<String> getSolution() {
        return this.solution;
    }

    // Get total node traversed
    public int getTotalNodeTraversed() {
        return this.totalNodeTraversed;
    }

    // Get duration
    public double getDuration() {
        return this.duration;
    }

    // Get memory used
    public long getMemoryUsed() {
        return this.memoryUsed;
    }
}
