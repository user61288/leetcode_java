package com.leetcode_java;

import java.util.HashMap;

public class int_to_roman {
    public static String intToRoman(int num) {
        if(num == 0) return null;

        HashMap<Integer, String> map = new HashMap<Integer, String>()
        {{
            put(1,"I");
            put(5,"V");
            put(10,"X");
            put(50,"L");
            put(100,"C");
            put(500,"D");
            put(1000,"M");
            put(4,"IV");
            put(9,"IX");
            put(40,"XL");
            put(90,"XC");
            put(400,"CD");
            put(900,"CM");

        }};

        int count = 0;
        int rem = 0;
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            if(num/1000>0 || num%1000>=900) {
                num = convertToRoman(map, sb, num, 1000, 900);
            }
            else if(num/500>0 || num%500>=400) {
                num = convertToRoman(map, sb, num, 500, 400);
            }
            else if(num/100>0 || num%100>=90) {
                num = convertToRoman(map, sb, num, 100, 90);
            }
            else if(num/50>0 || num%50>=40) {
                num = convertToRoman(map, sb, num, 50, 40);
            }
            else if(num/10>0 || num%10==9) {
                num = convertToRoman(map, sb, num, 10, 9);
            } else if(num/5>0 || num%5==4) {
                num = convertToRoman(map, sb, num, 5, 4);
            } else {
                sb.append(map.get(1));
                num--;
            }
        }

        return sb.toString();

    }

    public static int convertToRoman(HashMap<Integer, String> map, StringBuilder sb, int num, int d1, int d2) {
        int count = num /d1;
        if (count > 0) {
            for (int i = 0; i < count; i++) sb.append(map.get(d1));
            num = num % d1;
        } else {
            int rem = num % d1;
            if (rem/d2 == 1) {
                sb.append(map.get(d2));
                num = num % d2;
            }
        }
        return num;
    }
}
