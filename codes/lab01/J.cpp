#include <bits/stdc++.h>
using namespace std;
void coutdeq(deque<int>d){
    cout << "DEQ: ";
    while(!d.empty()){
        cout << d.front() << ' ';
        d.pop_front();
    }
    cout<<'\n';
}
int main(){
    // freopen("PPP3.txt", "r", stdin);
    char c;
    int x;
    deque<int>deq;
    while(cin >> c && c != '!'){
        if(c == '*'){
            if(deq.empty()) cout << "error\n";
            else{
                cout << deq.front() + deq.back() << '\n';
                deq.pop_front();
                if(!deq.empty()) deq.pop_back();
            }
        }
        else cin >> x;
        if(c == '+') deq.push_front(x);
        else if(c == '-') deq.push_back(x);
        // coutdeq(deq); // use for checking current deq after each operation   
    }
}