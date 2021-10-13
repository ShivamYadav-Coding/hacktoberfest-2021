#include <bits/stdc++.h>
using namespace std;

int power(int a, int p, int m)
{
    //this program is used to calculate the power (a^p)%m

    int res = 1;
    while (p > 0)
    {
        if (p & 1)
            res = (res * a) % m;
        a = (a * a) % m;
        p = p >> 1;
    }
    return res;
}

int main()
{
    int a, b;
    cin >> a >> b;
    int mod = 1e9 + 7;
    int ans = power(a, b, mod);
    cout << ans << "\n";
    return 0;
}