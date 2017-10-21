using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        int N = Convert.ToInt32(Console.ReadLine());

        if(N%2 == 0)
        {
            if(N > 20)
            {
                Console.Write("Not Weird");
            }
            else if(N >= 6 && N <= 20)
            {
                Console.Write("Weird");
            }
            else if(N >= 2 && N <= 5)
            {
                Console.Write("Not Weird");
            }
        }
        else
        {
            Console.Write("Weird");
        }
    }
}
