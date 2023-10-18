n = int(input())
a = [input() for _ in range(n)]

# n = 9
# a = ["noon", "is", "for","lunch","most","noone","waits","until","two"]

# 입력받은 문자들을 인덱스와 함께 사전순으로 정렬한다.
b = sorted(list(enumerate(a)),key = lambda x: x[1])
# b = [(2, 'for'), (1, 'is'), (3, 'lunch'), (4, 'most'), (0, 'noon'), (5, 'noone'), (8, 'two'), (7, 'until'), (6, 'waits')]

# check 함수는 글자 하나하나가 서로 같은지 탐색
def check(a, b):
    cnt = 0
    for i in range(min(len(a), len(b))):
        if a[i] == b[i]: cnt += 1
        else: break
    return cnt

# 최장 접두사를 가진 문자열 담아둘 리스트 생성
length = [0] * (n+1)
maxlength = 0

for i in range(n-1):
    # 인접한 두개의 문자열을  check함수에 대입
    # tmp 값은 동일한 접두사의 길이
    tmp = check(b[i][1], b[i+1][1])
    # 최장 접두사 길이 갱신
    maxlength = max(maxlength, tmp)
    
    # b[i][0]은 문자가 입력된 순서, 즉 인덱스
    # length 에 입력된 순서에 자기 접두사 길이를 저장
    # max 함수로 이전 값하고 현재 값하고 비교하여 집어넣음
    length[b[i][0]] = max(length[b[i][0]], tmp)
    length[b[i+1][0]] = max(length[b[i+1][0]], tmp)
    # length = [4, 0, 0, 0, 0, 4, 0, 0, 0, 0]
    
first = 0
for i in range(n):
    # 입력된 순서대로 접두사의 길이 비교
    if first == 0:
        # 만약 현재 접두사의 길이가 최장접두사라면
        if length[i] == max(length):
            # 제일 먼저 입력된 문자 출력
            first = a[i]
            print(first)
            pre = a[i][:maxlength]
    else:
    	# 다음으로 입력되었된 값들 중 최장 접두사 출력후 종료
        if length[i] == max(length) and a[i][:maxlength] == pre:
            print(a[i])
            break