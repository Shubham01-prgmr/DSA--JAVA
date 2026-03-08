import java.util.*;
public class LevelOrderList {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BinaryTreeB{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            
            return newNode;
        }
        public static List<List<Integer>> levelOrder(Node root){
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> level = new ArrayList<>();

                for(int i = 0; i < size; i++){
                    Node curr = q.remove();
                    level.add(curr.data);

                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTreeB tree = new BinaryTreeB();
        Node root = tree.buildTree(nodes);
        List<List<Integer>> result = tree.levelOrder(root);

        for(List<Integer> level : result){
            System.out.println(level);
        }
    }
}