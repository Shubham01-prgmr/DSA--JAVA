import java.util.*;

class Node {
    int val;
    List<Node> neighbors;

    Node(int val){
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}
public class CloneGraph {
    public static Node cloneGraph(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor, map));
        }

        return clone;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        HashMap<Node, Node> map = new HashMap<>();

        Node clonedGraph = cloneGraph(node1, map);

        System.out.println("Graph cloned successfully!");
    }
}