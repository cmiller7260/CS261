

public class assign3 {

    public static void main(String[] args) {

    }

    static void printArray(int arr[])   // a functon to print an array. used for testing of sorted list
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    static Boolean sortedHasSum(int[] s, int s_len, int x){
        int left = 0;
        int right = s_len-1;
        while(left < right){
            if(s[left] + s[right] == x){
                return true;
            }
            else if (s[left] + s[right] < x){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    static Boolean hasSum(int[] s, int s_len, int x){
        quicksort(s, 0,s_len-1);
        // or
        // return (sortedHasSum(s,s_len,x)?
        int left = 0;
        int right = s_len-1;
        while(left < right){
            if(s[left] + s[right] == x){
                return true;
            }
            else if (s[left] + s[right] < x){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
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

    static void quicksort(int a[], int l, int h){
        if(l<h){
            int pi = partition(a,l,h);
            quicksort(a,l,pi-1);
            quicksort(a,pi+1,h);
        }
    }
}
