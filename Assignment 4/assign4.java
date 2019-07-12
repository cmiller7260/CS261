package src;

import java.util.ArrayList;
import java.util.List;

public class assign4 {

    public static void main(String[] args) {

    }

    static int max2(int a, int b) {
        int x = a - b;
        int y = (x >> 31) & 0x1;
        int max = a - y * x;
        return max;
    }

    static void printArray(int arr[])   // a functon to print an array. used for testing of sorted list
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    static int fSelect(List x, int i){
        if (x.size() < 1){
            System.out.println("Error: bad index");
            return 0;
        }
        int x1 = (int)x.get(0);
        List l = new ArrayList();
        List s = new ArrayList();
        List m = new ArrayList();
        int y=1;
        s.add(x1); // add x
        while(y < x.size()){ // xs
            int y1 = (int)x.get(y);
            if(y1 < x1){
                l.add(y1);
            }
            if(x1 == y1){
                s.add(x.get(y));
            }
            if(y1 > x1){
                m.add(x.get(y));
            }
            y++;
        }
        if(i < l.size()){
            fSelect(l,i);
        }
        else if(l.size() <= i && i < l.size()+s.size()){
            System.out.println("hit the correct end");
            System.out.println((int)x.get(0));
            return (int)x.get(0);
        }
        else{
            fSelect(m,i-(l.size()+s.size()));
        }
        return 0;
    }

    static void printlist(List l){
        System.out.print('[');
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + ", ");
        }
        System.out.print(']');
        System.out.println();
    }

    static int partition(int a[], int l, int h){
        int x = a[l];
        int i = (l+1);
        int j = h;
        while(i <= j){
            if(a[i] <= x){
                i=i+1;
            }
            else if(x<a[j]){
                j=j-1;
            }
            else{
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp = a[l];
        a[l]=a[i-1];
        a[i-1]=temp;
        return i-1;
    }

    static int iSelect(int a[], int i){

        return iSelectHelper(a,i,0,a.length-1);

    }

    static int iSelectHelper(int a[], int i, int l, int h){
            if(i >= 0 && i <= h - l + 1){
                int ans = partition(a, l, h);
                System.out.println("ans : " + ans);
                if(ans - l == i){
                    return a[i];
                }
                else if(ans - l > i){
                    return iSelectHelper(a,i,l,ans-1);
                }
                else {
                    return iSelectHelper(a, i - ans + l,ans + 1, h);
                }

            }
            return 0;
    }
}
