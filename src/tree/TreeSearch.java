package tree;


import java.util.*;

public class TreeSearch {


    static class Tree {

        Tree left;
        Tree right;
        int val;

        Tree(int val) {
            this.val = val;

        }


    }

    //DFS
    public static void DFS(Tree root) {

        Stack<Tree> stack = new Stack<>();
        List list = new ArrayList();

        stack.push(root);

        while (!stack.isEmpty()) {

            Tree tree = stack.pop();
            if (tree.right != null) {
                stack.push(tree.right);
            }

            if (tree.left != null) {
                stack.push(tree.left);
            }
            list.add(tree.val);


        }
        list.forEach(t -> System.out.println(t));


    }

    //BFS
    public static void BFS(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        List list = new ArrayList();

        queue.offer(root);

        while (!queue.isEmpty()) {

            Tree tree = queue.poll();

            if (tree.left != null) {
                queue.offer(tree.left);
            }

            if (tree.right != null) {
                queue.offer(tree.right);
            }
            list.add(tree.val);

        }

        list.forEach(t -> System.out.println(t));
    }

    public static void main(String[] args) {

        Tree tree = new Tree(1);
        Tree tree1 = new Tree(3);
        Tree tree2 = new Tree(4);
        Tree tree3 = new Tree(5);
        Tree tree4 = new Tree(6);
        Tree tree5 = new Tree(7);

        tree.left = tree1;
        tree.right = tree2;
        tree1.left = tree3;
        tree1.right = tree4;
        tree2.left = tree5;

        BFS(tree);
        DFS(tree);

    }

    
}
