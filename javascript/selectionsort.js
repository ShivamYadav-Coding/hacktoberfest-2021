// Bubble sort Implementation using Javascript

// Creating the bblSort function
function selectionSort(inputArr) { 
    let n = inputArr.length;
        
    for(let i = 0; i < n; i++) {
        // Finding the smallest number in the array
        let min = i;
        for(let j = i+1; j < n; j++){
            if(inputArr[j] < inputArr[min]) {
                min=j; 
            }
         }
         if (min != i) {
             // Swapping the elements
             let tmp = inputArr[i]; 
             inputArr[i] = inputArr[min];
             inputArr[min] = tmp;      
        }
    }
    return inputArr;
}


// This is our unsorted array
let inputArr = [5,4,3,2,1];
selectionSort(inputArr);
console.log(inputArr);

// The output of the code will be [1, 2, 3, 4, 5]