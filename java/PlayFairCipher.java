import java.util.Scanner;

public class PlayFairCipher {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\nEnter Text: ");
        String text = input.nextLine().toUpperCase();

        System.out.print("\nEnter key: ");
        String key = input.next().toUpperCase();

        char matrix[][] = new char[5][5];
        int x = 0;

        // temp start
        int arr[] = new int[26];
        // temp Over
        int ai = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (x != key.length()) {
                    char ch = key.charAt(x++);
                    matrix[i][j] = ch;
                    arr[(int) ch - 65] = 1;
                } else {
                    while(arr[ai++] != 0);
                    // if(arr[ai] == 0)
                      matrix[i][j] = (char) (ai + 65);
                    ai++;
                }
            
            }
        }

        System.out.println("\nKey Matrix: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println("");
        }
    }
}
