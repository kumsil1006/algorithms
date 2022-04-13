/* 1. 재귀함수(스택프레임) */
// 재귀함수 -> 자기 자신 호출
// 스택프레임에는 크게 매개변수, 지역변수, 복귀주소 정보를 가지고 있다.
// 백트래킹: 
import java.util.*;

class Main {
  public void DFS(int n) {
    if(n == 0) return;
    else {
      DFS(n-1);
      System.out.println(n);
    }
  }
  public static void main(String[] args) {
    Main T = new Main();
    T.DFS(3);
  }
}