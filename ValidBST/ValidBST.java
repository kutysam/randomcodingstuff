class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class ValidBST {
    public ValidBST() {
        Node root = CreateSeedData();
        boolean answer = CheckValidBST(root, null, null);
        System.out.println(answer);
    }

    Node CreateSeedData() {
        Node root = new Node(50);
        root.left = new Node(25);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right = new Node(75);
        root.right.left = new Node(63);
        root.right.right = new Node(87);
        return root;
    }

    boolean CheckValidBST(Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        // The data is smaller than min or greater than max. invalid!
        if ((min != null && n.value <= min) || (max != null && n.value > max)) {
            return false;
        }

        boolean left = CheckValidBST(n.left, min, n.value); // Check Left
        boolean right = CheckValidBST(n.right, n.value, max); // Check Right

        if (!left || !right) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidBST vBST = new ValidBST();
    }
}
