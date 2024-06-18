#include <bits/stdc++.h>
using namespace std;
int main(){
    // freopen("PPP3.txt", "r", stdin);
    int n;
    string s;
    cin >> n >> s;
    int stK = 0, stS = 0;
    while(s.size() > 1){
        int start_size = s.size();
        string s2 = "";
        for(char i:s){
            if(i == 'K'){
                if(stS > 0) stS--;
                else{
                    stK++;
                    s2 += "K";
                }
            }
            else{
                if(stK > 0) stK--;
                else{
                    stS++;
                    s2 += "S";
                }
            }
        }
        s = s2;
        if(s.size() == start_size) break;
    }
    cout << (s[0] == 'K' ? "KATSURAGI" : "SAKAYANAGI");
}