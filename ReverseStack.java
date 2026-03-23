import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Before: " + s);
        reverse(s);
        System.out.println("After: " + s);
    }

    static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) return;

        int top = s.pop();
        reverse(s);
        insertAtBottom(s, top);
    }

    static void insertAtBottom(Stack<Integer> s, int val) {
        if (s.isEmpty()) {
            s.push(val);
            return;
        }

        int top = s.pop();
        insertAtBottom(s, val);
        s.push(top);
    }
}
