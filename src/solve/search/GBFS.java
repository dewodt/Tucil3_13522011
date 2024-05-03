package solve.search;

import lib.Utils;

public class GBFS extends Search {
    public GBFS() {
        super();
    }

    @Override
    public int calculateCost(int depth, String word, String endWord) {
        int heuristic = Utils.countDifferentCharacters(word, endWord);

        return heuristic;
    }
}
