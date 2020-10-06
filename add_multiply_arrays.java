package com.leetcode_java;

public class add_multiply_arrays {

    public static int[] addOne(int[] a) {
        if(a == null || a.length == 0) return null;

        int[] result=new int[a.length+1];
        int carry = 0;
        int resultIndex = result.length-1;

        for(int i=a.length-1; i>=0; i--) {
            int num = a[i];
            int partialRes = 0;
            if(i==a.length-1) {
                partialRes = num + 1;
            } else {
                partialRes = num + carry;
            }
            int newNum = partialRes%10;
            carry = partialRes/10;
            result[resultIndex] = newNum;
            resultIndex--;
        }
        result[0] = carry;

        return result;
    }

    public static int[] multiply(int[] a, int[] b) {
        if (a == null || b == null) return null;

        int[] result = new int[a.length + b.length -1];
        boolean neg = false;
        int resultIndex = result.length-1;

        int num1 = getNum(a);
        int num2 = getNum(b);
        int resultInt = num1*num2;
        if(resultInt<0) {
            neg = true;
            resultInt = -resultInt;
        }

        while(resultInt>0) {
            int numAtIndex = resultInt%10;
            result[resultIndex--] = numAtIndex;
            resultInt/=10;
        }
        if(neg) result[0] = -result[0];
        return result;
    }

    private static int getNum(int[] a) {
        int num =0;
        int tens = 0;
        boolean neg = false;

        if(a[0] < 0) {
            neg = true;
            a[0] = -a[0];
        }

        for(int i=a.length-1; i>=0; i--) {
            num += a[i] * (Math.pow(10,tens));
            tens++;
        }

        return (neg) ? -num : num;
    }
}
