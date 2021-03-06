package com.brian.AlgorithmTraining.haikang;

import java.util.LinkedHashMap;
import java.util.Map;

public class Node {
    String name;
    Integer id;
    Integer parentId;
    Map<Integer, Node> childs = new LinkedHashMap<>();

    public Node(String name, Integer id, Integer parentId) {
        this.name = name;
        this.id = id;
        this.parentId = parentId;
    }

    public Node() {
    }
}
