// // Mã hóa: Ta tìm bản mã của văn bản gốc thông qua công thức y = (a*x + b) mod 26
// // Giải mã: Công thức của hàm giải mã là: x = a^-1*(y - b) mod 26

#include <iostream>
#include <string>
using namespace std;

int check(int a, int b);
string encryptAffine(const string &text, int a, int b), decryptAffine(const string &text, int a, int b);

int main () {
    int a,b;
    cin >> a >> b;
    string input;
    getchar();
    getline(cin, input);
    if (check(a,26) == -1) {
        cout << "Can't Encrypted and Decrypted this Message";
        return 0;
    } else {
        string encrypted = encryptAffine(input, a, b);
        string decrypted = decryptAffine(encrypted, a, b);
        cout << "Encrypted Message is : " << encrypted << endl;
        cout << "Decrypted Message is : " << decrypted << endl;
    }
    return 0; 
}
// ham kiem tra a va a-1
int check(int a, int b) {
    a = a % b;
    for (int x = 1; x < b; x++)
        if ((a * x) % b == 1)
            return x;
    return -1;
}
// Mã hóa đầu vào theo Affine
string  encryptAffine(const string &text, int a, int b) {
    string result = "";
    for (char ch : text) {
        if (isalpha(ch)) {
            char c = isupper(ch) ? 'A' : 'a';
            int x = ch - c;
            int y = (a * x + b) % 26;
            result += static_cast<char>(y + c);
        } else {
            result += ch;
        }
    }
    return result;
}
// Giải mã theo Affine
string decryptAffine(const string& text, int a, int b) {
    int a1 = check(a,26);
    string result = "";
    for (char ch : text) {
        if (isalpha(ch)) {
            char c = isupper(ch) ? 'A' : 'a';
            int y = ch - c;
            int x = (a1 * (y - b + 26)) % 26;
            if (x < 0) x+=26;
            result += static_cast<char>(x + c); 
        } else {
            result += ch;
        }
    }
    return result;
}
