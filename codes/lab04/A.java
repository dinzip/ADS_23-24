package lab04;

import java.util.Scanner;
public class A {
    TreeNode root;

    public class TreeNode {
        private TreeNode right;
        private TreeNode left;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public A() {
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

    public String solve(String path) {
        TreeNode current = root;
        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == 'L') {
                if(current.left == null) {
                    return "NO";
                } else {
                    current = current.left;
                }
            } else {
                if(current.right == null) {
                    return "NO";
                } else {
                    current = current.right;
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A bst = new A();

        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }

        for(int i = 0; i < m; i++) {
            System.out.println(bst.solve(sc.next()));
        }
    }
}
