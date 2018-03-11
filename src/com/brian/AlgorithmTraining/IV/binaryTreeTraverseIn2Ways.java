package com.brian.AlgorithmTraining.IV;

import java.util.Stack;

public class binaryTreeTraverseIn2Ways {
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void preOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            head = stack.pop();

            System.out.print(head.val + " ");
            /**
             * 要求中间的节点都要印完后先打印左边的再打印右边的
             * 但是因为栈的特性需要先把右节点入栈再把左节点入栈
             * 这样出栈顺序是先左在右，也就实现了根左右的打印顺序
             */
            if (head.right != null) {
                stack.push(head.right);
            }

            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }

        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    /**
     * 把二叉树的最左边压进栈中，这样弹出的时候就是先左再中的
     * 在弹出的时候再把右节点按同样的规则压进栈中，这样在弹出的时候也是先左再中的，但是整体上就是左中右
     * @param head
     */
//    public static void inOrderUnRecur(TreeNode head) {
//        if (head == null) {
//            return;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(head);
//
//        //两个条件满足一个就继续循环
//        while (!stack.isEmpty() || head != null) {
//            if (head != null) {
//                stack.push(head);
//                head = head.left;
//            } else {
//                //这块老错，想清楚
//                head = stack.pop();
//                System.out.print(head.val + " ");
//                head = head.right;
//            }
//        }
//    }

    public static void inOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        //这里不用push！！！！
        //stack.push(head);

        //两个条件满足一个就继续循环
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                //这块老错，想清楚
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }

    public static void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + " ");
    }

    public static void posOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);

        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);

            if (head.left != null) {
                stack1.push(head.left);
            }

            if (head.right != null) {
                stack1.push(head.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.print("pre-order: ");
        preOrderUnRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderUnRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderUnRecur(head);
        System.out.println();
//        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);
    }
}
