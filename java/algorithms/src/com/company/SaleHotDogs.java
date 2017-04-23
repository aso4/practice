package com.company;

/**
 * Created by albertso on 4/22/17.
 */
public class SaleHotdogs{
    public static int saleHotdogs(final int n){
        return n < 5 ? 100*n : n >= 10 ? 90*n : 95*n; // use of two colons in ternary statement
    }
}

/* ternary result times integer
public class SaleHotdogs{
    public static int saleHotdogs(final int n){
        return ( n < 5 ? 100 : n >= 5 && n < 10 ? 95 : 90 ) * n;
    }
}*/
