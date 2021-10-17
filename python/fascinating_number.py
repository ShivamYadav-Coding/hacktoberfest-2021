'''Fascinating Number: When a number(should contain 3 digits or more) is multiplied by 2 and 3 ,
and when both these products are concatenated with the original number, 
then it results in all digits from 1 to 9 present exactly once.
N = 192
Output: Fascinating
Explanation: After multiplication with 2 and 3, and concatenating with original number, number will become 192384576 which contains all digits from 1 to 9.

Example 2:

Input:
N = 853
Output: Not Fascinating
Explanation: It's not a fascinating number.
'''
num = int(input())
if num<100:
    print("Number should contain 3 digits or more!")
    exit()
num_str = str(num) + str(num * 2) + str(num * 3)
sorted_num = ''.join(sorted(num_str))
ind_1 = sorted_num.index("1")
result = sorted_num[ind_1:] #slicing the digits except zeroes
if(result == "123456789"):
    print("Fascinating")
else:
    print("Not Fascinating")