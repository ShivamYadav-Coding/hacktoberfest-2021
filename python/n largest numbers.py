#with priority q
import queue  
p=queue.PriorityQueue()
a=[3,1,7,4,9,2]
n=3
for i in range(len(a)):
    p.put(a[i])

    if p.qsize() > n:
        p.get()
    #print(b)
for i in range(p.qsize()):
    print(p.get(), end=" ")
