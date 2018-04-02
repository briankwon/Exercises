package com.brian.AlgorithmTraining.qunar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class first {
    private static String org;
    private static String fin;
    private static String[] list;
    private static boolean[] visited;
    private static boolean flag = false;
    private static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            org = sc.nextLine();
            fin = new StringBuffer(org).reverse().toString();
            list = sc.nextLine().split(" ");
            visited = new boolean[list.length];

            process(new Node(org, 0));
            if (!flag) {
                System.out.println(0);
            }
        }
    }

    public static void process(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            if (temp.s.equals(fin)) {
                flag = true;
                System.out.println(temp.n + 1);
                return;
            } else {
                for (int i = 0; i < org.length(); i++) {
                    StringBuffer cache = new StringBuffer(temp.s);
                    for (int j = 0; j < 26; j++) {
                        cache.setCharAt(i, alphabet[j]);
                        int num = isInList(cache.toString());
                        if (num == -1) {
                            continue;
                        } else {
                            if (visited[num] == false) {
                                visited[num] = true;
                                queue.add(new Node(cache.toString(), temp.n + 1));
                            }
                        }
                    }
                }
                queue.poll();
            }
        }
    }

    public static int isInList(String s) {
        if (s.equals(fin)) {
            return list.length;
        }

        for (int i = 0; i < list.length; i++) {
            if (s.equals(list[i])) {
                return i;
            }
        }

        return -1;
    }
}

class Node {
    String s;
    int n;
    Node(String s, int n) {
        this.s = s;
        this.n = n;
    }
}
