# BOJ 9012번 괄호

k = int(input())

def solution(str):
  stack = []
  for j in str:
    if j == '(':
      stack.append('(')
    elif len(stack) > 0:
      stack.pop()
    elif len(stack) == 0:
      return 'NO'
  
  if len(stack) > 0:
    return 'NO'

  return 'YES'

for i in range(k):
  str = input()
  print(solution(str))

