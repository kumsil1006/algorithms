// 1. 문자 찾기

import java.util.*;

public class Main {
  public int solution(String str, char c) {
    str = str.toLowerCase();
    c = Character.toLowerCase(c);
    int answer = 0;

    for(char x : str.toCharArray()) {
       if(x == c) answer += 1;
    }    
    return answer;
  }

  public static void main(String[] args){
    Main T = new Main();
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    char c = in.next().charAt(0);
    System.out.println(T.solution(str, c));

    return ;
  }
}
