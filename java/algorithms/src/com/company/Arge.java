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

// https://www.codewars.com/kata/563b662a59afc2b5120000c6/train/java