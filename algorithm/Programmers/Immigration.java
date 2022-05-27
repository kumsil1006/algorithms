// 프로그래머스 입국심사
// https://programmers.co.kr/learn/courses/30/lessons/43238
class Solution {
    public long solution(int n, int[] times) {
        long lt = 0, mid = 0, answer = 0;
        Arrays.sort(times);
        
        long rt = (long) times[times.length-1] * n; // max
        
        while(lt <= rt) {
            mid = (lt + rt) / 2;    
            long cnt = 0;
            for(int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }
            if(cnt >= n) {
                rt = mid-1;
                answer = mid;
            } else {
                lt = mid+1;
            }
        }
        return answer;
    }
}