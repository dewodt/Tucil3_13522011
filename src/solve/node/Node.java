package solve.node;

import java.util.Comparator;

public class Node {
    private String word;
    private int cost;
    private int depth;
    private Node parent;

    public Node(String word, int cost, int depth, Node parent) {
        this.word = word;
        this.cost = cost;
        this.depth = depth;
        this.parent = parent;
    }

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

    public void printNode() {
        System.out.println("Word: " + word + " Cost: " + cost);
    }

    public static Comparator<Node> customComparator = new Comparator<Node>() {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.getCost() - n2.getCost();
        }
    };

}
