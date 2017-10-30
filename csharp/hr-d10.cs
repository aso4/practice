using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        int n = Convert.ToInt32(Console.ReadLine());
        int remainder = 0;
        int max = 0;
        Stack<string> binary = new Stack<string>();
        String s = "";

        while(n > 0) {
            remainder = n%2;
            n = n/2;
            binary.Push(remainder.ToString()); // Insert remainder to front of a list or push onto a stack
            s += remainder.ToString();
        }

        // Console.Write(s);
        s = binary.ToString();
        Console.Write(s);

        while (binary.Count > 0) {
            int temp = 0;
            Console.WriteLine(binary.Peek());
            if (binary.Pop().Equals('1')) {
                temp++;

            } else {
                temp = 0;
            }

            if (temp > max) {
                max = temp;
            }
        }

        Console.Write(max);
    }
}
