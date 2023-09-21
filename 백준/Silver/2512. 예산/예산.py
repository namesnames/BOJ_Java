n = int(input())
li = list(map(int,input().split()))
yesan = int(input())

start,end = 0,max(li)

while start <= end:
    Sum = 0
    mid = (start + end) // 2
    for i in li:
        if(i > mid):
            Sum += mid
        else:
            Sum += i
    if(yesan >= Sum):
        start = mid + 1
    else:
        end = mid - 1
print(end)        
    