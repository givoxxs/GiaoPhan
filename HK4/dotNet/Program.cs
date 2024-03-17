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
        public delegate bool MyDel_SV(object o1, object o2);

        public static void Sort(object[] A, MyDel_SV cmp) {
            for (int i = 0; i < A.Length - 1; i++) 
                for (int j = i + 1; j < A.Length; j++) {
                    // if (A[i].DTB < A[j].DTB) 
                    if (cmp(A[i], A[j]))
                    {
                        object temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                    }
                } 
        }
        public static void Main() 
        {
            SV[] B = new SV[] {
                new SV {MSSV = 1, Name = "NVA", DTB = 3.3},
                new SV {MSSV = 2, Name = "NVB", DTB = 1.1},
                new SV {MSSV = 3, Name = "NVC", DTB = 2.2},
            };
            Sort(B, SV.CompareName);
            foreach (var i in B) 
            {
                Console.WriteLine(i.ToString());
            }
        }
    }
}