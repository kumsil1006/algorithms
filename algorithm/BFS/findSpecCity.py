from collections import deque
import sys

n, m, k, x = input().split()
graph = {}
visited = []
distance = []

for line in sys.stdin:
  if len(line) < 2:
    break

  a, b = line.split()
  graph[a] = graph.get(a, []) + [b]


def bfs(a, b):
  q = deque()
  q.append(x) # x: 시작점

  while q:
    n = q.popleft()
    if n is not in visited:
      visited.append(n)
      q.extend(graph[n])

  return True


