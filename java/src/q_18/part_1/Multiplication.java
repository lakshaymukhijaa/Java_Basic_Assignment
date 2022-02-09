package q_18.part_1;

// Method references to a static method of a class

import java.util.function.BiFunction;
class Multiply{
    public static int mul(int a, int b){
        return a*b;
    }
}

public class Multiplication {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> product = Multiply::mul;
        int pdt = product.apply(10, 5);
        System.out.println("Product of given number is: "+pdt);
    }
}
