import java.util.Scanner;

public class power {
    public static void main(String[] args) {
        int x, n;
        System.out.print("Enter the number : ");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        System.out.print("Enter the power of  " + x + " :");
        Scanner se = new Scanner(System.in);
        n = se.nextInt();
        System.out.println(x + " raised to power " + n + " =" + power(x, n));
    }

    private static long power(int x, int n) {
        long y = 0;
        if (n == 0)
            return 1;
        else if (n == 1)
            return x;
        else {
            y = power(x, n / 2);
            y = y * y;
            if (n % 2 == 0) {
                return y;
            }
        }
        return x * y;
    }

}
