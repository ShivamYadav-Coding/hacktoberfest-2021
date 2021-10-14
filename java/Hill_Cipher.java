// import java.lang.*;
// import java.util.Scanner;

public class Hill_Cipher
{
    public static void main(String args[])
    {
      String msg = "SAM";
      String key = "PRACTICAL";  

      int keyArr[][] = new int[3][3];
      int k=0;

      for(int i=0;i<3;i++){
        for (int j=0;j<3;j++)
        {
          if(Character.isUpperCase(key.charAt(k)) ) 
            keyArr[i][j] = (int)key.charAt(k++) - 65;
          else if(Character.isLowerCase(key.charAt(k)))
            keyArr[i][j] = (int)key.charAt(k++) - 97;
        }  
      }
         
      int msgArr[] = new int[msg.length()];
      int m = 0;

      for(int i=0;i<msg.length();i++){
        if(Character.isUpperCase(msg.charAt(m))) 
            msgArr[i] = (int)msg.charAt(m++) - 65;
        else if(Character.isLowerCase(msg.charAt(m)))
            msgArr[i] = (int)msg.charAt(m++) - 97;
      }
      
      String encrypt = "";
      for(int i=0;i<3;i++)
      { 
        int sum=0;  
        for(int j=0;j<3;j++){
          sum += keyArr[i][j] * msgArr[j];     
        }
        encrypt += (char)sum%26; 
      }

      
      System.out.println(encrypt);
    }
}
