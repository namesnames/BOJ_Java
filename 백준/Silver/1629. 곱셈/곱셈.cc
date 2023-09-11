#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll func(ll a, ll b, ll c) {

	
	if (b == 1)
		return a % c;
	else if (b % 2 == 0) {
		return (func(a, b / 2, c) * func(a, b / 2, c)) % c;
	}
	else if (b % 2 == 1) {
		b = b - 1;
		ll t;
		t= (func(a, b / 2, c) * func(a, b / 2, c)) % c;
		return (t * (a % c)) % c;
	}


}

int main() {

	ll a, b, c;
	cin >> a >> b >> c;
	cout << func(a, b, c);
}