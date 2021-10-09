import java.util.Scanner;

class calculatorOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the operation");
        String prob = sc.nextLine().replaceAll(" ", "");
        float f;
        int i;

        // this code can take an arthematic operation as string and parse the substrings
        // into numbers and follow the operation requested this obeys different types of
        // arthematic operations
        try {
            if (prob.contains("+") && prob.indexOf("+") > 0) {
                if (prob.contains(".")) {
                    f = Float.parseFloat(prob.substring(0, prob.indexOf("+")))
                            + Float.parseFloat(prob.substring(prob.indexOf("+") + 1, prob.length()));
                    System.out.println(f);
                } else {
                    i = Integer.parseInt(prob.substring(0, prob.indexOf("+")))
                            + Integer.parseInt(prob.substring(prob.indexOf("+") + 1, prob.length()));
                    System.out.println(i);
                }
            }

            if (prob.contains("-") && prob.indexOf("-") > 0) {
                if (prob.contains(".")) {
                    f = Float.parseFloat(prob.substring(0, prob.indexOf("-")))
                            - Float.parseFloat(prob.substring(prob.indexOf("-") + 1, prob.length()));
                    System.out.println(f);
                } else {
                    i = Integer.parseInt(prob.substring(0, prob.indexOf("-")))
                            - Integer.parseInt(prob.substring(prob.indexOf("-") + 1, prob.length()));
                    System.out.print(i);
                }
            }

            if (prob.contains("*") && prob.indexOf("*") > 0) {
                if (prob.contains(".")) {
                    f = Float.parseFloat(prob.substring(0, prob.indexOf("*")))
                            * Float.parseFloat(prob.substring(prob.indexOf("*") + 1, prob.length()));
                    System.out.println(f);
                } else {
                    i = Integer.parseInt(prob.substring(0, prob.indexOf("*")))
                            * Integer.parseInt(prob.substring(prob.indexOf("*") + 1, prob.length()));
                    System.out.println(i);
                }
            }

            if (prob.contains("/") && prob.indexOf("/") > 0) {
                if (prob.contains(".")
                        | Float.parseFloat(prob.substring(0, prob.indexOf("/"))) < Float
                                .parseFloat(prob.substring(prob.indexOf("/") + 1, prob.length()))
                        | Float.parseFloat(prob.substring(prob.indexOf("/") + 1, prob.length())) == 0.0) {

                    if (Float.parseFloat(prob.substring(prob.indexOf("/") + 1, prob.length())) == 0.0)
                        System.out.println("∞-infinity");
                    else {
                        f = Float.parseFloat(prob.substring(0, prob.indexOf("/")))
                                / Float.parseFloat(prob.substring(prob.indexOf("/") + 1, prob.length()));
                        System.out.println(f);
                    }
                } else {
                    i = Integer.parseInt(prob.substring(0, prob.indexOf("/")))
                            / Integer.parseInt(prob.substring(prob.indexOf("/") + 1, prob.length()));
                    System.out.println(i);
                }
            }
        } catch (Exception e) {

        }

        sc.close();
    }
}