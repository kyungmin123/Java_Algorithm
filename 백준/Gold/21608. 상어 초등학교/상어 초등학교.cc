#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

#define MAX 21
#define endl "\n";

struct Student {
    int number;
    int friends[4];
};

struct Seat {
    int x;
    int y;
    int nearly_empty;
    int nearly_friends;
};

int N;
int Map[MAX][MAX];
Student students_arr[MAX * MAX];
vector<Student> students_list;


int dx[] = { -1, 1, 0, 0 };
int dy[] = { 0, 0, -1, 1 };

void Input() {
    cin >> N;
    
    for(int i = 0; i < N * N; i++) {
        int student_num;
        int friends_arr[4];

        cin >> student_num;
        
        for (int j = 0; j < 4; j++) {
            cin >> friends_arr[j];
        }

        students_arr[student_num].number = student_num;
        for (int j = 0; j < 4; j++) {
            students_arr[student_num].friends[j] = friends_arr[j];
        }
        
        students_list.push_back({ student_num, { friends_arr[0], friends_arr[1], friends_arr[2], friends_arr[3] } });
    }
}

int compare(Seat a, Seat b) {
    if (a.nearly_friends != b.nearly_friends) {
        return a.nearly_friends > b.nearly_friends;
    }
    else if (a.nearly_empty != b.nearly_empty) {
        return a.nearly_empty > b.nearly_empty;
    }
    else if (a.x != b.x) {
        return a.x < b.x;
    }
    else {
        return a.y < b.y;
    }
}

void Make_Seats() {
    for (int i = 0; i < students_list.size(); i++) {
        vector<Seat> seats;
        int student_num = students_list[i].number;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (Map[x][y] != 0) {
                    continue;
                }

                int nearly_empty = 0;
                int nearly_friends = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (Map[nx][ny] == 0) {
                        nearly_empty++;
                    }
                    else {
                        for (int j = 0; j < 4; j++) {
                            if (students_arr[student_num].friends[j] == Map[nx][ny]) {
                                nearly_friends++;
                                break;
                            }
                        }
                    }
                }
                seats.push_back({ 
                    x = x, 
                    y = y, 
                    nearly_empty = nearly_empty, 
                    nearly_friends = nearly_friends 
                });

            }
        }

        sort(seats.begin(), seats.end(), compare);
        int x = seats[0].x;
        int y = seats[0].y;

        Map[x][y]= student_num;
    }
}

int Get_Score(int friends) {
    if (friends == 0) return 0;
    if (friends == 1) return 1;
    if (friends == 2) return 10;
    if (friends == 3) return 100;
    if (friends == 4) return 1000;
    return -1;
}

int Get_Satisfy() {
    int score = 0;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int student_num = Map[i][j];
            int friends = 0;

            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                for (int l = 0; l < 4; l++) {
                    if (students_arr[student_num].friends[l] == Map[nx][ny]) {
                        friends++;
                        break;
                    }
                }
            }

            score += Get_Score(friends);
        }
    }

    return score;
}

int Solution() {
    Make_Seats();
    int score = Get_Satisfy();

    return score;
}

int main() {
    Input();
    int answer = Solution();

    cout << answer << endl;
}