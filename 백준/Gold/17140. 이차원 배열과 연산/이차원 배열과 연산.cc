#include<iostream>
#include<vector>
#include<cmath>
#include<algorithm>

using namespace std;

#define MAX 101
#define endl "\n"

int Map[MAX][MAX];
int Number_Cnt[MAX];
int row = 3;
int col = 3;
int R, C, K;

void Input() {
    cin >> R >> C >> K;
    
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            cin >> Map[i][j];
        }
    }
}

int Solution() {
    int second = 0;

    while (second < MAX) {
        if (Map[R][C] == K) {
            return second;
        }
        vector<int> Size;

        if (row >= col) {
            for (int i = 1; i <= row; i++) {
                vector<pair<int, int>> cnt_number;
                fill_n(Number_Cnt, MAX, 0);

                for (int j = 1; j <= col; j++) {
                    Number_Cnt[Map[i][j]]++;
                }

                for (int j = 1; j < MAX; j++) {
                    if (Number_Cnt[j] != 0 ){
                        cnt_number.push_back(make_pair(Number_Cnt[j], j));
                    }
                }
                sort(cnt_number.begin(), cnt_number.end());

                for (int j = 1; j <= col; j++) {
                    Map[i][j] = 0;
                }

                int idx = 1;
                for (int j = 0; j < cnt_number.size(); j++) {
                    Map[i][idx++] = cnt_number[j].second;
                    Map[i][idx++] = cnt_number[j].first;
                }

                Size.push_back(--idx);
            }
            sort(Size.begin(), Size.end());
            col = Size.back();
        }
        else {
            for (int i = 1; i <= col; i++) {
                vector<pair<int, int>> cnt_number;
                fill_n(Number_Cnt, MAX, 0);

                for (int j = 1; j <= row; j++) {
                    Number_Cnt[Map[j][i]]++;
                }

                for (int j = 1; j < MAX; j++) {
                    if (Number_Cnt[j] != 0) {
                        cnt_number.push_back(make_pair(Number_Cnt[j], j));
                    }
                }
                sort(cnt_number.begin(), cnt_number.end());

                for (int j = 1; j <= row; j++) {
                    Map[j][i] = 0;
                }

                int idx = 1;
                for (int j = 0; j < cnt_number.size(); j++) {
                    Map[idx++][i] = cnt_number[j].second;
                    Map[idx++][i] = cnt_number[j].first;
                }

                Size.push_back(--idx);
            }
            sort(Size.begin(), Size.end());   
            row = Size.back();
        }

        second++;
    }


    return -1;
}

int main() {
    Input();
    int answer = Solution();

    cout << answer << endl;
}