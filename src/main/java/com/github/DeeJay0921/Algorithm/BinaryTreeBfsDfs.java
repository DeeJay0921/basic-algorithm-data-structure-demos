package com.github.DeeJay0921.Algorithm;

import java.util.*;

public class BinaryTreeBfsDfs {
    private static List<TreeNode> nodes = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        System.out.println(bfs(node1));
        System.out.println(dfs(node1));

        recusiveDfs(node1); // 使用递归进行dfs
        System.out.println("nodes = " + nodes); // 递归dfs结果
    }

    // 二叉树的广度优先遍历（层次遍历） 使用队列
    public static List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            list.add(node.value);
        }
        return list;
    }

    // 二叉树的深度优先遍历（前序） 使用栈
    public static List<Integer> dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        //压入根节点
        stack.push(root);
        //然后就循环取出和压入节点，直到栈为空，结束循环
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 先压入右边  因为要先处理左边节点
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            list.add(node.value);
        }
        return list;
    }

    // 二叉树的深度优先遍历 使用递归 （前序）
    public static void recusiveDfs(TreeNode root) {
        // 使用递归进行深度遍历
        if (root != null) {
            nodes.add(root);
            // 如果是前序 每次先添加左节点，直到没有子节点点，返回上一级
            recusiveDfs(root.left);
            recusiveDfs(root.right);
        }
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }
    }
}
