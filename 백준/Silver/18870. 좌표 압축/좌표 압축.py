N = int(input())

arr = list(map(int,input().split()))
arrSet = sorted(set(arr)) # 리스트 먼저 sort하고 set씌우면 순서가 의미가 없어짐 # 왜냐? 애초에 Set이란 순서가 없는 집합을 의미하니까

new = list(arrSet)
D = dict()
for i in range(len(new)):
    D[new[i]] = i

for j in arr:
    print(D[j],end=" ")

    
    