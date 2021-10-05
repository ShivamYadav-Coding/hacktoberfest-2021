fun selectionSort(arr: IntArray) {
    val lastIndex: Int = arr.size - 1

    for (i in 0..(lastIndex - 1)) {
        var minIndex = i

        for (j in (i+1)..lastIndex) {
            if(arr[minIndex] > arr[j]) {
                minIndex = j
            }	
        }

        val temp = arr[minIndex]
        arr[minIndex] = arr[i]
        arr[i] = temp
    }
}

fun printArray(arr: IntArray) {
    val lastIndex: Int = arr.size - 1;
    for (i in 0..lastIndex) {
        val num = arr[i]
            print("$num ")
    }
    println("")
}

fun main(args: Array<String>) {
    val arr: IntArray = intArrayOf(15, 3, 12, 6, -9, 9, 0);
    print("Before Sorting: ")
    printArray(arr)

    selectionSort(arr)
    print("After Sorting: ")
    printArray(arr)
}

