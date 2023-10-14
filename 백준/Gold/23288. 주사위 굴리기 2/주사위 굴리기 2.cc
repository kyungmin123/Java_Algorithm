#include<iostream>
#include<vector>
#include<queue>
#include<string.h>

using namespace std;

#define MAX 21
#define endl "\n"

int dice[6] = { 1, 6, 4, 3, 5, 2 }; // 상, 하, 좌, 우, 앞, 뒤
int Map[MAX][MAX];
bool visited[MAX][MAX];

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int N, M, K;

int x = 1, y = 1;
int direction = 0;

void Update_Dice(int dir) {
    int up, down, left, right, front, back;
    up = dice[0];
    down = dice[1];
    left = dice[2];
    right = dice[3];
    front = dice[4];
    back = dice[5];

    if (dir == 0) {
        dice[0] = left;
        dice[1] = right;
        dice[2] = down;
        dice[3] = up;
    }
    else if (dir == 1) {
        dice[0] = back;
        dice[1] = front;
        dice[4] = up;
        dice[5] = down;
    }
    else if (dir == 2) {
        dice[0] = right;
        dice[1] = left;
        dice[2] = up;
        dice[3] = down;
    }
    else if (dir == 3) {
        dice[0] = front;
        dice[1] = back;
        dice[4] = down;
        dice[5] = up;
    }
}

void Move_Dice() {
    int nx = x + dx[direction];
    int ny = y + dy[direction];

    if (nx < 1 || nx > M || ny < 1 || ny > N) {
        direction = (direction + 2) % 4;
        nx = x + dx[direction];
        ny = y + dy[direction];
    }

    Update_Dice(direction);
    x = nx;
    y = ny;
}

void Update_Dir() {
    if (dice[1] > Map[y][x]) {
        direction = (direction + 1) % 4;
    }

    else if (dice[1] < Map[y][x]) {
        direction = (4 + direction - 1) % 4;
    }
}

void Input() {
    cin >> N >> M >> K;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            cin >> Map[i][j];
        }
    }
}

int Get_Multiple() {
    int score = Map[y][x];
    int cnt = 1;

    memset(visited, false, sizeof(visited));

    visited[y][x] = true;
    queue<pair<int, int>> q;
    q.push(make_pair(y, x));
    
    int nx, ny;
    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];

            if (nx < 1 || nx > M || ny < 1 || ny > N) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            if (Map[ny][nx] == score) {
                q.push(make_pair(ny, nx));
                cnt++;
            }

        }
    }


    return cnt;
}

int Solution() {
    int score = 0;
    for (int i = 0; i < K; i++) {
        Move_Dice();
        score += Map[y][x] * Get_Multiple();
        Update_Dir();
    }

    return score;
}

int main() {
    Input();
    int answer = Solution();

    cout << answer << endl;
}