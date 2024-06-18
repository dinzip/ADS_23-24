#include <bits/stdc++.h>
using namespace std;
int main(){
    // freopen("PPP3.txt", "r", stdin);
    int n;
    string s;
    cin >> n >> s;
    int stK = 0, stS = 0, numK=0, numS=0;
    queue<char>q;
    for(char i:s){
        q.push(i);
        numK += (i=='K');
        numS += (i=='K');
    }
    while(!q.empty() && numK>0 && numS>0){
        if(q.front() == 'K'){
            if(stS > 0){
                numK--;
                stS--;
            }
            else{
                stK++;
                q.push(q.front());
            }
        }
        else{
            if(stK > 0){
                numS--;
                stK--;
            }
            else{
                stS++;
                q.push(q.front());
            }
        }
        q.pop();
    }
    cout << (q.front() == 'K' ? "KATSURAGI" : "SAKAYANAGI");
}