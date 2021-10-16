// C program for coin change problem.
#include <stdio.h>

// this function uses the space complexity O(m*n)
int coinChange(int S[], int m, int n)
{
    int i, j, x, y;

    // We need n+1 rows as the table is constructed
    // in bottom up manner using the base case 0
    // value case (n = 0)
    int table[n + 1][m];

    // Fill the entries for 0 value case (n = 0)
    for (i = 0; i < m; i++)
        table[0][i] = 1;

    // Fill rest of the table entries in bottom
    // up manner
    for (i = 1; i < n + 1; i++)
    {
        for (j = 0; j < m; j++)
        {
            // Count of solutions including S[j]
            x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;

            // Count of solutions excluding S[j]
            y = (j >= 1) ? table[i][j - 1] : 0;

            // total count
            table[i][j] = x + y;
        }
    }
    return table[n][m - 1];
}

// this function uses the space complexity O(n)
int coinChange2(int S[], int m, int n)
{
    // table[i] will be storing the number of solutions for
    // value i. We need n+1 rows as the table is constructed
    // in bottom up manner using the base case (n = 0)
    int table[n + 1];
    // Initialize all table values as 0
    memset(table, 0, sizeof(table));
    // Base case (If given value is 0)
    table[0] = 1;
    // Pick all coins one by one and update the table[] values
    // after the index greater than or equal to the value of the
    // picked coin
    for (int i = 0; i < m; i++)
        for (int j = S[i]; j <= n; j++)
            table[j] += table[j - S[i]];
    return table[n];
}

// Driver program to test above function
int main()
{
    int arr[] = {1, 2, 3};
    int m = sizeof(arr) / sizeof(arr[0]);
    int n = 4;
    printf(" %d ", coinChange(arr, m, n));
    return 0;
}
