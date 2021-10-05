//Insertion sort Implementation using Javascript

// Function to sort an array using insertion sort
function insertionSort(arr, n)
{
	let i, key, j;
	for (i = 1; i < n; i++)
	{
		key = arr[i];
		j = i - 1;

		/* Move elements of arr[0..i-1], that are
		greater than key, to one position ahead
		of their current position */
		while (j >= 0 && arr[j] > key)
		{
			arr[j + 1] = arr[j];
			j = j - 1;
		}
		arr[j + 1] = key;
	}
}

// function to print an array of size n
function printArray(arr, n)
{
	let i;
	for (i = 0; i < n; i++)
		document.write(arr[i] + " ");
	document.write("<br>");
}

	let arr = [12, 11, 13, 5, 6 ];
	let n = arr.length;

	insertionSort(arr, n);
	printArray(arr, n);
	
// The output of the code will be [5, 6, 43, 55, 63, 234, 235, 547]