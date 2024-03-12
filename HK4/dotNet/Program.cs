// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using _22N11;

namespace dotNet
{
    public class Program
    {
        public static void Main() 
        {
            SV s1 = new SV {
                MSSV = 1, Name = "Van_Toan" , DTB = 9.0
            };
            SVCNTT s2 = new SVCNTT {
                MSSV = 2, Name = "Giao_Phan" , DTB = 8.0, LT = true
            };
            // s1.Show();
            Console.WriteLine(s1.ToString());
            Console.WriteLine(s2.ToString());
        }
    }
}