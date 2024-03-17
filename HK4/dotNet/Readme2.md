## 1.
```
        public delegate void MyDel(int a, int b);
        public static void Sum(int a, int b) {
            // return a + b;
            Console.WriteLine(a + b);
        }
        public static void Sub(int a, int b) {
            // return a - b;
            Console.WriteLine(a - b);
        }
        public static void TT(int a, int b, MyDel d) {
            d(a,b);
        }
```

```
            MyDel d1 = new MyDel(Sum);
            MyDel d2 = new MyDel(Sub);
            int x1 = d1(2,1);
            int x2 = d1.Invoke(2,1);
            int x3 = TT(2, 1, d1);
            int x4 = TT(2, 1, Sum);
            Console.WriteLine("{0}, {1}, {2}, {3}",x1, x2, x3, x4);

            d1 += new MyDel(Sub);
            d1 += new MyDel(Sub);
            d1 -= new MyDel(Sub);

            d1(2,1);
```
## 2. Delegate 
```
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
```
## 3. 