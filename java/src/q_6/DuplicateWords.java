//Q6. Write a program to find the number of occurrences of the duplicate words in a string and print them?
package q_6;
import java.util.Scanner;
public class DuplicateWords {
    public void toFindDuplicateWord(String str){
        String stringSpliter[] = str.split(" ");
        int i,j,k,len,counter;
        len = stringSpliter.length;
        if(len <= 1)
            System.out.println("Please provide a good length String,Thanks!");
        else{
            k=0;
            for(i=0;i<len;i++){
                counter =1;
                for(j=i+1;j<len;j++){
                    if(stringSpliter[i].equalsIgnoreCase(stringSpliter[j])) {
                        counter++;
                        stringSpliter[j] = "0";
                    }
                }
                if(counter > 1 && stringSpliter[i] != "0"){
                    System.out.println(++k + "." + "Duplicate Word is :" + stringSpliter[i] + " and count of words is:" + counter);
                }
            }
        }

    }
    public static void main(String[] args){
        String str;
        Scanner ic = new Scanner(System.in);
        try{
            System.out.println("Enter a String to find duplicate words:");
            str = ic.nextLine();
        }
        finally{
            ic.close();
        }

        DuplicateWords dup_words = new DuplicateWords();
        dup_words.toFindDuplicateWord(str);
    }
}

