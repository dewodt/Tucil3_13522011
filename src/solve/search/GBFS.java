package solve.search;

import lib.Utils;

public class GBFS extends Search {
    // Constructor
    public GBFS() {
        super();
    }

    // Calculate cost f(n) = h(n)
    // h(n) = heuristic
    @Override
    public int calculateCost(int depth, String word, String endWord) {
        int heuristic = Utils.countDifferentCharacters(word, endWord);

        return heuristic;
    }
}
