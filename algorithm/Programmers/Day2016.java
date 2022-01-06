// 프로그래머스 2016년

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] arr = new int[13];
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int sum = 0;
        
        for(int i = 1; i < a; i++) {
            if(i == 2) {
                sum += 29;
            } else if((i % 2 == 0 & i < 7) | (i % 2 == 1 & i > 8) ) {
                sum += 30;
            } else {
                sum += 31;
            }
        }
        
        sum += b;       
        answer = day[sum%7];
        
        return answer;
    }
}