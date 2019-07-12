package src;

import java.util.ArrayList;

import static java.lang.Math.max;

public class assign6 {

    // this function returns an arraylist that consists of the indexes of the itmes that were taken.
    static ArrayList knapsack(int W, int w[], int v[], int n){
        int [][]K = new int [n+1][W+1];

        for(int i = 0; i <= n; i++){
            for(int x = 0; x<=W; x++){
                if(i == 0 || x == 0){
                    K[i][x] = 0;
                }
                else if(w[i-1] <= x){
                    K[i][x] = max(v[i-1] + K[i-1][x-w[i-1]], K[i-1][x]);
                }
                else{
                    K[i][x] = K[i-1][x];
                }
            }
        }
        int x = W;
        int res = K[n][W];
        ArrayList ans = new ArrayList();
        for (int i = n; i > 0 && res > 0; i--) {
            if (res == K[i - 1][x])
                continue;
            else {
                ans.add(i-1);
                res = res - v[i - 1];
                x = x - w[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));
    }
}

