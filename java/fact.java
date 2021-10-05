import java.util.Scanner;

class fact {
    public static void main(String[] args) {
        int n, fact = 1;
        System.out.print("Enter any number ");
        Scanner r = new Scanner(System.in);
        n = r.nextInt();

        for (int i = 1; i <= n; i++)

        {
            fact = fact * i;
        }
        System.out.print("factorial " + fact);

    }
}