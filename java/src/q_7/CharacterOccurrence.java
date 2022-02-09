//Q7. Write a program to find the number of occurrences of a character in a string without using a loop?
package q_7;
import java.util.Scanner;
public class CharacterOccurrence {
    public int occurrenceOfChar(String strr, char spChar){
        int count = 0;
        if(strr.length() == 0)
            return 0;
        else if(strr.charAt(0) == spChar){
            count ++;
        }
        return count += occurrenceOfChar(strr.substring(1) , spChar);
    }
    public static void main(String[] args) {
        String input_Str ;
        char ch;
        Scanner ic = new Scanner(System.in);
        try{
            System.out.println("Enter String and a special char :");
            input_Str = ic.next();
            ch = ic.next().charAt(0);
        }
        finally{
            ic.close();
        }

        CharacterOccurrence s = new CharacterOccurrence();
        System.out.println("Frequency of given character is:" + s.occurrenceOfChar(input_Str , ch));
    }
}


