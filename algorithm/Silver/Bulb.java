// 백준 2138 전구와 스위치
// https://www.acmicpc.net/problem/2138
// 풀이 방법: Greedy
import java.util.*;

class Main {
  static int n, min;
  static String start, end;
  static char[] arr, target;
  public void solution() {
    String curr = start;
    min = Integer.MAX_VALUE;
    arr = curr.toCharArray();
    target = end.toCharArray();

    // 0을 안 누른 경우
    int cnt = action();
    String result= new String(arr);
    if(result.equals(end)) {
      min = cnt;
    }

    // 0을 누른 경우
    arr = curr.toCharArray();
    push(0);
    cnt = action() + 1;
    result = new String(arr);
    if(result.equals(end) && min > cnt) {
      min = cnt;
    }

    int answer = min == Integer.MAX_VALUE ? -1 : min;
    System.out.println(answer);
  }
  public int action() {
    int cnt = 0;
    for(int i = 1; i < arr.length; i++) {
      if(arr[i-1] != target[i-1]) {
        push(i);
        cnt++;
      }
    }
    return cnt;
  }
  public void push(int idx) {
      arr[idx] = arr[idx] == '0' ? '1' : '0';
      if(idx != 0) {
         arr[idx-1] = arr[idx-1] == '0' ? '1' : '0'; 
      }
      if(idx != arr.length-1) {
        arr[idx+1] = arr[idx+1] == '0' ? '1' : '0';
      }
  }
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Main T = new Main();
    
    n = kb.nextInt();

    start = kb.next();
    end = kb.next();

    T.solution();
  }
}