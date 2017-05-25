#include <stdio.h>

#include <iostream>

using namespace std;
int main(int argc, char const *argv[])
{
	int arr[10];
	//insertion
	for (int i = 0; i < 10; ++i)
	{
		/* code */
		cin >> arr[i];
	}
	//serching
	printf("enter element\n");
	int a;
	cin >> a;
	for (int i = 0; i < 10; ++i)
	{
		if(arr[i] == a) {
			cout << "found" << endl;
		}
	}
	
	return 0;
}