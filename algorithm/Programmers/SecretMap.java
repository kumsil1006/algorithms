// 프로그래머스 비밀지도

import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // 10진수 --> 2진수 변환
        List<String> list1 = convert(n, arr1);
        List<String> list2 = convert(n, arr2);
        
        // 1 or 2 --> #
        for(int i = 0; i < n; i++) {
            String temp = "";

            for(int j = 0; j < n; j++) {
                if(list1.get(i).charAt(j) == '1' | list2.get(i).charAt(j) == '1') {
                    temp = temp + "#";
                } else {
                    temp = temp + " ";
                }                
            }
            answer[i] = temp;
        }
        return answer;
    }
    
    public List<String> convert(int n, int[] target) {
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            String temp = "";
            
            while(true) {
                temp = Integer.toString(target[i] % 2) + temp;
                target[i] = (int) target[i] / 2;
                if(target[i] < 2) {
                    temp = Integer.toString(target[i]) + temp;
                    break;
                }
            }
            while(temp.length() < n) {
                temp = "0" + temp;
            }
            result.add(temp); 
        }
        
        return result;
    }
}