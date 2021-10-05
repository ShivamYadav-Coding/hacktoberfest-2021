#include <stdio.h>
int main()
{
	int i, j, temp;
	int arr[] = { 5,2,8,4,9,3,1,10 };
	
	int n = sizeof(arr) / sizeof(arr[0]);

	printf("Initial array :\n");
	for (i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}

	for (i = 1; i <= n - 1; i++){
		j = i;
		while (j > 0 && arr[j - 1] > arr[j]){
			temp = arr[j];
			arr[j] = arr[j - 1];
			arr[j - 1] = temp;
			j--;
		}
	}

	printf("\nArray after sorting:\n");
	for (i = 0; i <= n - 1; i++){
		printf("%d ", arr[i]);
	}

	return 0;
}
