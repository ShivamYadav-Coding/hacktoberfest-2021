//Merge Sort Implementation using JavaScript


//This is the function which takes in two arrays,merges it and returns the Merged Array.
const merge = (arr1,arr2) =>{

    const result = [];  //This stores the Merged array of the passed two arrays.

    while(arr1.length && arr2.length){  

        if(arr1[0]>arr2[0]){        
            result.push(arr2.shift());
        }
        else{
            result.push(arr1.shift());
        }
    }

    while(arr1.length){
        result.push(arr1.shift());
    }

    while(arr2.length){
        result.push(arr2.shift());
    }

    return result;
}

//This is the MergeSort function which does the recursive method
// of dividing the array into two parts and sorts the array.

const mergeSort = (arr) =>{

    if(arr.length<2){
        return arr;             //If the passed array size is less than two, then passing the same array since there are only <=1 elements
    }

    const mid = Math.floor(arr.length/2);
    const left_part = arr.slice(0, mid);
    const right_part = arr.slice(mid,arr.length);
    const sorted_left = mergeSort(left_part);
    const sorted_right = mergeSort(right_part);

    return merge(sorted_left, sorted_right);

}

let a = [432,124,22,1,2,55];    //Test Example

console.log(mergeSort(a));      // The Output will be: [1,2,22,55,124,432];