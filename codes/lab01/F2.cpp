#include <bits/stdc++.h>
using namespace std;
bool ch(int n){
    for(int i=2; i*i<=n; i++)
        if(n%i==0) return false;
    return true;
}
int solve(int n){
    int i=2;
    for(; n>0; i++)
        if(ch(i)) n--;
    return i-1;
}
int main(){
    // freopen("test.txt", "w", stdout);
    int n;
    cin >> n;
    cout << solve(n);
}