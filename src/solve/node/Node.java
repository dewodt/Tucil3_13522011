package solve.node;

import java.util.Comparator;

public class Node {
    private String word; // The word that the node represents
    private int cost; // The cost of the node
    // The depth of the node in the search tree (o(1) access rather than o(d)
    // traversal to get depth )
    private int depth;
    private Node parent; // The parent of the node

    // Constructor
    public Node(String word, int cost, int depth, Node parent) {
        this.word = word;
        this.cost = cost;
        this.depth = depth;
        this.parent = parent;
    }

    // Getters
    public String getWord() {
        return word;
    }

    public int getCost() {
        return cost;
    }

    public int getDepth() {
        return depth;
    }

    public Node getParent() {
        return parent;
    }

    // Print the node (to help debug)
    public void printNode() {
        System.out.println("Word: " + word + " Cost: " + cost);
    }

    // Comparator to compare nodes based on their cost
    public static Comparator<Node> customComparator = new Comparator<Node>() {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.getCost() - n2.getCost();
        }
    };
}
