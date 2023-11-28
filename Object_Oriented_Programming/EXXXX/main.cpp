// Câu 30 : result 2
// #include <iostream>
// using namespace std;
// class Base {
//     public:
//         int prop_a;
//         Base();
// };
// Base::Base() : prop_a(1) {}
// class Derived : public Base {
//     public:
//         int prop_b;
//         Derived();
// };
// Derived::Derived() : prop_b(2) {}
// void Func() {
//     Derived obj;
//     throw obj;
// }
// int main() {
//     try {
//         Func();
//     }
//     catch (Derived e) {
//         cout << e.prop_b;
//     }
//     catch (Base e) {
//         cout << e.prop_a;
//     }
//     return 0;
// }

// Câu 29 : result DUT
// #include <iostream>
// using namespace std;
// struct a {
//     int count;
// };
// struct b
// {
//     int* value;
// };
// struct c : public a, public b {};
// int main() {
//     c* p = new c;
//     p->value = 0;
//     cout << "DUT";
//     system("pause");
//     return 0;
// } 

// Câu 28 : result 200
// #include <iostream>
// using namespace std;
// template<typename T>
// T Func(T x, T y) {
//     return x > y ? x : y;
// }
// int main() {
//     int x;
//     x = Func(100, 200);
//     cout << x;
//     return 0;
// } 

// câu 27 : result Runtime Error
// #include <iostream>
// using namespace std;
// class Base {
//     public:
//         virtual void Func();
// };
// void Base::Func() {
//     cout << "Base";
// }
// class Derived : public Base {
//     public:
//         void Func();
// };
// void Derived::Func() {
//     cout << "Derived";
// }
// class DerivedA : public Derived {
//     public:
//         void Func();
// };
// void DerivedA::Func() {
//     cout << "DerivedA";
// }
// class DerivedB : public Derived {
//     public:
//         void Func();
// };
// void DerivedB::Func() {
//     cout << "DerivedB";
// }
// int main() {
//     Base* ptr;
//     DerivedA obj_a;
//     DerivedB obj_b;
//     *ptr = obj_a;
//     ptr->Func();
//     return 0;
// }
 
// câu 26 : result 0
// #include <iostream>
// using namespace std;
// int main() {
//     char* ptr;
//     unsigned long int x = (size_t(0) / 3);
//     cout << x;
//     try {
//         ptr = new char[size_t(0) / 3];
//         delete[] ptr;
//     }    
//     catch (bad_alloc & e) {
//         cout << e.what();
//     };
//     return 0;
// }

// Câu 25 : result 21
// #include <iostream>
// using namespace std;
// template <typename T>
// class Exam {
//     T x;
//     public:
//         static int count;
//         Exam();
//         ~Exam();
// };
// template <typename T>
// int Exam<T>::count = 0;
// template <typename T>
// Exam<T>::Exam() {
//     Exam<T>::count++;
// }
// template <typename T>
// Exam<T>::~Exam() {
// }
// int main() {
//     Exam<int> x;
//     Exam<int> y;
//     Exam<double> z;
//     cout << Exam<int>::count << Exam<double>::count;
//     return 0;
// } 

// Câu 1 : Result 1624
// #include <iostream>
// using namespace std;
// template<class T, class U, class V = double>
// class Exam {
//     T x;
//     U y;
//     V z;
// };
// int main() {
//     Exam<int, int> obj_ii;
//     Exam<double, double> obj_dd;
//     cout << sizeof(obj_ii) << sizeof(obj_dd);
//     return 0;
// } 

// Câu 2 : Result 48AA
// #include <iostream>
// using namespace std;
// template <class T>
// inline T Func(T x) {
//     T result = x + x;
//     return result;
// };
// template <>
// string Func<string> (string str) {
//     return (str + str);
// };
// int main() {
//     int x = 4, y;
//     string str("A");
//     y = Func<int>(x);
//     cout << x << y;
//     cout << Func<string>(str);
//     return 0;
// }

// Câu 4 : Result 0
// #include <iostream>
// using namespace std;
// void Func(const double, const double);
// int main() {
//     double x = 0, y = 10;
//     try {
//         Func(x, y);
//     }
//     catch (const char* e) {
//         cout << e;
//     }
//     return 0;
// }
// void Func(const double x, const double y) {
//     double z;
//     if (y == 0) throw "Error";
//     z = x / y;
//     cout << z;
// }

// Cau 5 : Result 03
// #include <iostream>
// #include <vector>
// using namespace std;
// int main() {
//     vector<int> a(3,0);
//     vector<int> b(5,0);
//     b = a;
//     a = vector<int>();
//     cout << int(a.size()) << int(b.size());
//     return 0;
// }

// Câu 6 : Result 5 5 5 5 0
// #include <iostream>
// #include <algorithm>
// #include <vector>
// using namespace std;
// int main() {
//     vector<int> myvector(5);
//     fill(myvector.begin(), myvector.begin() + 4, 5);
//     fill(myvector.begin() + 3, myvector.end() - 2, 8);
//     for (vector<int> :: iterator it =  myvector.begin();
//         it != myvector.end(); ++it)
//         cout << ' ' << *it;
//     return 0;
// }

// Câu 7 : Result Compile Error
// #include <iostream>
// using namespace std;
// class Base {
//     int _x;
//     public:
//         Base(int x) : _x(x) {
//             cout << "A";
//         }
// };
// class Child : public Base {
//     int _y;
//     public:
//         Child(int x, int y) : _x(x), _y(y) {
//             cout << "B";
//         }
// };
// int main() {
//     Child c1(1, 2);
//     system("pause");
//     return 0;
// }

// Cau 8 : Result 416 / 48
// #include <iostream>
// using namespace std;
// class Test1 {
//     int x;
//     public:
//         void Show();
// };
// void Test1::Show() {}
// class Test2 {
//     int x;
//     public:
//         virtual void Show();
// };
// void Test2::Show() {}
// int main() {
//     cout << sizeof(Test1) << sizeof(Test2);
//     system("pause");
//     return 0;
// }

// Cau 9 : result  10 20 30 20 10
// #include <iostream>
// #include <algorithm>
// #include <vector>
// using namespace std;
// bool myfunction(int i, int j) {
//     return (i == j);
// }
// int main() {
//     int myints[] = {10, 20, 20, 20, 30, 30, 20, 20, 10 };
//     vector<int> myvector(myints, myints + 9);
//     vector<int> ::iterator it;
//     it = unique(myvector.begin(), myvector.end());
//     myvector.resize(distance(myvector.begin(), it));
//     unique(myvector.begin(), myvector.end(), myfunction);
//     for (it = myvector.begin(); it != myvector.end(); ++it)
//         cout << ' ' << *it;
//     return 0;
// }
 
// Cau 10 : result 55
// #include <iostream>
// #include <queue>
// using namespace std;
// int main() {
//     queue<int> myqueue;
//     int sum(0);
//     for (int i = 1; i <= 10; i++) 
//         myqueue.push(i);
//     while (!myqueue.empty()) {
//         sum += myqueue.front();
//         myqueue.pop();
//     }
//     cout << sum << endl;
//     return 0;
// }

// Cau 11 : result Compile Error
// #include <iostream>
// using namespace std;
// void Func_Empty() throw() {
//     cout << "1";
// }
// void Func_Type() throw(int) {
//     cout << "2";
//     throw(1);
// }
// int main() {
//     try {
//         Func_Empty();
//         Func_Type();
//     }
//     catch (int) {
//         cout << "3";
//     }
//     return 0;
// }

// Cau 12 : result
// #include <iostream>
// using namespace std;
// int main() {
//     int i = -12;
//     try {
//         cout << "Inside try" << endl;
//         if (i < 0) {
//             throw i;
//             cout << "After throw" << endl;
//         }
//     }
//     catch (char i) {
//         cout << "Exception Caught" << endl;
//     }
//     cout << "After catch" << endl;
//     return 0;
// }

// Cau 13 : result 6665
// #include "iostream"
// using namespace std;
// class Base {
//     int x, y, z;
//     public:
//         Base() {
//             x = y = z = 0;
//         }
//         Base(int xx, int yy = 'A', int zz = 'B') {
//             x = xx; y = x + yy; z = x + y;
//         }
//         void Display() {
//             cout << x << y << z;
//         }
// };
// class Derived : public Base {
//     int x,y;
//     public:
//         Derived(int xx = 65, int yy = 66) : Base(xx, yy) {
//             y = xx; x = yy;
//         }
//         void Display() {
//             cout << x << y;
//         }
// };
// int main() {
//     Derived objD;
//     objD.Display();
//     system("pause");
//     return 0;
// }
 
// Cau 14 : result BB
// #include <iostream>
// #include <string>
// using namespace std;
// class Base {
//     public:
//         virtual string print() const;
// };
// string Base::print() const {
//     return "B";
// }
// class Derived : public Base {
//     public:
//         virtual string print() const;
// };
// string Derived::print() const {
//     return "D";
// }
// void describe(Base p) {
//     cout << p.print();
// }
// int main() {
//     Base b;
//     Derived d;
//     describe(b);
//     describe(d);
//     system("pause");
//     return 0;
// }

// Cau 15 : result 6default10
// #include <iostream>
// using namespace std;
// template<class T = float, int i = 5> 
// class Exam {
//     public:
//         int prop;
//         Exam();
// };
// template<class T, int i>
// Exam<T, i>::Exam() : prop(i) {
//     cout << this->prop;
// }
// template<>
// class Exam<> {
//     public:Exam();
// };
// Exam<>::Exam() {
//     cout << "default";
// }
// template<>
// class Exam<double, 10> {
//     public:
//         Exam();
// };
// Exam<double, 10>::Exam() {
//     cout << "10";
// }
// int main() {
//     Exam<int, 6> x;
//     Exam<> y;
//     Exam<double, 10> z;
//     return 0;
// }

// Cau 16 : result CB_CD_DB_
// #include <iostream>
// using namespace std;
// class Base {
//     public:
//         Base();
//         ~Base();
// };
// Base::Base() {
//     cout << "CB_";
// }
// Base::~Base() {
//     cout << "DB_";
// }
// class Derived : public Base {
//     public:
//         Derived();
//         ~Derived();
// };
// Derived::Derived() {
//     cout << "CD_";
// }
// Derived::~Derived() {
//     cout << "DD_";
// }
// int main() {
//     Base *Var = new Derived();
//     delete Var;
//     system("pause");
//     return 0;
// }

// Cau 17 : result 1 3 6 10 15 
// #include <iostream>
// #include <functional>
// #include <numeric>
// using namespace std;
// int myop(int x, int y) {
//     return x + y + 1;
// }
// int main() {
//     int val[] = {1, 2, 3, 4, 5};
//     int result[5];
//     partial_sum(val, val + 5, result);
//     for(int i = 0; i < 5; i ++) 
//         cout << result[i] << ' ';
//     return 0;
// }
