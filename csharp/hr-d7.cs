using System;
using System.Collections.Generic;
using System.IO;
class Solution {
    static void Main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
        int n = Convert.ToInt32(Console.ReadLine());
        Dictionary<string, string> phonebook = new Dictionary<string, string>();
        List<string> names = new List<string>();

        for (int i = 0; i < n; i++) {
            string line = Console.ReadLine();
            int index = line.IndexOf(" ");
            phonebook.Add(line.Substring(0, index), line.Substring(index + 1, 8));
        }
        
        for (int i = 0; i < n; i++) {
            names.Add(Console.ReadLine());
        }

        foreach(KeyValuePair<string, string> item in phonebook) {
            if (names.Contains(item.Key)) {
                Console.WriteLine(item.Key + "=" + item.Value);
            } else {
                Console.WriteLine("Not found");
            }
        }
    }
}
