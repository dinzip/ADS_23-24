package lab04;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class F{
    TreeNode root;
    int res = 0;

    public class TreeNode {
        private TreeNode right;
        private TreeNode left;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public F() {
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
                System.out.println("    L: " + temp.left.data);
            }

            if(temp.right != null) {
                q.offer(temp.right);
                System.out.println("    R: " + temp.right.data);
            }
        }
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return ;
        }
        if(root.left != null && root.right != null) res++;
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F bst = new F();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }
//        bst.display();
        bst.inOrder(bst.root);
        System.out.println(bst.res);
        sc.close();
    }
}
