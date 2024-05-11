N = int(input())

arr = []
for _ in range(N):
    arr.append(int(input()))
   
arr.sort()
ans = []
for i in range(len(arr)):
    ans.append(arr[i] * (len(arr)-i))

print(max(ans))
