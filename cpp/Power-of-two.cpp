/*
Question - 
Given a number n. Print Yes if it is a power of 2 otherwise print NO.
*/


#include<iostream>
using namespace std;


int main() {
	int t ;
	cin >> t;
	while (t--)
	{
		int n;
		cin >> n;
		if(n != 0 && (n & (n-1)) == 0)
			cout<<"YES"<<endl;
		else
			cout<<"NO"<<endl;
	}
	return 0;
}


/*
	Test Cases
	INPUT - 
	3
	16
	3
	32
	OUTPUT - 
	YES
	NO
	YES
*/
