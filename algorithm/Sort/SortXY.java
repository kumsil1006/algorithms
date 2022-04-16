// 7. 좌표 정렬
import java.util.*;

public class Main {

  public int[][] solution(int n, int[][] arr) {
    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0] == o2[0]) return o1[1] - o2[1];
        else return o1[0] - o2[0];
      }
    });
    return arr; 
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Main t = new Main();
    int n = in.nextInt();
    int[][] arr = new int[n][2];
    
    for(int i = 0; i < n; i++) {
      arr[i][0] = in.nextInt();
      arr[i][1] = in.nextInt();
    }
    for(int[] i : t.solution(n, arr)) {
      System.out.print(i[0] + " " + i[1] + "\n");
    }
    return ;
  }
}