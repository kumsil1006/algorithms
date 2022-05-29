// 백준 퇴사
// https://www.acmicpc.net/problem/14501

import java.util.*;

class Main {
  static int n;
  static int[] tArr, pArr, d;
  public int solution() {
    d = new int[n+2];

    for(int i = n; i > 0; i--) {
      int next = i + tArr[i];
      if(next > n+1) {
        d[i] = d[i+1];
      } else {
        d[i] = Math.max(d[next] + pArr[i], d[i+1]);  
      }
    }
    return d[1];
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();
    
    n = kb.nextInt();
    tArr = new int[n+1];
    pArr = new int[n+1];
    
    for(int i = 1; i <= n; i++) {
      tArr[i] = kb.nextInt();
      pArr[i] = kb.nextInt();
    }

    System.out.println(T.solution());
  }
}