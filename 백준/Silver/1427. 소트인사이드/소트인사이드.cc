#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool compare(char a, char b) {
    return a > b;
}

int main() {
    string N;
    cin >> N;

    sort(N.begin(), N.end(), compare);

    cout << N;
}