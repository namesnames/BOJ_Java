import sys
input = sys.stdin.readline

N = int(input().strip())
arr = []
for _ in range(N):
    a,b = map(int,input().strip().split())
    arr.append((a,b))
    
arr = sorted(arr)
cnt = 1
end = arr[N-1][0] #12

for i in reversed(range(N-1)):
    if(end >= arr[i][1]):
        end = arr[i][0]
        cnt += 1
        
print(cnt)