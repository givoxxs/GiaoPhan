#include <iostream>
#include <string>
using namespace std;

struct Student {
    string fullName;
    float mathScore;
    float literatureScore;
};

// Hàm nhập thông tin học sinh
void inputStudent(Student& student) {
    cout << "Nhập họ và tên học sinh: ";
    cin.ignore();
    getline(cin, student.fullName);
    cout << "Nhập điểm Toán: ";
    cin >> student.mathScore;
    cout << "Nhập điểm Văn: ";
    cin >> student.literatureScore;
}

// Hàm xuất thông tin học sinh
void outputStudent(const Student& student) {
    cout << "Họ và tên: " << student.fullName << endl;
    cout << "Điểm Toán: " << student.mathScore << endl;
    cout << "Điểm Văn: " << student.literatureScore << endl;
}

// Hàm tính điểm trung bình của học sinh
float calculateAverageScore(const Student& student) {
    return (student.mathScore + student.literatureScore) / 2;
}

// Hàm xếp loại học sinh
string classifyStudent(const Student& student) {
    float averageScore = calculateAverageScore(student);
    if (averageScore >= 8.0)
        return "Giỏi";
    else if (averageScore >= 7.0)
        return "Khá";
    else if (averageScore >= 5.0)
        return "Trung bình";
    else
        return "Yếu";
}

int main() {
    int n;
    cout << "Nhập số lượng học sinh: ";
    cin >> n;

    Student students[n];

    // Nhập thông tin học sinh
    for (int i = 0; i < n; i++) {
        cout << "Nhập thông tin học sinh thứ " << i + 1 << ":" << endl;
        inputStudent(students[i]);
    }

    // Xuất thông tin học sinh và xếp loại
    for (int i = 0; i < n; i++) {
        cout << "Thông tin học sinh thứ " << i + 1 << ":" << endl;
        outputStudent(students[i]);
        cout << "Điểm trung bình: " << calculateAverageScore(students[i]) << endl;
        cout << "Xếp loại: " << classifyStudent(students[i]) << endl;
    }

    return 0;
}
