class InsertionSort{

	public static void print(int arr[]){
		for (int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+" ");			
		}
		System.out.println();
	}

	public static void main(String[] args) 
	{
		int arr[] = {5,1,9,8,6,7,4,3,2};
		System.out.print("START : ");
		for(int i=1;i<arr.length;i++)
		{
			print(arr);

			int key = arr[i];
			int j =i-1;

			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		System.out.print("END : ");
		print(arr);
	}
}