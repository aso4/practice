using System;
using System.Collections.Generic;
using System.IO;
class Solution {
    static void Main(String[] args) {
        int n;
        string input, name, phoneNum;

        n = Convert.ToInt32(Console.ReadLine());
        Dictionary<string, string> phoneBook = new Dictionary<string, string>();

        for(int index = 0; index < n; ++index)
        {
            input = Console.ReadLine();
            string[] keyAndValue = input.Split(' ');
            name = keyAndValue[0];
            phoneNum = keyAndValue[1];
            phoneBook.Add(name, phoneNum);
        }

        for(int index = 0; index < n; ++index)
        {
            name = Console.ReadLine();
            if(phoneBook.ContainsKey(name) == true)
                Console.WriteLine("{0}={1}",name, phoneBook[name]);
            else
                Console.WriteLine("Not found");
        }
    }
}
