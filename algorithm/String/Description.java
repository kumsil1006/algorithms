// 12. 암호 해독
import java.util.*;

public class Main {
  public String solution(int n, String str) {
    String answer = "";
    int start = 0, end = 7;

    for(int i = 0; i < n*7; i+=7) {
      String tmp = "";
      for(int j = 0; j < 7; j++) {
        if(str.charAt(i+j) == '*') {
          tmp += "0";
        } else {
          tmp += "1";
        }
      }
      answer += (char) Integer.parseInt(tmp, 2);
    }
    
    return answer;
  }

  public static void main(String[] args){
    Main T = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    String str = in.next();
    
    System.out.println(T.solution(n, str));

    return ;
  }
}
