using System;
using System.Collections.Generic;
using System.IO;
class Solution {
    static void Main(String[] args) {
        double mealCost;
        int tipPercent;
        int taxPercent;
        double sum;
        string str;

        mealCost = double.Parse(Console.ReadLine());
        tipPercent = int.Parse(Console.ReadLine());
        taxPercent = int.Parse(Console.ReadLine());

        sum = Math.Round(mealCost + mealCost*Convert.ToDouble(tipPercent)/Convert.ToDouble(100) + mealCost*Convert.ToDouble(taxPercent)/100);
        str = String.Format("The total meal cost is {0} dollars.", sum);
        Console.Write(str);
    }
}
