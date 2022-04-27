## 알고리즘 문제 풀이
- 비슷한 문제들
  
__1. BFS (최단 경로 찾기)__
  > - FindCow.java
> - FindSis.java
> - Maze.java
> - GroupNumber.java
> - *가는 방법에 따른 자식 노드 찾는 반복문 필요*
> - 단, Maze.java(미로찾기)의 경우 L 대신 ch로 거리 표현함

```
while(!q.isEmpty()) {
  int len = q.size();
  for(int i = 0; i < len; i++) {
    int x = q.poll();
    if(x == e) return L;
    for(int j = 0; j < 3; j++) {
      int nx = x + dis[j]; // 가는 방법에 따른 자식 노드 찾기
      // 유효한 범위에 있고, 방문한 적 있는지 체크
      if(nx>=1 && nx <= 10000 && ch[nx] == 0) {
          ch[nx] = 1;
          q.add(nx);
      }
    }
  }
  L++;
}

```



  
