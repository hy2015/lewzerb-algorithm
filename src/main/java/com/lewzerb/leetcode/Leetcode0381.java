package com.lewzerb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Leetcode0381 {

    public static void main(String[] args) {
        Leetcode0381 leetcode0381 = new Leetcode0381();
        RandomizedCollection randomizedCollection = leetcode0381.new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        randomizedCollection.insert(1);
        randomizedCollection.insert(1);
        randomizedCollection.insert(0);

        randomizedCollection.remove(2);
        randomizedCollection.remove(1);
        randomizedCollection.remove(3);

        randomizedCollection.insert(1);
        randomizedCollection.insert(2);


        for(int i=0; i<30; i++){
            System.out.print(randomizedCollection.getRandom() + " ");
        }

    }

    class RandomizedCollection {

        Map<Integer, Set<Integer>> map;
        List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            list.add(val);

            Set<Integer> set = map.getOrDefault(val, new HashSet<>());
            set.add(list.size() - 1);
            map.put(val, set);
            return set.size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            Set<Integer> set = map.getOrDefault(val, new HashSet<>());
            if(set.size() == 0) return false;

            Iterator<Integer> iterator = set.iterator();
            int index = iterator.next();
            Integer last = list.get(list.size() - 1);
            list.set(index, last);

            set.remove(index);
            map.put(val, set);

            map.get(last).remove(list.size() - 1);
            if(index < list.size() - 1){
                map.get(last).add(index);
            }
            if(map.get(val).size() == 0){
                map.remove(val);
            }
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
