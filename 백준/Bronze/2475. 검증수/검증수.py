a,b,c,d,e = map(int,input().split())
sum = (a**2) + (b**2) + (c**2) + (d**2) + (e**2)
remain = sum % 10
print(remain)