package interview;

public class Fibonacci {
    public static void main(String[] args) {
    fibo(1);
    fibo(2);
    fibo(5);
    fibo(6);


    }
    public static void fibo (int n){
        int n1 = 1;
        int n2 = 1;
        for (int i =3;i<=n;i++){
            int temp = n1 + n2;
            n1 = n2;
            n2= temp;
        }
        System.out.println(n2);
    }
}
