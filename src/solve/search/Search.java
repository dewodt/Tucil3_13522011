package solve.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import dictionary.Dictionary;
import lib.Utils;
import solve.node.Node;

public abstract class Search {
    // Store solution node and total node traversed
    private Node solutionNode;
    private int totalNodeTraversed;

    // Abstract method to be implemented by subclasses
    public abstract int calculateCost(int currentDepth, String word, String endWord);

    // Search algorithm
    // Algorithm is same, only calculateCost() is different.
    public void search(String startWord, String endWord) {
        // Initialize empty priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>(Node.customComparator);

        // Get all usable words from the dictionary
        List<String> usableDictionaryWords = Dictionary.generateUsableDictionaryWords(startWord.length());

        // Initialize map to store visited nodes
        Map<String, Boolean> visited = new HashMap<>();
        for (String word : usableDictionaryWords) {
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
                for (String word : usableDictionaryWords) {
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

    // Getters
    // Get total node traversed
    public int getTotalNodeTraversed() {
        return this.totalNodeTraversed;
    }

    // Get solution
    public List<String> getSolution() {
        List<String> solution = new ArrayList<>();

        Node currentNode = this.solutionNode;
        while (currentNode != null) {
            solution.add(0, currentNode.getWord()); // Reverse the order (because we are traversing from end to start)
            currentNode = currentNode.getParent();
        }

        return solution;
    }
}
