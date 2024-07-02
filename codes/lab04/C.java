package lab04;

import java.util.Scanner;
public class C {
    TreeNode root;

    public class TreeNode {
        private TreeNode right;
        private TreeNode left;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public C() {
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

    public TreeNode getByKey(TreeNode root, int key) {
        if(root == null || root.data == key) {
            return root;
        }
        if(root.data < key) {
            return getByKey(root.right, key);
        } else {
            return getByKey(root.left, key);
        }
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return ;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void solve(int val) {
        TreeNode node = getByKey(root, val);
        preOrder(node);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C bst = new C();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }
        int target = sc.nextInt();
        bst.solve(target);
    }
}
