a = int(input())
a_list = list(map(int,input().split()))
b = int(input())
b_list = list(map(int,input().split()))

cnt = {}
for i in a_list:
    if i in cnt:
        cnt[i] += 1
    else:
        cnt[i] = 1
        
for j in b_list:
    if j in cnt:
        print(cnt[j])
    else:
        print(0)
        