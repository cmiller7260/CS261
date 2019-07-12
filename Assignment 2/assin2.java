package src;

public class assign2 {

    public static void main(String[] args) {
        fibit(3);
        System.out.println(fibpow(3));
    }

    public static int fib(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return fib(x - 1) + fib(x - 2);
        }
    }

    public static int fibpow(int n){
        if(n == 0){
            return 0;
        }
        int a = 0;
        int b = 1;
        int temp = 0;
        while(n>1){
            n--;
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static int fibithelper(int n, int a, int b) {
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else {
            return fibithelper(n - 1, b, a + b);
        }
    }

    public static void fibit(int n) {
        System.out.println(fibithelper(n, 0, 1));
    }
}






