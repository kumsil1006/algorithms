// 프로그래머스 그래프 가장 먼 노드
// https://programmers.co.kr/learn/courses/30/lessons/49189?language=java
// 풀이 방법: BFS
import java.util.*;

class Solution {
    int[] ch, distance;
    List<List<Integer>> graph;
    int L = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ch = new int[n+1];
        graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // 간선 연결된 부분 체크
        for(int[] arr : edge) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        
        ch[1] = 1;
        BFS(1, n);
        
        for(int i : distance) {
            if(i+1 == L) {
                answer++;
            }
        }
        return answer;
    }
    public void BFS(int x, int n) {
        distance = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        
        while(!q.isEmpty()) {
            int len = q.size();
            for(int k = 0; k < len; k++) {
                int nx = q.poll();
                distance[nx] = L;
                List<Integer> list = graph.get(nx);
                for(int i = 0; i < list.size(); i++) {
                    int curr = list.get(i);
                    if(ch[curr] == 0) {
                        q.add(curr);
                        ch[curr] = 1;
                    }
                }
            }
           L++; 
        }
    }
    
}