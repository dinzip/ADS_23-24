#include <bits/stdc++.h>
using namespace std;
int main(){
    int n, x;
    cin >> n;
    stack<int>st;
    while(n--){
        cin >> x;
        while(!st.empty() && st.top() >= x) st.pop(); // here st.top() >= x or >
        if(st.empty()) cout << -1 << ' ';
        else cout << st.top() << ' ';
        st.push(x);
    }
}