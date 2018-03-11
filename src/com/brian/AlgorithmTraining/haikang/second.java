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
            }

            String[] strs = str.split(";");

            if (strs.length < 3) {
                System.out.println("incorrect data");
            }

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

                Node node = new Node();
                node.id = Integer.valueOf(temp[0]);
                node.name = temp[1];
                node.parentId = Integer.valueOf(temp[2]);
                maps.put(node.id, node);
            }


            /**
             * 1 A 0
             * 2 B 1
             * 3 C 1
             */
//            for (Map.Entry<Integer, Node> entry : maps.entrySet()) {
//                Node node = entry.getValue();
//                System.out.println(node.id + " " + node.name + " " +  node.parentId);
//            }

            //建立多叉树
            for (Map.Entry<Integer, Node> entry : maps.entrySet()) {
                Node e = entry.getValue();
                Integer parentId = e.parentId;
                if (parentId == 0) {
                    //root.childs.put(e.id, e);
                    root.parentId = 0;
                    root.id = e.id;
                    root.name = e.name;
                    maps.replace(e.id, e, root);
                } else {
                    parent = maps.get(parentId);
                    //System.out.println(e.parentId);
                    parent.childs.put(e.id, e);
                    //System.out.println(maps.get(parentId).childs.get(2).name);
                }
            }

            System.out.println(root.id + " " + root.name + " " +  root.parentId);
            for (Map.Entry<Integer, Node> entry : root.childs.entrySet()) {
                Node node = entry.getValue();
                System.out.println(node.id + " " + node.name + " " +  node.parentId);
            }
            //广度优先遍历多叉树
            Queue<Node> queue = new LinkedList<>();
            String prefix = "";
            Node node = null;
            queue.add(root);

            while(!queue.isEmpty()) {
                node = queue.poll();
                System.out.print(node.name + "-");

                if (node.childs != null && !node.childs.isEmpty()) {
                    for (Map.Entry<Integer, Node> entry : node.childs.entrySet()) {
                        queue.add(entry.getValue());
                    }
                }
            }

        }
    }
    //从末尾开始向头部寻找当前部门的所属部门，并把其加入sb当中
    public static void recur(Map<String, Map<String, String>> map, ArrayList<String> namelist, ArrayList<String> res) {

    }
}
