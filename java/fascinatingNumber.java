import java.util.Scanner;
public class fascinatingNumber {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean res = isFascinating(num);
        if(res) {
            System.out.println("The number is fascinating");
        }
        else {
            System.out.println("The number is not fascinating");
        }
    }
    public static boolean isFascinating(int num) {
        String s = "";
        int n1 = num * 2;
        int n2 = num * 3;
        s += num;
        s += n1;
        s += n2;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        s = String.valueOf(arr);
        if(s.contains("123456789")) {
            return true;
        }
        else {
            return false;
        }
    }
}