import java.util.Scanner;

public class primerange {
    public static void main(String[] args) {
        int a, b, i, j;
        System.out.println("Enter the range for prime number ; ");
        Scanner r = new Scanner(System.in);
        a = r.nextInt();
        b = r.nextInt();
        for (i = a; i <= b; i++) {
            for (j = 2; j <= i; j++) {
                if (i % j == 0)
                    break;
            }
            if (i == j)
                System.out.print(j + " ");
        }

    }

}