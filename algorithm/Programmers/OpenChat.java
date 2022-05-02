// 프로그래머스 오픈채팅방
// https://programmers.co.kr/learn/courses/30/lessons/42888
// 문제 풀이 방법: 해시
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        int cnt = 0, idx = 0;
        Map<String, String> id = new HashMap<>(); // userId 저장하는 Map
        
        for(String str : record) {
            String[] arr = str.split(" ");
            if("Enter".equals(arr[0]) || "Change".equals(arr[0])) {
                id.put(arr[1], arr[2]);
            }
            if("Enter".equals(arr[0]) || "Leave".equals(arr[0])) {
                cnt++;
            }
        }
        answer = new String[cnt];
        
        for(int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            String uId = id.get(arr[1]);
            if("Enter".equals(arr[0])) {
                answer[idx] = uId + "님이 들어왔습니다.";
                idx++;
            } else if("Leave".equals(arr[0])) {
                answer[idx] = uId + "님이 나갔습니다.";
                idx++;
            }
        }
        return answer;
    }
}