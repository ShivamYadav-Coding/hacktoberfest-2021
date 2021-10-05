'''
Time Complexity:      O(n^2)
Space Complexity:     O(log n)
Contibutor: @whyanujjwhy
'''

# function to find the partition position
def partition(array, low, high):

  # choose the rightmost element as pivot
  pivot = array[high]

  # pointer for greater element
  i = low - 1

  # traverse through all elements
  # compare each element with pivot
  for j in range(low, high):
    if array[j] <= pivot:
      # if element smaller than pivot is found
      # swap it with the greater element pointed by i
      i = i + 1

      # swapping element at i with element at j
      (array[i], array[j]) = (array[j], array[i])

  # swap the pivot element with the greater element specified by i
  (array[i + 1], array[high]) = (array[high], array[i + 1])

  # return the position from where partition is done
  return i + 1

# quicksort algo
def quickSort(array, low, high):
  if low < high:

    # find pivot element such that
    pi = partition(array, low, high)

    # recursive call on the left of pivot
    quickSort(array, low, pi - 1)

    # recursive call on the right of pivot
    quickSort(array, pi + 1, high)


print("Enter elements of array to sort: ")
arr = list(map(int, input().split()))
n = len(arr)
print("Original List:")
print(arr)
quickSort(arr, 0, n - 1)

print('Sorted Array in Ascending Order:')
print(arr)
