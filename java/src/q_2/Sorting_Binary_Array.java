/*Q2. Write a Java program to sort a given binary array in linear times.
        Linear time: An algorithm is said to take linear time, or O(n) time, if its time complexity is O(n). Informally, this means that the running time increases at most linearly with the size of the input. More precisely, this means that there is a constant c such that the running time is at most cn for every input of size n. For example, a procedure that adds up all elements of a list requires time proportional to the length of the list, if the adding time is constant, or, at least, bounded by a constant.
        Example:
        Input :
        b_nums[] = { 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 }
        Output:
        After sorting: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] */
package q_2;
import java.util.Arrays;
public class Sorting_Binary_Array {
    public static void sort (int [] A){

        int pivot = 1;
        int j = 0;

//        Each time we encounter a 0 'j' is incremented and 0 is placed before the pivot
        for (int i = 0; i < A.length; i++){
            if (A[i] < pivot){
                swap(A, i, j);
                j++;
            }
        }

    }

    //    Utility function to swap elements at two indices in the given array
    private static void swap(int [] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int [] A = {0, 1, 0, 0, 1, 1, 1, 0, 1, 0};
        sort(A);

        System.out.println(Arrays.toString(A));
    }
}



