/*Q22.Check Digits. Credit cards usually have a so-called check digit. This is a single digit that I assigned when the account number is developed and has a special property. One particularly simple mechanism is to assign the last digit of the sum of all the other digits. For example, suppose we have a nine-digit account number (including the check digit). The check digit would be the sum of the eight digits. This digit could be placed any where’s in the sequence, say the
third digit. As a full example, suppose the eight numbers are 12345678. Their sum is 36; thus, 6 is the check digit. The account number is therefore 126345678. Write a program to read in a nine digit integer from the keyboard and check it for these rules. Write"okay" or "not okay" for the results of the test. */
package q_22;
import java.util.Scanner;
public class CheckDigit {
    public static void main(String args[]) {
        int digitarr[]=new int[9];
        int i,Sum=0,n;
        Scanner ic = new Scanner(System.in);
        System.out.println("Enter a nine digit integer:");
        for(i=0;i<9;i++)
        {
            digitarr[i]=ic.nextInt();
            Sum+=digitarr[i];
        }
        for(i=0;i<9;i++)
        {
            digitarr[digitarr[i] %9]= digitarr[digitarr[i] % 9]+9;
        }
        int checkdigit=0;
        for (i = 0; i <9; i++)
        {
            if (digitarr[i] >= 9*2)
                checkdigit=i;
        }
        n=(Sum-checkdigit)%10;
        if(checkdigit==n)
            System.out.println("Okay");
        else
            System.out.println("Not Okay");
    }
}