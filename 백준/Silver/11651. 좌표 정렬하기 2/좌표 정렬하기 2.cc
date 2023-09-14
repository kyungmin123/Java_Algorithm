#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool compare(const pair<int, int> &a, const pair<int, int> &b) {
    if (a.second  != b.second) {
        return a.second < b.second;
    } else {
        return a.first < b.first;
    }
}

int main() {
    int N;
    vector<pair<int, int>> v;

    cin >> N;

    while (N--) {
        int x_pos, y_pos;

        cin >> x_pos >> y_pos;

        v.push_back({x_pos, y_pos});
    }

    sort(v.begin(), v.end(), compare);

    for (auto p : v) {
        cout << p.first << " " << p.second << "\n";
    }
}