package com.brian.VII;

import com.brian.V.Edge;
import com.brian.V.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * Dijkstra算法，返回从当前节点到各个可到达节点的最短路径
 */
public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra(Node head) {
        //记录『目前』从head出发可以到达的node以及距离
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        //记录已经去过的节点
        HashSet<Node> touchedNodes = new HashSet<>();

        distanceMap.put(head, 0);
        Node minNode = getMinNode(distanceMap, touchedNodes);

        while (minNode != null) {
            //从distanceMap中得到从head到minNode的距离
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    //直接加入distanceMap，这里的距离是 head到minNode的距离 + minNode到toNode的距离。
                    distanceMap.put(toNode, distance + edge.weight);
                }

                distanceMap.put(toNode, Math.min(distance + edge.weight, distanceMap.get(toNode)));
            }

            touchedNodes.add(minNode);
            minNode = getMinNode(distanceMap, touchedNodes);
        }

        return distanceMap;
    }

    public static Node getMinNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;

        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            if (!touchedNodes.contains(entry.getKey()) && entry.getValue() < minDistance) {
                minNode = entry.getKey();
                minDistance = entry.getValue();
            }
        }

        return minNode;
    }

    public static void main(String[] args) {

    }
}
