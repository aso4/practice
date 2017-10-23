using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        int n = Convert.ToInt32(Console.ReadLine());
        string[] arr_temp = Console.ReadLine().Split(' ');
        int[] arr = Array.ConvertAll(arr_temp,Int32.Parse);
        List<int> reversed_arr = new List<int>();

        for (int i = n-1; i > -1; i--) {
            reversed_arr.Add(arr[i]);
        }

        foreach (int number in reversed_arr)
        {
            Console.Write(number + " ");
        }
    }
}
