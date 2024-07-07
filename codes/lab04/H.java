package lab04;

import java.util.Scanner;
public class H {
    TreeNode root;
    int sum = 0;

    public class TreeNode {
        private TreeNode right;
        private TreeNode left;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public H() {
        root = null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }
    public TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }

        if(val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public void solve(TreeNode root) { // inOrder traversing. but reversed, start with right side, after left
        if(root == null)
            return ;
        solve(root.right);
        root.data += sum; // update data, and sum
        sum = root.data;
        System.out.print(root.data + " ");
        solve(root.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H bst = new H();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
            bst.insert(sc.nextInt());

        bst.solve(bst.root);
        sc.close();
    }
}
