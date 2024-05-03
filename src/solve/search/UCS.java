package solve.search;

public class UCS extends Search {
    // Constructor
    public UCS() {
        super();
    }

    // Calculate cost f(n) = g(n)
    // g(n) = depth
    @Override
    public int calculateCost(int currentDepth, String word, String endWord) {
        return currentDepth;
    }
}
