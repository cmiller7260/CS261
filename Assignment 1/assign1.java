

public class assign1 {

    public static void main(String[] args) {
	  fibit(49);
    }

    public static int fib (int x){
        if(x == 0){
            return 0;
        }
        else if(x == 1){
            return 1;
        }
        else{
            return fib(x-1)+fib(x-2);
        }
    }
    public static int fibithelper (int n, int a, int b){
        if(n == 0){
            return a;
        }
        else if(n == 1){
            return b;
        }
        else{
            System.out.println("added");
            return fibithelper(n-1, b, a+b);
        }
    }
    public static void fibit (int n){
        System.out.println(fibithelper(n,0,1));
    }
}
