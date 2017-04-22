package com.company;

/**
 * Created by albertso on 4/20/17.
 */
class Arge {

    public static int nbYear(int p0, double percent, int aug, int p) {
        int total = p0 + (int)(p0 * percent/100) + aug;
        int years = 1;
        while (total < p) {
            total = total + (int)(total * percent/100) + aug;
            years++;
        }
        return years;
    }
}

/*
public class Arge {
    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        while (p0 < p) {
            p0 += p0 * percent / 100 + aug; // += casts to int and auto floors the result.
            years++;
        }
        return years;
    }
}*/

/*
class Arge {
    public static int nbYear(int p0, double percent, int aug, int p) {
        int y = 0;
        double c = p0;
        for(; c < p; y++) c = c * (1 + percent / 100D) + aug; // 100D converts 100 to double. no parameter instantiated for loop
        return y;
    }
}*/
