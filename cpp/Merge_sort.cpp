#include <bits/stdc++.h>
using namespace std;

void Merge(vector<int>& arr, int const start, int const mid, int const end) {
	int const left_size = mid - start + 1;
	int const right_size = end - mid;
	vector<int> left_arr(left_size);
	vector<int> right_arr(right_size);
	for (int i = 0; i < left_size; i++) {
		left_arr[i] = arr[start + i];
	}
	for (int i = 0; i < right_size; i++) {
		right_arr[i] = arr[mid + 1 + i];
	}
	int idx_left = 0, idx_right = 0,idx_merged=start;
	while (idx_left < left_size && idx_right < right_size) {
		if (left_arr[idx_left] <= right_arr[idx_right]) {
			arr[idx_merged] = left_arr[idx_left];
			idx_left++;
		}
		else {
			arr[idx_merged] = right_arr[idx_right];
			idx_right++;
		}
		idx_merged++;
	}
	while (idx_left < left_size) {
		arr[idx_merged] = left_arr[idx_left];
		idx_left++;
		idx_merged++;
	}
	while (idx_right < right_size) {
		arr[idx_merged] = right_arr[idx_right];
		idx_right++;
		idx_merged++;
	}
}

void MergeSort(vector<int>& arr, int const start, int const end) {
	if (start >= end) return;
	int mid = (start + end) / 2;
	MergeSort(arr, start, mid);
	MergeSort(arr, mid + 1, end);
	Merge(arr, start, mid, end);
}

int main() {
	vector<int> arr = { 3,4,9,2,7,1,10,8 };
	int n = arr.size();
	
	cout << "Given array is \n";
	for (int i = 0; i < n; i++)cout << arr[i] << " ";
	cout << '\n';

	MergeSort(arr, 0, n - 1);

	cout << "After Sorting\n";
	for (int i = 0; i < n; i++)cout << arr[i] << " ";
	cout << '\n';

	return 0;
}
