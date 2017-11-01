using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static void Main(String[] args) {
        int[][] arr = new int[6][];
        int max = Int32.MinValue;
        int temp = 0;
        for(int arr_i = 0; arr_i < 6; arr_i++){
           string[] arr_temp = Console.ReadLine().Split(' ');
           arr[arr_i] = Array.ConvertAll(arr_temp,Int32.Parse);
        }

        for(int i = 0; i < 4; i++){
           for (int j = 0; j < 4; j++) {
               temp = arr[j][i] + arr[j][i+1] + arr[j][i+2] +
                   arr[j+1][i+1] + arr[j+2][i] + arr[j+2][i+1] +
                   arr[j+2][i+2];
               if (temp > max) {
                   max = temp;
               }
           }
        }
        Console.Write(max);
    }
}
