function isStrong(n) {
    //code here
    let newarry = []
    const numToSeparate = n;
    const arrayOfDigits = Array.from(String(numToSeparate), Number);
    console.log(arrayOfDigits);
    arrayOfDigits.forEach((element) => {
        let factorial = fact(element)
        newarry.push(factorial)
    })
    let totalnum = newarry.reduce((total, element) => {
        return total + element
    }, 0)
    if (totalnum == n) {
        return 1
    } else {
        return 0
    }
}
//console.log(isStrong(145)) 