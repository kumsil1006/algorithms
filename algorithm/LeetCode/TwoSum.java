// LeetCode Two sum
// https://leetcode.com/problems/two-sum/

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                answer[0] = i;
                answer[1] = map.get(nums[i]);
                break;
            } else {
                map.put(target-nums[i], i);
            }
        }
        return answer;
    }
}