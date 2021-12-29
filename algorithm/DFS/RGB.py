# 백준 10026: 적록색약
import sys

def dfs(x, y, k):
  if x <= -1 or x >= n or y <= -1 or y >= n:
    return False
  
  if graph_1[x][y] == k: # 이미 방문한 곳이 아니라면
    graph_1[x][y] = '0'
    dfs(x-1, y, k)
    dfs(x+1, y, k)
    dfs(x, y+1, k)
    dfs(x, y-1, k)
    return True

  return False

def dfs2(x, y, k):
  if x <= -1 or x >= n or y <= -1 or y >= n:
    return False
  
  if graph_2[x][y] == k:
    graph_2[x][y] = '0'
    dfs2(x-1, y, k)
    dfs2(x+1, y, k)
    dfs2(x, y+1, k)
    dfs2(x, y-1, k)
    return True

  return False  

n = int(input())
graph_1 = []
graph_2 = []
visited = [[False] * n for _ in range(n)]

for line in sys.stdin:
  l = list(line)
  l2 = list(map(lambda x:'1' if x == 'B' else '2', l))
  if len(l) <= 1:
    break
  graph_1.append(l[:-1])
  graph_2.append(l2[:-1])

result = [0, 0]
colors = ['R', 'G', 'B']
colors2 = ['1', '2']

for k in colors:
  for i in range(n):
    for j in range(n):
      if dfs(i, j, k) == True:
        result[0] += 1
        
for k in colors2:
  for i in range(n):
    for j in range(n):
      if dfs2(i, j, k) == True:
        result[1] += 1

print(result[0], result[1])
