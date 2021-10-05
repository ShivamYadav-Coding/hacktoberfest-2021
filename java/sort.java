import java.util.*;

public class sort {
    public static void main(String[] args) {
        int a[] = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = Integer.valueOf(args[i]);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++)
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

}
