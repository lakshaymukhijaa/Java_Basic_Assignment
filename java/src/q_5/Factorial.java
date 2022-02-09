/* Q5.First Factorial
        Have the function FirstFactorial(num) take the num parameter being passed and return the factorial of it. For example: if num = 4, then your program should return (4 * 3 * 2 * 1) = 24. For the test cases, the range will be between 1 and 18 and the input will always be an integer.Examples
        Input: 4
        Output: 24
        Input: 8
        Output: 40320 */
package q_5;
import java.util.Scanner;
public class Factorial {
    public long firstFactorial(long num){
        if(num == 0)
            return 1;
        else
            return num * firstFactorial(num-1);
    }

    public static void main(String[] args){
        int number;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter a factorial number:");
            number = sc.nextInt();
        }
        finally{
            sc.close();
        }

        Factorial fact = new Factorial();
        System.out.println(fact.firstFactorial(number));
    }
}

