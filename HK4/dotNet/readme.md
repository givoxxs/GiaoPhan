```
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks; 
using _22N11;

namespace dotNet
{
    public class dotnet
    {
        /*
        //Vong lap 
        public static void Main()
        {
            string[] A = new string[3];
            for(int i=0;i<3;i++) {
                Console.Write("A[{0}] = ", i);
                A[i] = Console.ReadLine();
            }

            for(int i=0;i<A.Length;i++) {
                Console.Write("A[{0}] = {1}  ",i, A[i]);
            }

            Console.WriteLine();
            foreach(string i in A) {
                Console.Write("{0} ",i);
            }
        } 
        */
        /*
        // Mang 2 chieu
        public static void Main() {
            double[,] matrix = new double[10,10];
            int count = 0;
            for(int i=0;i<10;i++) {
                for(int j=0;j<10;j++) {
                    matrix[i,j] = ++count;
                }
            }

            foreach(double i in matrix) {
                Console.Write("{0} ", i);
            }
        }
        */


        /*
        //Mang thanh phan
        public static void Main() {
            string[][] soft = new string[3][];
            soft[0] = new string[] {"a","b","c"};
            soft[1] = new string[] {"nguyen", "le", "nhat", "tuan"};
            soft[2] = new string[] {"1", "2", "3"};
            foreach(string[] str in soft) {
                foreach(string s in str) {
                    Console.Write("{0}  ", s);
                }
                Console.WriteLine();
            }
        }
        */

        // public static void Main() {
        //    SV s1 = new SV {
        //         MSSV = 1, Name = "NVA", DTB =1.1
        //    };

        //    s1.show();
        //    Console.WriteLine(s1.ToString());

        //    CNTT s2 = new CNTT {
        //         MSSV = 1, Name = "NVA", DTB = 1.1, LT = true
        //    };
           
        //    Console.WriteLine(s2.ToString());
        // }

        public 
        public static void Main() {
            // IFile1 f1 = new MyClass();
            // f1.A1();
            // f1.B1();

            // BClass bc = new BClass();
            // IFile1 f11 = (IFile1) bc;
            // IFile2 f22 = (IFile2) bc;
            // f11.A1(); f11.B1();
            // f22.A2(); f22.B2();

            // TClass tc= new TClass();
            // IFile1 f1 = (IFile1)tc;
            // IFile3 f3 = (IFile3)tc;
            // tc.A1(); tc.B1(); tc.B3();
            // f1.A1(); f3.A1();

            // UClass uc = new UClass();
            // IFile1 f11 = (IFile1)uc;
            // IFile3 f33 = (IFile3)uc;
            // f11.A1(); f33.A1();

            SV s1 = new SV {
                MSSV = 1, Name = "NVA", DTB = 8.2
            };
            SV s2 = new SV {
                MSSV = 2, Name = "NVB", DTB =7.1
            };
            SV s3 = new SV {
                MSSV = 3, Name = "NVC", DTB = 9.1
            };
            SV s4 = new SV {
                MSSV = 4, Name = "NVD", DTB = 5.4
            };
            SV s5 = new SV {
                MSSV = 5, Name = "NVE", DTB =1.1
            };

            QLSV ql = QLSV.Instance;
            ql.Add(s1);
            ql.Add(s2);
            ql.Add(s3);
            ql.Add(s4);
            ql.Add(s5);

            Console.WriteLine(ql.ToString());



        }

        
    }
}
// bien dich chuong trinh: dotnet run
// tao moi: dotnet new console
```