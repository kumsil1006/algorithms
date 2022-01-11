class Solution {
    public int solution(String dartResult) {
        int[] score_arr = new int[3];
        int star = 0;
        int idx = 0;
        
        for(int i = 0; i < 3; i++) {
            int score = dartResult.charAt(idx) - '0';
            char bonus = dartResult.charAt(idx+1);
            if(bonus == '0') {
                score = 10;
                idx += 1;
                bonus = dartResult.charAt(idx+1);
            }
            char option = idx + 2 >= dartResult.length() ? '-' : dartResult.charAt(idx+2);
            
            if(bonus == 'D') {
                score_arr[i] = (int) Math.pow(score, 2);
            } else if(bonus == 'T') {
                score_arr[i] = (int) Math.pow(score, 3);
            } else {
                score_arr[i] = score;
            }
            
            if(option == '-') {
                continue;
            } else if(option == '*') {
                score_arr[i] *= 2;
                if(i > 0) {
                    score_arr[i-1] *= 2;
                }           
                idx += 3;
            } else if(option == '#') {
                score_arr[i] *= -1;
                idx += 3;
            } else {
                idx += 2;
            }
        }
        
        return score_arr[0] + score_arr[1] + score_arr[2];
    }
}