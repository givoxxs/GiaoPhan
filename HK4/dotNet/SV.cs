// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _22N11
{
    public class SV
    {
        public int MSSV {get; set;}
        public string Name{get; set;}
        public double DTB{get; set;}

        public void Show() {
            Console.WriteLine("MSSV = {0}, Name = {1}, DTB = {2}", MSSV, Name, DTB);
        }

        public override string ToString()
        {
            return "MSSV = " + MSSV + ", Name = " + Name + ", DTB = " + DTB;
        }
        public static bool CompareDTB(object o1, object o2) {
            return ((SV)o1).DTB > ((SV)o2).DTB;
        }
        public static bool CompareName(object o1, object o2) {
            if (String.Compare(((SV)o1).Name, ((SV)o2).Name) > 0) {
                return true;
            } else 
                return false;
        }   
    }
}