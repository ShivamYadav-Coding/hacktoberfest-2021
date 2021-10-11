import java.util.*;
import java.lang.*;
import java.io.*;

class Fascinating{
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-->0){
		
		    int n = sc.nextInt();
		
		    if(n < 100) {
			    System.out.println("Number should be atleast three digits");
		    }else {
			
			    String p = Integer.toString(n);
			    String q = Integer.toString(n*2);
			    String r = Integer.toString(n*3);
			
			    String str = p+q+r;
			
			    char c[] = str.toCharArray();
			    Arrays.sort(c);
			
			    String a = new String(c);
			    String cmp = "123456789";
			
			    if(a.equals(cmp)){
				    System.out.println("Fascinating");	
			    }else {
				    System.out.println("Not Fascinating");
			    }
		    }
		}
	}
}
