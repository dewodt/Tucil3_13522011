package solve.search;

import lib.Utils;

public class AStar extends Search {
    // Constructor
    public AStar() {
        super();
    }

    // Calculate cost f(n) = g(n) + h(n)
    // g(n) = depth
    // h(n) = heuristic
    @Override
    public int calculateCost(int depth, String word, String endWord) {
        int heuristic = Utils.countDifferentCharacters(word, endWord);

        return depth + heuristic;
    }
}
