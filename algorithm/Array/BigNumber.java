// 1. 큰 수 출력하기

import java.util.*;
  
public class Main {
  public List<Integer> solution(int n, int[] arr) {
    List<Integer> list = new ArrayList<>();

    list.add(arr[0]);
    
    for(int i = 1; i < n; i++) {
      if(arr[i] > arr[i-1]) list.add(arr[i]);
    }

    return list;
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int input = in.nextInt();
    int[] inArr = new int[input];
    
    for(int i = 0; i < input; i++) {
      inArr[i] = in.nextInt();  
    }
    
    int idx = 0;

    for(int i : m.solution(input, inArr)) {
      if(idx != 0) System.out.print(" ");
      System.out.print(i);
      idx += 1;
    }
    return ;
  }
}