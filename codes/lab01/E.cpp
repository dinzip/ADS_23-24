#include <bits/stdc++.h>
using namespace std;
int main(){
    deque<int>bor, nurs;
    int n = 5, x;
    for(int i=0; i<n; i++){
        cin >> x; 
        bor.push_back((x==0?10:x));
    }
    for(int i=0; i<n; i++){
        cin >> x;
        nurs.push_back((x==0?10:x));
    }
    int step = 0;
    while(step <= 1e6 && !bor.empty() && !nurs.empty()){
        if(bor.front() > nurs.front()){
            bor.push_back(bor.front());
            bor.push_back(nurs.front());
        }    
        else{
            nurs.push_back(bor.front());
            nurs.push_back(nurs.front());
        }
        bor.pop_front();
        nurs.pop_front();
        step++;
    }
    if(nurs.empty()) cout << "Boris " << step;
    else if(bor.empty()) cout << "Nursik " << step;
    else cout << "blin nichya";
}

// 1 4 5 8 9
// 2 3 6 7 0 case of draw