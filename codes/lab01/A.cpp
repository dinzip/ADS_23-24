#include <bits/stdc++.h>
using namespace std;
// using namespace std::chrono;
#define pb push_back
int main(){
    // freopen("PPP3.txt", "r", stdin);
    // freopen("PPP2.txt", "w", stdout);
    int t;
    cin >> t;
    // auto start = high_resolution_clock::now();
    while(t--){
        int n;
        cin >> n;
        vector<int>v;
        for(int i=n; i>0; i--){
            v.pb(i);
            int r_l = i%v.size(); // rotate left
            rotate(v.begin(), v.begin() + r_l, v.end());
        }
        for(vector<int>::reverse_iterator rit = v.rbegin(); rit != v.rend(); rit++)
            cout << *rit << ' ';
        cout << '\n';
    }
    // auto stop = high_resolution_clock::now();
    // auto duration = duration_cast<microseconds>(stop - start);
 
    // cout << "\n\nTime taken by function: "
    //      << duration.count() << " microseconds" << endl;
}