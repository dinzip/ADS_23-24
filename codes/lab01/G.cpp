#include <bits/stdc++.h>
using namespace std;
#define pb push_back
const int mx = 1e4;
int solve(int n){
    vector<int>primes;
    vector<bool>pr(mx+1, false);
    for(int i=2; i*i<=mx; i++){
        if(!pr[i]){
            for(int j=i*i; j<=mx; j+=i) pr[j] = 1;
        }
    }
    for(int i=2; i<mx; i++){
        if(!pr[i]) primes.pb(i);
    }
    return primes[primes[n-1]-1];
}
int main(){
    // freopen("test.txt", "w", stdout);
    int n;
    cin >> n;
    cout << solve(n);
}