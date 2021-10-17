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
