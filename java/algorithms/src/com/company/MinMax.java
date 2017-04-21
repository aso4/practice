package com.company;

/**
 * Created by albertso on 4/21/17.
 */
public class MinMax {
    public int min(int[] list) {
        int minInt = list[0];
        for (int i=1; i < list.length; i++) {
            minInt = (minInt > list[i]) ? list[i] : minInt;
        }
        return minInt;
    }

    public int max(int[] list) {
        int maxInt = list[0];
        for (int i=1; i < list.length; i++) {
            maxInt = (maxInt < list[i]) ? list[i] : maxInt;
        }
        return maxInt;
    }
}

/* for number in list symbol.
public int min(int[] list) {
    int n = Integer.MAX_VALUE;
    for (int num: list) n = num < n? num: n;
    return n;
}*/

/* uses Arrays class, stream, min, getAsInt.
public int min(int[] list) {
    return Arrays.stream(list).min().getAsInt();
}

public int max(int[] list) {
    return Arrays.stream(list).max().getAsInt();
}*/
