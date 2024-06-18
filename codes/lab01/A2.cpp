#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
#define pb push_back
int main(){
    // freopen("PPP3.txt", "r", stdin);
    // freopen("PPP2.txt", "w", stdout);
    int t;
    cin >> t;
    auto start = high_resolution_clock::now();
    while(t--){
        int n;
        cin >> n;
        deque<int>d;
        for(int i=n; i>0; i--){
            d.push_front(i);
            int r_R = i%d.size(); // rotate to right r_R times
            while(r_R--){
                d.push_front(d.back());
                d.pop_back();
            }
        }
        while(!d.empty()){
            cout << d.front() << " ";
            d.pop_front();
        }
        cout << '\n';
    }
    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);
 
    // cout << "\n\nTime taken by function: "
    //      << duration.count() << " microseconds" << endl;
}