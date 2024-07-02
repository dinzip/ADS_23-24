package lab04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class D{
    TreeNode root;
    int mx_lvl = 0;

    public class TreeNode {
        private TreeNode right;
        private TreeNode left;
        private int data;
        private int lvl;
        public TreeNode(int data) {
            this.data = data;
            this.lvl = 1;
        }
    }

    public D() {
        root = null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }
    public TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            mx_lvl = 1;
            return root;
        }
        if(val < root.data) {
            root.left = insert(root.left, val);
            if(root.left.data == val) root.left.lvl += root.lvl;
            mx_lvl = Math.max(mx_lvl, root.left.lvl);
        } else {
            root.right = insert(root.right, val);
            if (root.right.data == val) root.right.lvl += root.lvl;
            mx_lvl = Math.max(mx_lvl, root.right.lvl);
        }

        return root;
    }

    public void solve() {
        System.out.println(mx_lvl);
        if(root == null) {
            return ;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0, lst_lvl = 1;
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.lvl != lst_lvl) {
                System.out.print(sum + " ");
                lst_lvl = temp.lvl;
                sum = temp.data;
            } else {
                sum += temp.data;
            }

            if(temp.left != null) q.offer(temp.left);
            if(temp.right != null) q.offer(temp.right);
        }
        System.out.print(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D bst = new D();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }
        bst.solve();
    }
}
