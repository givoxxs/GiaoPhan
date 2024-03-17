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