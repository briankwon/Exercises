package com.brian.AlgorithmTraining.haikang;

import java.util.*;


public class second {
    public static void main(String[] args) {
        process();
    }

    //1,A,0;2,B,1;3,C,2;4,D,2
    public static void process() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();

            if (str == null) {
                System.out.println("incorrect data");
                continue;
            }

            String[] strs = str.split(";");

            if (strs.length < 3) {
                System.out.println("incorrect data");
                continue;
            }

            //先看整体的格式对不对
            //再看最左列是否为递增
            //再看最右列是否为非递减
            //有问题就报错然后continue
//            String[][] temp = new String[strs.length][3];
//
//            for (int i = 0; i < strs.length - 1; i = i + 2) {
//                for (int j = i + 1; i < strs.length; j++) {
//                    if (!temp[j][0].matches("[0-9]*") || !temp[j][1].matches("[A-Z]*")
//                            || !temp[j][2].matches("[0-9]*")) {
//                        System.out.println("incorrect data");
//                        continue;
//                    }
//
//                    if (Integer.valueOf(temp[j][0]) < Integer.valueOf(temp[i][0])
//                            || Integer.valueOf(temp[j][2]) < Integer.valueOf(temp[i][2])) {
//                        System.out.println("incorrect data");
//                        continue;
//                    }
//                }
//            }

            Node root = new Node();
            Node parent = null;
            Map<Integer, Node> maps = new LinkedHashMap<>();

            //遍历所有部门信息，建立节点
            for (String s : strs) {
                String[] temp = s.split(",");

                //检查输入数据的格式
                if (!temp[0].matches("[0-9]*") || !temp[1].matches("[A-Z]*")
                    || !temp[2].matches("[0-9]*")) {
                    System.out.println("incorrect data");
                    continue;
                }

                Node node = new Node(temp[1], Integer.valueOf(temp[0]), Integer.valueOf(temp[2]));
                maps.put(node.id, node);
            }

            //建立多叉树
            for (Map.Entry<Integer, Node> entry : maps.entrySet()) {
                Node e = entry.getValue();
                Integer parentId = e.parentId;
                if (parentId == 0) {
                    root = e;
                } else {
                    parent = maps.get(parentId);
                    parent.childs.put(e.id, e);
                }
            }

            //广度优先遍历多叉树
            Queue<Node> queue = new LinkedList<>();
            String prefix = "";
            Node node = null;
            queue.add(root);

            while(!queue.isEmpty()) {
                node = queue.poll();
                int parentId = node.parentId;

                if (parentId != 0) {
                    String parentName = maps.get(parentId).name;
                    int index = prefix.indexOf(parentName);
                    prefix = prefix.substring(0, index + 2);
                }

                if (node.childs.size() == 0) {
                    System.out.print(prefix + node.name + ";");
                } else {
                    prefix += node.name + "-";
                }

                if (!node.childs.isEmpty()) {
                    for (Map.Entry<Integer, Node> entry : node.childs.entrySet()) {
                        queue.add(entry.getValue());
                    }
                }
            }

            System.out.println();
        }
    }
}
