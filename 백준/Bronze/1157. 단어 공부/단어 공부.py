word = input().upper()
wordListSet = list(set(word)) #list로 안감쌌음

cnt = []
for i in range(len(wordListSet)):  # range 빼먹음
    cnt.append(word.count(wordListSet[i]))
cntMax = max(cnt)

if cnt.count(cntMax) != 1:
    print("?")
else:
    print(wordListSet[cnt.index(cntMax)]) # cntMax라는 값이 cnt의 몇 번째 인덱스에 있을까? cnt.index(cntMax)로 알 수 있음