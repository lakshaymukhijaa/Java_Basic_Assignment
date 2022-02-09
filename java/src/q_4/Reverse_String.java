//Q4.Write a Java Program to reverse a string without using String inbuilt function.
package q_4;
import java.util.Scanner;

public class Reverse_String {
    public static void main(String[] args) {
        System.out.println("Enter your string:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Reversed String is:");
        System.out.println(reverse(str));
    }

    static String reverse(String str) {
        String rev = "";
        for (int i = str.length(); i > 0; --i) {
            rev = rev + (str.charAt(i - 1));
        }
        return rev;
    }
}
