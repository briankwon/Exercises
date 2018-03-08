package com.brian.AlgorithmTraining.offer;

import java.util.HashMap;
import java.util.Map;

public class Q07constructBinaryTree {
    public TreeNode construct(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    /**
     * 递归的定义
     * 根据前序数组 p 和中序数组 n 重构二叉树并返回头结点
     * @param p     前序数组
     * @param pi    前序遍历的起始位置
     * @param pj    前序遍历的终止位置
     * @param n     中序数组
     * @param ni    中序遍历的起始位置
     * @param nj    中序遍历的起始位置
     * @param map   存放了中序数组<值,下标>的map
     * @return
     */
    public TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, Map<Integer, Integer> map) {
        //当前序数组的起始位置大于终止位置时跳出递归
        if (pi > pj) {
            return null;
        }

        //重构二叉树的头结点为前序数组的第一个元素
        TreeNode head = new TreeNode(p[pi]);
        //在map中查找头结点对应的下标
        int index = map.get(p[pi]);
        //[1,2,4,5,8,9,3,   6,    7]  ---> p
        //[4,2,8,5,9,1,6,   3,    7]  ---> n
        //             ni   index
        //index - ni 为细分的中序数组左子树中的节点个数
        int len = index - ni;
        //递归，细分左右子树
        // pi  pi+1         pi+len   pi+len+1          pj
        //[1,   2,   4,5,8,   9,         3,      6,    7]  ---> p
        // ni               index - 1  index   index + 1   nj
        //[4,   2,8,5,        9,         1,        6,  3,  7]  ---> n

        //[2,3,4,5,9]   为头结点1的左子树的前序遍历，[4,2,8,5,9]  为中序遍历
        //[3,6,7]       为头结点1的右子树的前序遍历，[6,3,7]      为中序遍历
        head.left = preIn(p, pi + 1, pi + len, n, ni, index - 1, map);
        head.right = preIn(p, pi + len + 1, pj, n, index + 1, nj, map);
        return head;
    }
}
