#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
    int N;
    vector<pair<int, int>> v;

    cin >> N;

    while (N--) {
        int first, second;

        cin >> first >> second;

        v.push_back({first, second});
    }

    sort(v.begin(), v.end());

    for (auto p : v) {
        cout << p.first << " " << p.second << "\n";
    }

    return 0;
}