using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        int n = Convert.ToInt32(Console.ReadLine());
        int remainder;
        string binary;
        
        while(n > 0) {
            remainder = n%2;
            n = n/2;
            binary += remainder.ToString(); // Insert remainder to front of a list or push onto a stack 
        }

        Console.Write(binary);
        // Print list or stack
    }
}
