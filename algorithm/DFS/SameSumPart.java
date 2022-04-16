// 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)

import java.util.*;

public class Main {
    static int n;
    static int result;
    static int[] ch;
    static int[] arr;

    public void DFS(int v) {
        if(v == n+1) {
            // 종착점
            String tmp = "";
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();

            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1) l1.add(arr[i]);
                else l2.add(arr[i]);
            }
            if(check(l1, l2)) {
                result = 1;
                return ;
            }
        } else {
            ch[v] = 1;
            DFS(v+1); // 포함하는 경우
            ch[v] = 0;
            DFS(v+1); // 포함 안 하는 경우
        }
    }
    public boolean check(List<Integer> l1, List<Integer> l2) {
        int sum1 = 0, sum2 = 0;
        for(int i : l1) {
            sum1 += i;
        }
        for(int i : l2) {
            sum2 += i;
        }
        return sum1 == sum2;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main t = new Main();
        n = in.nextInt();
        arr = new int[n+1];
        ch = new int[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        ch[1] = 1;
        t.DFS(1);
        System.out.println(result == 1 ? "YES" : "NO");
        return ;
    }
}