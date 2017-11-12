using System;
using System.Linq;

class Difference {
    private int[] elements;
    public int maximumDifference;

    // Add your code here
    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        int min = Int32.MaxValue;
        int max = Int32.MinValue;
        foreach (int n in elements) {
            if (n < min){
                min = n;
            }
            if (n > max){
                max = n;
            }
        }
        this.maximumDifference = Math.Abs(max - min);
    }
  } // End of Difference Class

  class Solution {
      static void Main(string[] args) {
          Convert.ToInt32(Console.ReadLine());

          int[] a = Console.ReadLine().Split(' ').Select(x=>Convert.ToInt32(x)).ToArray();

          Difference d = new Difference(a);

          d.computeDifference();

          Console.Write(d.maximumDifference);
      }
  }
