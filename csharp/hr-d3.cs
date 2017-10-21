using System;
using System.Collections.Generic;
using System.IO;


class Person {
    public int age;
	public Person(int initialAge) {
        // Add some more code to run some checks on initialAge
        age = initialAge;
        if (age < 0) {
            Console.Write("Age is not valid, setting age to 0.\n");
            age = 0;
        }
     }
     public void amIOld() {
        // Do some computations in here and print out the correct statement to the console
         // Console.Write("amIOld: " + age);
         if (age >= 13 && age < 18) {
             Console.Write("You are a teenager.\n");
         } else if (age < 13) {
             Console.Write("You are young.\n");
         } else {
             Console.Write("You are old.\n");
         }
     }

     public void yearPasses() {
        // Increment the age of the person in here
         age++;
     }

     static void Main(String[] args) {
             int T=int.Parse(Console.In.ReadLine());
             for (int i = 0; i < T; i++) {
                 int age=int.Parse(Console.In.ReadLine());
                 Person p=new Person(age);
                  p.amIOld();
                     for (int j = 0; j < 3; j++) {
                       p.yearPasses();
                     }
                     p.amIOld();
                     Console.WriteLine();
             }
         }
     }
