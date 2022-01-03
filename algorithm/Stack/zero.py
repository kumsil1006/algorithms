# BOJ 10773 제로

k = int(input())
stack = []
answer = 0

for i in range(k):
  n = int(input())
  if n == 0:
    num = stack.pop()
    answer -= num
  else:
    stack.append(n)
    answer += n

print(answer)
