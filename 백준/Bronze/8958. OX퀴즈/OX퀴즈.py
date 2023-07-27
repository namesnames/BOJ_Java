n = int(input())

for i in range(n):
    answer = 0
    cnt = 0
    word = input()
    for j in range(len(word)):
        if(word[j]=="O"):
            cnt += 1
        else:
            cnt = 0
        answer += cnt
    print(answer)

            