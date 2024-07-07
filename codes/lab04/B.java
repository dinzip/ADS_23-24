package lab04;

import java.util.Scanner;
public class B {
    TreeNode root;

    public class TreeNode {
        private TreeNode right;
        private TreeNode left;
        private int data;
        private int size;

        public TreeNode(int data) {
            this.data = data;
            this.size = 1;
        }
    }

    public B() {
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
        root.size++;
        if(val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public int solve(TreeNode root, int val) {
        if(root == null) {
            return 0;
        }
        if(root.data == val) {
            return root.size;
        }
        if(val < root.data) {
            return solve(root.left, val);
        } else {
            return solve(root.right, val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        B bst = new B();

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }

        int target = sc.nextInt();
        System.out.println(bst.solve(bst.root, target));
        sc.close();
    }
}
