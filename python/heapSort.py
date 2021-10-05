'''
Heap sort (max) in python
Time Complexity:    O(nlog n)
Space Complexity:   O(1)

Contributor: @whyanujjwhy
'''

#sorting algo
def heapsort(arr):
  n = len(arr)
  for i in range(n//2, -1, -1):
    heapify(arr, n-1, i)

  for i in range(n-1, -1, -1):
    # swap last element of the max-heap with the first element
    arr[i], arr[0] = arr[0], arr[i]
    
    # exclude the last element from the heap and rebuild the heap 
    heapify(arr, i-1, 0)

# heapify function is used to build the max heap
# max heap has maximum element at the root which means
# first element of the array will be maximum in max heap
def heapify(arr, n, i):
  max, left, right = i, 2*i + 1, 2*i + 2
  # if the left element is greater than root
  if left <= n and arr[left] > arr[max]:
    max = left

  # if the right element is greater than root
  if right <= n and arr[right] > arr[max]:
    max = right

  # if the max is not i
  if max != i:
    arr[i], arr[max] = arr[max], arr[i]
    # Recursively heapify the affected sub-tree
    heapify(arr, n, max) #recursion

#print list
def PrintList(arr):
  for i in arr:
    print(i, end=" ")
  print("\n")
  
# list input and function call   
print("Enter elements of array to sort: ")
arr = list(map(int, input().split()))
n = len(arr)
print("Original List:")
PrintList(arr)

heapsort(arr)
print("Sorted List(Ascending): ")
PrintList(arr)
