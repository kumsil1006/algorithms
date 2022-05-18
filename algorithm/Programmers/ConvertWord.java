// 프로그래머스 깊이/너비 우선 탐색(DFS/BFS) 단어 변환
// https://programmers.co.kr/learn/courses/30/lessons/43163#

import java.util.*;

class Solution {
    List<String> wordArr;
    int[] ch;
    int L = 0;
    public int solution(String begin, String target, String[] words) {
        int answer = 0, len = words.length;
        wordArr = new ArrayList<>();
        ch = new int[len+1];
        boolean flag = false;
        
        wordArr.add(begin);
        
        // target이 list에 있는지 확인
        for(int i = 1; i <= len; i++) {
            wordArr.add(words[i-1]);
            if(words[i-1].equals(target)) {
                flag = true;
            }
        }        
        
        if(!flag) {
            return answer;
        }

        ch[0] = 1;
        DFS(0, target);
        return L;
    }
    public void DFS(int idx, String target) {
        String curr = wordArr.get(idx);
        int max = -1, mIdx = 0;
        if(curr.equals(target)) {
            return ;
        }
        
        for(int i = 0; i < wordArr.size(); i++) {
            int cnt = count(curr, wordArr.get(i));
            int cnt2 = count(wordArr.get(i), target);
            if(ch[i] != 1 && cnt == curr.length()-1 && max < cnt2) {
                // 가장 유사도가 높은 것을 찾아서 DFS 진행할 수 있도록 체크
                max = cnt2;
                mIdx = i;               
            }
        }
        if(mIdx != 0) {
            ch[mIdx] = 1;
            DFS(mIdx, target);
            L++;
        }
    }
    // 동일한 위치에 동일한 알페벳이 있는지 count
    public int count(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int cnt = 0;
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] == arr2[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}