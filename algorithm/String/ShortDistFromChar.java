// 10. 가장 짧은 문자거리
import java.util.*;
  
public class Main {
  public String solution(String str, String t) {
    String answer = "";
    char target = t.charAt(0);
    int d = 101;
    int[] dis = new int[str.length()];
    boolean first = true;

    for(int i = 0; i < str.length(); i++) {
      if(str.charAt(i) == target) d = 0;
      else d += 1;
      
      dis[i] = d;
    }

    d = 101;
    // 가장 가까운 거리 찾기 위해 역으로 반복문 한 번 더 돌기!
    for(int i = str.length()-1; i >= 0; i--) {
      if(str.charAt(i) == target) d = 0;
      else d += 1;

      if(dis[i] > d) {
        dis[i] = d;
      }      
    }

    for(int i : dis) {
      if(!first) {
        answer += " ";
      }
      answer += i;
      first = false;
    }

    return answer;
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    String str = in.next();
    String t = in.next();
    System.out.println(m.solution(str, t));
    return ;
  }
}