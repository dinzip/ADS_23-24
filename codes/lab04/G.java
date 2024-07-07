package lab04;

import java.util.Scanner;
public class G {
    TreeNode root;
    int ans = 0;

    public class TreeNode {
        private TreeNode right;
        private TreeNode left;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public G() {
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

    public int height(TreeNode root) {
        if(root == null)
            return 0;

        int l_h = height(root.left);
        int r_h = height(root.right);
        ans = Math.max(ans, 1 + l_h + r_h);

        return Math.max(l_h, r_h) + 1;
    }

    public int diameter() {
        if(root == null)
            return 0;
        height(root);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        G bst = new G();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
            bst.insert(sc.nextInt());

        System.out.println(bst.diameter());
        sc.close();
    }
}
