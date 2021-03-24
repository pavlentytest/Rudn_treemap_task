package ru.samsung.itschool.mdev;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, TreeMap<String,Integer>> users = new TreeMap<>();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String name = scan.next();
            String prod = scan.next();
            int count = scan.nextInt();
            if(users.containsKey(name)) {
                TreeMap<String,Integer> user = users.get(name);
                if(user.containsKey(prod)) {
                    int tmp = user.remove(prod);
                    user.put(prod,tmp + count);
                } else {
                    user.put(prod,count);
                }
            } else {
                TreeMap<String, Integer> user = new TreeMap<>();
                user.put(prod, count);
                users.put(name, user);
            }
        }

        for(Map.Entry e: users.entrySet()) {
            System.out.println(e.getKey() + ":");
            TreeMap<String, Integer> user = (TreeMap)e.getValue();
            for(Map.Entry e1: user.entrySet()) {
                System.out.println(e1.getKey() + " " + e1.getValue());
            }

        }
    }
}