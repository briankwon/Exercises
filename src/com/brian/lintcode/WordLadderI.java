package com.brian.lintcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://segmentfault.com/a/1190000003698569
 */
public class WordLadderI {
    public int ladderLength(String start, String end, Set<String> dict) {
        //如果start和end相同直接输出
        if (start.equals(end)) {
            return 1;
        }

        //BFS，使用队列放入每一层所有字符串
        Queue<String> queue = new LinkedList<>();
        int step = 2;
        queue.offer(start);

        while (!queue.isEmpty()) {
            //这里要给size单独赋值循环，因为queue的size是在变化的
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //对cur的每一位都替换成a~z，看是否和end相同
                //如果不相同看dict中是否有这cur，有的话将它移出dict并加入queue。
                //eg. cur = "hot",sb = "got", dict = "got","dot"。
                //如果不把got移出dict的话，在cur = "dot"时会再次将got入队
                for (int j = 0; j < cur.length(); j++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuffer sb = new StringBuffer(cur);
                        sb.setCharAt(j, letter);
                        if (end.equals(sb.toString())) {
                            return step;
                        } else if (dict.contains(sb.toString())) {
                            dict.remove(sb.toString());
                            queue.offer(sb.toString());
                        }
                    }
                }
            }
            step++;
        }

        return 0;
    }

    public static void main(String[] args) {
        String s = "a";
        String e = "c";
        Set<String> set = new HashSet<>();
        set.add("b");
    }
}
