/*Q19.Convert a non-negative integer num to its English words representation.
    Input: num = 123
    Output: "One Hundred Twenty Three"
    Input: num = 1234567891
    Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty
    Seven Thousand Eight Hundred Ninety One" */

package q_19;
import java.util.Scanner;

public class DigitToWord {
    public static void main(String[] args)
    {   long n;
        NumbersInWords num= new NumbersInWords();
        Scanner ic= new Scanner(System.in);
        try{
            n=ic.nextLong();
        }
        finally{
            ic.close();
        }
        System.out.println(num.numberToWords(n));
    }
}
class NumbersInWords{
    String[] oneword = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] multipleoften = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    String[] poweroften = { "", "Thousand", "Million", "Billion" , "Trillion" , "Quadrillion" ,"Quintillion"};

    public String numberToWords(long digit ){
        if (digit== 0)
            return "Zero";
        String result = "";
        int i = 0;
        while (digit > 0) {
            if (digit% 1000 != 0) {
                result = solve(digit % 1000) + poweroften[i] + " " + result;
            }
            digit/= 1000;
            i++;
        }
        return result.trim();
    }

    public String solve(long digit) {
        if (digit== 0)
            return "";
        if (digit< 20) {
            return oneword[(int)(digit % 20)] + " ";
        } else if (digit< 100) {
            return multipleoften[(int)(digit / 10)] + " " + solve(digit% 10);
        } else {
            return oneword[(int)(digit / 100)] + " Hundred " + solve(digit % 100);
        }
    }

}
