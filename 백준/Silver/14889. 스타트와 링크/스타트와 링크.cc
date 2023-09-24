#include<iostream>

using namespace std;

bool arr[20];
int N;
int status[20][20];
int minimum = 987654321;

void dfs(int idx, int cnt) {
    if (cnt >= (N / 2)) {
        int start=0;
        int link=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i] == 1 && arr[j] == 1) {
                    start += status[i][j];
                }
                else if (arr[i] == 0 && arr[j] == 0){
                    link += status[i][j];
                }
            }
        }

        minimum = min(abs(start - link), minimum);

        return;
    }
    for (int i = idx + 1; i < N; i++) {
        arr[i] = true;
        dfs(i, cnt + 1);
        arr[i] = false;
    }
}

int main() {

    cin >> N;

    for (int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            cin >> status[i][j];
        }
    }

    for (int i = 0; i < N; i++) {
        arr[i] = true;
        dfs(i, 1);
        arr[i] = false;
    }

    cout << minimum;
}