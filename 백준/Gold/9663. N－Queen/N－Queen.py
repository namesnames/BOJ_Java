# https://seongonion.tistory.com/103
# 퀸은 자기 주변가장자리 + 좌우 끝까지 + 대각선 끝까지 움직일 수 있다
# 따라서 기본적으로 같은 행에 2개 이상의 퀸이 존재할 수가 없음
# 첫 번째 행부터 놓고 재귀로 계속 행 내려가면서 진행
# 여기에 놔도 되는지 체크하는 possible함수
# 그리고 dfs함수

N = int(input())

def possible(r):
    for j in range(r): # r행보다 위의 행을 체크
        if(row[r] == row[j] or abs(row[r]-row[j]) == abs(r - j)): # r행의 i열에 퀸을 뒀는데 다른 행의 i열에 퀸이 있는지 체크하는 것 + 대각선도
            return False
    return True
    
    
def backtracking(r): # 이 x는 행을 의미
    global ans
    if(r == N): # N번째 까지 내려갔다면 답을 찾은 것!
        ans += 1
        return
    
    for i in range(N): #일단 퀸을 놔야지
        row[r] = i
        if(possible(r)): # r행의 i열에 퀸을 뒀는데 r행보다 위에 있는 행들에는 i열에 퀸이 있는지 체크하는 것 + 대각선도
            backtracking(r+1) # 다음 행 진행해보기
        
row = [0 for _ in range(N)] # row[r] = i 는 퀸을 [r,i]에 뒀다고 생각하면 된다
ans = 0
backtracking(0) # 0행부터 시작
print(ans)