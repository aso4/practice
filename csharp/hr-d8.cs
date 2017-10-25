using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static int factorial(int n) {
        int result;
        
        if (n == 1) {
            return 1;
        } else {
            for (int i = n; i > 0; i--) {
                result = i * n;
            }
            // result = n * factorial(n--);
            // Console.WriteLine("result: " + result);
        }
        return result;
    }

    static void Main(String[] args) {
        int n = Convert.ToInt32(Console.ReadLine());
        int result = factorial(n);
        Console.WriteLine(result);
    }
}
