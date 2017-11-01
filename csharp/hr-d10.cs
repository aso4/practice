using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        int n = Convert.ToInt32(Console.ReadLine());
        int remainder = 0;
        int max = 0;
        int temp = 0;
        Stack<string> binary = new Stack<string>();

        while(n > 0) {
            remainder = n%2;
            n = n/2;
            binary.Push(remainder.ToString());
        }

        while (binary.Count > 0) {
            if (binary.Pop().Equals("1")) {
                temp += 1;
            } else {
                temp = 0;
            }

            if (temp >= max) {
                max = temp;
            }
        }

        Console.Write(max);
    }
}
