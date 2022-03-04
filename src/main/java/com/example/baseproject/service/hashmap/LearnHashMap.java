package com.example.baseproject.service.hashmap;

import java.util.HashMap;

public class LearnHashMap {
    public static void main(String[] args) {

        /**
         * Sebuah class yg berisi sekumpulan pasangan nilai (value) dan kunci (key).
         * Nilai bisa berbentuk string, int boolean, dll. Untuk key biasanya int dan string.
         *
         * 	fungsi-fungsinya:
         * 	- clear()
         * 	- isEmpty()
         * 	- size()
         * 	- values()
         * 	- keySet()
         * 	- clone()
         */

        HashMap<String, String> room = new HashMap<>();

        room.put("name", "Old Trafford");
        room.put("club", "Man Utd");

        System.out.println(room);
    }
}
