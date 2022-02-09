//Q17. WAP showing try, multi-catch and finally blocks.
package q_17;
public class TryCatchFinally {
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Try block");
            int arr[]= new int[1];
            arr[1]=1/0;
            System.out.println(arr[1]);
        }

        catch(ArithmeticException e)
        {
            System.out.println("ArithmeticException!");
        }

        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayOutOfBoundException!");
        }

        finally
        {
            System.out.println("finally block");
        }
    }
}
