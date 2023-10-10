#include<iostream>
#include<cmath>
#include<vector>

using namespace std; 

struct Pos {
    int x;
    int y;
};

vector<Pos> house_pos;
vector<Pos> chiken_pos;
vector<Pos> picked_pos;
int N, M;
bool selected[13];
int MIN = 987654321;

int Distance(Pos pos1, Pos pos2) {
    return abs(pos1.x - pos2.x) + abs(pos1.y - pos2.y);
}

void Find_Min_Dist() {
    int result = 0;
    for (int i = 0; i < house_pos.size(); i++) {
        int min_dist = 987654321;

        for (int j = 0; j < picked_pos.size(); j++) {
            min_dist = min(min_dist, Distance(house_pos[i], picked_pos[j]));
        }
        result += min_dist;
    }

    MIN = min(MIN, result);    
}

void Find_M_Combination(int idx, int cnt) {
    if (cnt == M) {
        Find_Min_Dist();
    }

    for (int i = idx; i < chiken_pos.size(); i++) {
        if (selected[i] == true) {
            continue;
        }

        selected[i] = true;
        picked_pos.push_back({ chiken_pos[i].x, chiken_pos[i].y });
        Find_M_Combination(i, cnt + 1);
        selected[i] = false;
        picked_pos.pop_back();
    }
}

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int temp;
            cin >> temp;

            if (temp == 1) {
                house_pos.push_back({i, j});
            }
            else if (temp == 2) {
                chiken_pos.push_back({i, j});
            }
        }
    }
    
    Find_M_Combination(0, 0);
    cout << MIN << "\n";

    return 0;
}