#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool compare(pair<int, string> a, pair<int, string> b) {
    if (a.first != b.first) {
        return a.first < b.first;    
    }
}

int main() {
    int N;
    vector<pair<int, string>> v;

    cin >> N;

    while (N--) {
        int age;
        string name;

        cin >> age >> name;
        v.push_back({age, name});
    }

    stable_sort(v.begin(), v.end(), compare);

    for(auto element : v) {
        cout << element.first << " " << element.second << "\n";
    }

    return 0;
}