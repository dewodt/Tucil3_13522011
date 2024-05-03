package solve.search;

public class UCS extends Search {
    public UCS() {
        super();
    }

    @Override
    public int calculateCost(int currentDepth, String word, String endWord) {
        return currentDepth;
    }
}
