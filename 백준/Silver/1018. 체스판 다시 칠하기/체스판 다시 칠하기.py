n,m = map(int,input().split())

str1 = "BWBWBWBW"
str2 = "WBWBWBWB"

pivot1 = [ str1,str2,str1,str2,str1,str2,str1,str2]
pivot2 = [ str2,str1,str2,str1,str2,str1,str2,str1]

adj = []
cnt = []

for _ in range(n):
    adj.append(input())

for a in range(0,n-7):
    for b in range(0,m-7):
        cnt1 = 0
        cnt2 = 0
        for r in range(0,8):
            for c in range(0,8):
                if(adj[r+a][c+b] != pivot1[r][c]):
                    cnt1 += 1
                elif(adj[r+a][c+b] != pivot2[r][c]):
                    cnt2 += 1
        minval = min(cnt1,cnt2)
        cnt.append(minval)          
print(min(cnt))


    




