package com.brian.test.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class treeSetTest {
    public static void main(String[] args) {
        TreeSet<Monster> monsters = new TreeSet<>(new monsterComparator());

        for (int i = 0; i < 10; i++) {
            monsters.add(new Monster(i));
        }

        for (Monster monster : monsters) {
            System.out.println(monster.getAge());
        }
    }

    public static class monsterComparator implements Comparator<Monster> {
        @Override
        public int compare(Monster o1, Monster o2) {
            return o1.getAge() - o2.getAge();
        }
    }
}
