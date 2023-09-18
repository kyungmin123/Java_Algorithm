#include<iostream>
#include<algorithm>

using namespace std;

int main() {
    int N;
    int maximum = 0;
    cin >> N;

    int * T = new int[N+1];
    int * P = new int[N+1];
    int * dp = new int[N+1];
    fill(dp, dp + N + 1, 0);

    for (int i = 0; i < N; i++) {
        cin >> T[i] >> P[i];
    }

    for (int i = 0; i <= N; i++) {
        dp[i] = max(maximum, dp[i]);
        if (i + T[i] <= N) {
            dp[i + T[i]] = max(dp[i] + P[i], dp[i + T[i]]);
        }
       maximum = max(maximum, dp[i]);
    }

    cout << maximum;
}