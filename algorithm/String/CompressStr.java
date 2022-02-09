// 11. 문자열 압축
import java.util.*;
  
public class Main {
  public String solution(String str) {
    String answer = "";
    int cnt = 1, len = str.length();

    for(int i = 0; i < str.length()-1; i++) {
      if(str.charAt(i) == str.charAt(i+1)) {
        cnt++;
      } else {
        answer = cnt == 1 ? answer + str.charAt(i) : answer + str.charAt(i) + cnt;
        cnt = 1;
      }
    }
    answer = cnt == 1 ? answer + str.charAt(len-1) : answer + str.charAt(len-1) + cnt;
    return answer;
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    String str = in.next();
    System.out.println(m.solution(str));
    return ;
  }
}