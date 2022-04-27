// 프로그래머스 행렬 테두리 회전하기
// https://programmers.co.kr/learn/courses/30/lessons/77485
import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows+1][columns+1];
        int[][] arr2 = new int[rows+1][columns+1];
        int n = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j<= columns; j++) {
                arr[i][j] = n;
                arr2[i][j] = n;
                n++;
            }
        }

        // 회전
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int min = Integer.MAX_VALUE;
            int x1 = query[0], y1 = query[1], x2 = query[2], y2 = query[3];
            int[] lasts = { arr[x1][y2], arr[x2][y2], arr[x2][y1], arr[x1][y1] };
            for(int j = y1; j < y2; j++) {
                if(arr2[x1][j] < min) {
                    min = arr2[x1][j];
                }
                arr[x1][j+1] = arr2[x1][j];
            }
            for(int j = x1; j < x2; j++) {
                if(arr2[j][y2] < min) {
                    min = arr2[j][y2];
                }
                arr[j+1][y2] = arr2[j][y2];
            }
            for(int j = y2; j > y1; j--) {
                if(arr2[x2][j] < min) {
                    min = arr2[x2][j];
                }
                arr[x2][j-1] = arr2[x2][j];
            }
            for(int j = x2; j > x1; j--) {
                if(arr2[j][y1] < min) {
                    min = arr2[j][y1];
                }                
                arr[j-1][y1] = arr2[j][y1];
            }

            
            for(int j=0; j <= rows; j++) {
                for(int k = 0; k <= columns; k++) {
                    arr2[j][k] = arr[j][k];
                }
            }
            answer[i] = min;
            min = Integer.MAX_VALUE;
        }
        
        return answer;
    }
}