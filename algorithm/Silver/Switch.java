// 백준 스위치 켜고 끄기
// https://www.acmicpc.net/problem/1244
import java.util.*;

class Main {
  static int[] answer;
  public int[] solution(int n, int t, int[] nums, int[][] cases) {
    answer = new int[n];
    for(int i = 0; i < n; i++) {
      answer[i] = nums[i];
    }
    
    for(int i = 0; i < t; i++) {
      if(cases[i][0] == 1) {
        boys(cases[i][1]);
      } else {
        girls(cases[i][1]);
      }
    }
    
    return answer;
  }

  public void girls(int k) {
    int lt = k-1;
    int rt = k-1;
    boolean flag = false;
    while(lt > 0 && rt < answer.length-1) {
      if(answer[lt-1] == answer[rt+1] && lt-1 >= 0 && rt+1 < n) {
        lt--;
        rt++;
        flag = true; // 대칭 유무
      } else {
        break;
      }
    }

    if(flag) {
      for(int i = lt; i <= rt; i++) {
        answer[i] = answer[i] == 1 ? 0 : 1;
      }
    } else {
      answer[k-1] = answer[k-1] == 1 ? 0 : 1;
    }
  }
  
  public void boys(int k) {
    int n = answer.length;
    for(int i = 0; i < n; i++) {
      if((i+1) % k == 0) {
        answer[i] = answer[i] == 1 ? 0 : 1;
      }
    }
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();
    
    int n = kb.nextInt();
    int[] nums = new int[n];
    
    for(int i = 0; i < n; i++) {
      nums[i] = kb.nextInt();
    }
    int t = kb.nextInt();
    int[][] cases = new int[t][2];

    for(int i = 0; i < t; i++) {
      cases[i][0] = kb.nextInt();
      cases[i][1] = kb.nextInt();
    }
    int cnt = 0;
    for(int i : T.solution(n, t, nums, cases)) {
      System.out.print(i + " ");
      cnt++;
      if(cnt%20 == 0) {
        System.out.println();
      }
    }
  }
}

// 1 0 0 0 1 1 0 1

// 0 1 1 0 1 0 0 0
// 0 1 1 1 0 1 1 0

// 0 0 1 0 1 0 0 0