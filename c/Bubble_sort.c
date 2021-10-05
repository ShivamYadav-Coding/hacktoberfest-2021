#include <stdio.h>

int main(){
	int arr[] = { 5, 2, 8, 7, 1 };
	int temp = 0;
	int length = sizeof(arr) / sizeof(arr[0]);

	printf("Original array: \n");
	for (int i = 0; i < length; i++) {
		printf("%d ", arr[i]);
	}

	for (int i = 0; i < length; i++) {
		for (int j = 1; j < length; j++) {
			if (arr[j-1] > arr[j]) {
				temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			}
		}
	}

	printf("\nArray after bubble sort:\n");
	for (int i = 0; i < length; i++) {
		printf("%d ", arr[i]);
	}

	return 0;
}
