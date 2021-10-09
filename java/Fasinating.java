import java.util.Scanner;

class Fascinating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt(), count = 0;

        if (num >= 123) {

            String facinating = Integer.toString(num) + Integer.toString(2 * num) + Integer.toString(3 * num);

            for (int i = 1; i < 10; i++)
                if (facinating.contains(Integer.toString(i)))
                    count++;
            if (count == 9)
                System.out.println("Fascinating");

        } else {
            System.out.println("Not Fascinating");
        }
        sc.close();
    }
}