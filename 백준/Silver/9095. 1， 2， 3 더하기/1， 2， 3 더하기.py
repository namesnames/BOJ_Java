# 주어진 수에서 할 수 있는 방법이 3가지 (1빼기,2빼기,3빼기)가 있고 이전의 결과값을 이용하면 되겠다라고 생ㅇ각
# 즉 DP문제라고 생각했고
# 1일 때, 2일 때, 3일 때 직접 구해보니까 규칙을 찾을 수 있었음

T = int(input())
arr = [0,1,2,4] # 맨 앞의 0은 걍 채우기용
for i in range(4,12):
    arr.append(arr[i-1]+ arr[i-2] + arr[i-3])
    
for _ in range(T):
    num = int(input())
    print(arr[num])