// Pyramid in C++
#include<iostream>
using namespace std;
char star(int i){
	for(int j=0; j<i; j++){
		cout<<"*";
	}
}
int main(){

	for(int i=0; i<=10; i++)
	{
			star(i);
			cout<<endl;
	}
}


