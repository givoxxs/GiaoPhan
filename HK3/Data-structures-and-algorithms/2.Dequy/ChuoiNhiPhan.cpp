#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void Try(int K, string current, vector<string>& result) {
    if (K == 0) {
        result.push_back(current);
        return;
    }

    if (current.empty() || current.back() == '0') {
        Try(K - 1, current + '0', result);
        Try(K - 1, current + '1', result);
    } else {
        Try(K - 1, current + '0', result);
    }
}

int main() {
    int K;
    cin >> K;

    vector<string> result;
    Try(K, "", result);

    sort(result.begin(), result.end());

    for (const string& s : result) {
        cout << s << " ";
    }

    return 0;
}
