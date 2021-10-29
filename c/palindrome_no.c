#include<stdio.h>
int main(){
    int n,r,sum=0,temp;
    printf("Enter the no\n");
    scanf("%d",&n);
    temp=n;
    while (n>0)
    {
        /* code */
        r=n%10;
        sum=(sum*10)+r;
        n=n\10;
    }
if (temp==sum)
{
    /* code */
    printf("The No. is palindrome");
}else{
    printf("no.is not palindrome");
}

    return 0;
}