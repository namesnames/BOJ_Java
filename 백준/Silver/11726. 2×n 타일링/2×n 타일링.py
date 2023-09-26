arr = [0,1,2,3,5]

N = int(input())
for i in range(5,N+1):
    arr.append(arr[i-1]+arr[i-2])
print(arr[N] % 10007)