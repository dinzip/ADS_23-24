package lab04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class E{
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

    public E() {
        root = new TreeNode(1);
    }

    public TreeNode find(TreeNode root, int val) {
        if(root == null) {
            return null;
        } else if(root.data == val) {
            return root;
        }

        TreeNode temp = find(root.left, val);
        if(temp == null) {
            return find(root.right, val);
        }
        return temp;
    }

    public void insert(int parent, int val, int pos) {
        TreeNode temp = find(root, parent);
        if(pos == 0) {
            temp.left = new TreeNode(val);
            temp.left.lvl += temp.lvl;
        } else {
            temp.right = new TreeNode(val);
            temp.right.lvl += temp.lvl;
        }
    }

    public void display() {
        display(root);
    }
    public void display(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
             TreeNode temp = q.poll();
            if(temp.left != null || temp.right != null) {
                System.out.println("PR = " + temp.data + ":");
            }

            if(temp.left != null) {
                q.offer(temp.left);
                System.out.println("    L: " + temp.left.data + " ==> lvl: " + temp.left.lvl);
            }

            if(temp.right != null) {
                q.offer(temp.right);
                System.out.println("    R: " + temp.right.data + " ==> lvl: " + temp.right.lvl);
            }
        }
    }

    public int solve() {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int mx = 1, lst_lvl = 1, width = 0;
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.lvl != lst_lvl) {
                mx = Math.max(mx, width);
                lst_lvl = temp.lvl;
                width = 1;
            } else {
                width++;
            }

            if(temp.left != null) q.offer(temp.left);
            if(temp.right != null) q.offer(temp.right);
        }
        return Math.max(mx, width);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        E bt = new E();
        int n = sc.nextInt();
        for(int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            bt.insert(x, y, z);
        }
//        bt.display();
        System.out.println(bt.solve());
    }
}
