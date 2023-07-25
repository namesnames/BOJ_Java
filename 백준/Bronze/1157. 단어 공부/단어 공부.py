word = input().upper()
wordList = list(set(word))

cnt = []
for i in range(len(wordList)):
    cnt.append(word.count(wordList[i]))
max = max(cnt)

if cnt.count(max) != 1:
    print('?')
else:
    print(wordList[cnt.index(max)])