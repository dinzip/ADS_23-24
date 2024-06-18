#include <bits/stdc++.h>
using namespace std;
const int mx = 1e4;
int solve(int n){
    vector<bool>pr(mx+1, false);
    for(int i=2; i*i<=mx; i++){
        if(!pr[i]){
            for(int j=i*i; j<=mx; j+=i) pr[j] = 1;
        }
    }
    for(int i=2; i<mx; i++){
        if(!pr[i]){
            n--;
            if(n==0) return i;
        }
    }
    return 0;
}
int main(){
    // freopen("test.txt", "w", stdout);
    int n;
    cin >> n;
    cout << solve(n);
}
// 7919 - 1000th prime