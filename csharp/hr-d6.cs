using System;
using System.Collections.Generic;
using System.IO;
class Solution {
    static void Main(String[] args) {
        int numLines;
        numLines = int.Parse(Console.ReadLine());
        string a;
        string b;

        for (int i = 0; i < numLines; i++) {
            string s = Console.ReadLine();
            a = "";
            b = "";

            for (int j = 0; j < s.Length; j++) {
                if (j % 2 == 0) {
                    a += s[j];
                } else {
                    b += s[j];
                }
            }

            Console.Write($"{a} {b}\n");
        }
    }
}
