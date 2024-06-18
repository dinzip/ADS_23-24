#include <bits/stdc++.h>
using namespace std;
bool ch(int n){
    for(int i=2; i*i<=n; i++)
        if(n%i==0) return false;
    return true;
}
int solve(int n){
    int num = 2, cnt = 0;
    for(; n>=0 ; num++){
        if(ch(num)){
            cnt++;
            if(ch(cnt)) n--;
        }
    }
    return num-1;
}
int main(){
    // freopen("test.txt", "w", stdout);
    int n;
    cin >> n;
    cout << solve(n);
}