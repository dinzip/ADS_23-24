package lab04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class I {
    TreeNode root;
    int sum = 0;

    public class TreeNode {
        private TreeNode right;
        private TreeNode left;
        private int data;
        private int cnt;

        public TreeNode(int data) {
            this.data = data;
            this.cnt = 1;
        }
    }

    public I() {
        root = null;
    }

    public TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void insert(int val) {
        root = insert(root, val);
    }
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if(val > root.data) {
            root.right = insert(root.right, val);
        } else {
            root.cnt++;
        }
        return root;
    }

    public void deleteNode(int val) {
        TreeNode temp = find(root, val);
        if(temp == null)
            return ;
        else if(temp.cnt > 1)
            temp.cnt--;
        else if(temp == root && temp.right == null && temp.left == null)
            root = null;
        else
            root = deleteNode(root, val);
    }
    public TreeNode deleteNode(TreeNode root, int data) {
        if (root == null) {
            return null;
        } else if (root.data > data) {
            root.left = deleteNode(root.left, data);
            return root;
        } else if (root.data < data) {
            root.right = deleteNode(root.right, data);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode temp = getMin(root.right);
                root.data = temp.data;
                root.cnt = temp.cnt;
                root.right = deleteNode(root.right, temp.data);
                return root;
            }
        }
    }

    public int find(int key) {
        TreeNode temp = find(root, key);
        if(temp == null)
            return 0;
        else
            return temp.cnt;
    }
    public TreeNode find(TreeNode root, int key) {
        if(root == null || root.data == key)
            return root;

        if(key < root.data)
            return find(root.left, key);
        else
            return find(root.right, key);
    }

    public void display() {
        display(root);
    }
    public void display(TreeNode root) {
        System.out.println("DISPLAY:");
        if(root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.left != null || temp.right != null || temp == root)
                System.out.println("PR = " + temp.data + ", cnt = " + temp.cnt + ":");
            if(temp.left != null) {
                q.offer(temp.left);
                System.out.println("    L: " + temp.left.data + ", cnt = " + temp.left.cnt);
            }
            if(temp.right != null) {
                q.offer(temp.right);
                System.out.println("    R: " + temp.right.data + ", cnt = " +temp.right.cnt);
            }
        }
    }

    public void solve(String s, int val) {
            if(s.equals("insert")) {
                insert(val);
            } else if(s.equals("delete")) {
                deleteNode(val);
            } else {
                System.out.println(find(val));
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        I bst = new I();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            bst.solve(sc.next(), sc.nextInt());
//            bst.display(); // to check current bst
        }
        sc.close();
    }
}
