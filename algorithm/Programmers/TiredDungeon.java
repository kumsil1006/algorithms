// 프로그래머스 피로도[lv2]
// https://programmers.co.kr/learn/courses/30/lessons/87946
// 문제 풀이 아이디어: 순열

import java.util.*;

class Solution {
    private int[][] dungeons;
    private int first = 0; // 현재 피로도 (최초)
    private boolean[] visited;
    private int N = 0;
    private int result = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.first = k;
        this.visited = new boolean[dungeons.length];
        this.N = dungeons.length;
        int[] output = new int[N];
        
        permutation(0, output);
        
        return result;
    }
    // 순서
    public void permutation(int depth, int[] output) {
        if(depth == N) {
            int[] order = new int[N];
            for(int i = 0; i < N; i++) {
                order[i] = output[i];
            }
            
            int cnt = check(order);
            if(cnt > this.result) {
                this.result = cnt;
            }
            
            return ;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                permutation(depth+1, output);
                visited[i] = false;
            }
        }
    }
    
    // 체크
    public int check(int[] order) {
        int curr = this.first;
        int cnt = 0;
        for(int i : order) {
            if(dungeons[i][0] > curr) {
                return cnt;
            }
            
            curr -= dungeons[i][1];
            cnt += 1;
        }
        return cnt;
    }
}