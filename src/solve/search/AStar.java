package solve.search;

import lib.Utils;

public class AStar extends Search {
    public AStar() {
        super();
    }

    @Override
    public int calculateCost(int depth, String word, String endWord) {
        int heuristic = Utils.countDifferentCharacters(word, endWord);

        return depth + heuristic;
    }
}
