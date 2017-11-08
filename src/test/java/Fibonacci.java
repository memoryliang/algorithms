import java.math.BigInteger;

public class Fibonacci {

  public static long fib(long n) {
    if(n ==0 || n ==1){
      return 1l;
    }
    return fib(n-1)+ fib(n-2);
  }

  public static void main(String[] args) {
    System.out.println(fib(3) +" " +fib(4) + " " + fib(5) + " " + fib(6) + " " + fib(50));
  }
}
