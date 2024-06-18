#include <bits/stdc++.h>
using namespace std;
bool ch(int n){
    for(int i=2; i*i<=n; i++)
        if(n%i==0) return false;
    return n>1;
}
int main(){
    // freopen("test.txt", "w", stdout);
    int n;
    cin >> n;
    cout << (ch(n)?"YES":"NO");
} 