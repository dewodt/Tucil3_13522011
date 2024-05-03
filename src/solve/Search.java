package solve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import lib.Utils;

public abstract class Search {
    private Node solutionNode;
    private int totalNodeTraversed;

    public abstract int calculateCost(int currentDepth, String word, String endWord);

    public void search(String startWord, String endWord) {
        // Implement search algorithm.
        // Algorithm is same, only calculateCost() is different.

        // Initialize empty priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>(Node.customComparator);

        // Get all usable words from the dictionary
        List<String> dictionary = Utils.getUsableWordsFromDictionary(startWord.length());

        // Initialize map to store visited nodes
        Map<String, Boolean> visited = new HashMap<>();
        for (String word : dictionary) {
            visited.put(word, false);
        }

        // Initialize start node
        Node startNode = new Node(startWord, 0, 0, null);

        // Initialize solution data
        this.totalNodeTraversed = 0;
        this.solutionNode = null;

        // Add start node to priority queue
        pq.add(startNode);

        // Loop until priority queue is empty
        while (!pq.isEmpty()) {
            // Get node with the lowest cost
            Node lowestCostNodeDequeue = pq.poll();

            // DEBUG
            System.out.println(lowestCostNodeDequeue.getWord());

            // Check if node is already visited before
            if (visited.get(lowestCostNodeDequeue.getWord())) {
                continue;
            }

            // Check if current best solution is found, the cost is more than the current
            // solution then continue
            if (this.solutionNode != null) {
                if (lowestCostNodeDequeue.getCost() > this.solutionNode.getCost()) {
                    continue;
                }
            }

            // Mark node as visited
            visited.put(lowestCostNodeDequeue.getWord(), true);
            this.totalNodeTraversed++;

            // Check if node is the end word
            if (lowestCostNodeDequeue.getWord().equals(endWord)) {
                // Check if current best solution is found
                if (this.solutionNode == null || lowestCostNodeDequeue.getCost() < this.solutionNode.getCost()) {
                    this.solutionNode = lowestCostNodeDequeue;
                }
            } else {
                // Update queue
                for (String word : dictionary) {
                    // Only add words that is not yet visited and has only 1 different character
                    if (!visited.get(word)
                            && Utils.countDifferentCharacters(lowestCostNodeDequeue.getWord(), word) == 1) {
                        // Update queue with new nodes
                        int newDepth = lowestCostNodeDequeue.getDepth() + 1;
                        int newCost = calculateCost(newDepth, word, endWord);
                        Node newNode = new Node(word, newCost, newDepth, lowestCostNodeDequeue);
                        pq.add(newNode);
                    }
                }
            }
        }
    }

    public int getTotalNodeTraversed() {
        return this.totalNodeTraversed;
    }

    public List<String> getSolution() {
        List<String> solution = new ArrayList<>();

        Node currentNode = this.solutionNode;
        while (currentNode != null) {
            solution.add(0, currentNode.getWord());
            currentNode = currentNode.getParent();
        }

        return solution;
    }
}
