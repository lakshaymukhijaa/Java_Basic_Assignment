package q_18.part_1;
public class InstanceMethod {

    @FunctionalInterface
    interface MyInterface {
        void display();
    }

    public static class Arithmetic {

        public void instance_Method() {
            int a = 10;
            int b = 15;
            int sum = a + b;
            int substract = a - b;
            System.out.println("Addition is:" + sum);
            System.out.println("Subtraction is: " + substract);
        }

        public static void main(String[] args) {
            Arithmetic obj = new Arithmetic();

            // Method reference using the object of the class
            MyInterface ref = obj::instance_Method;

            // Calling the method of functional interface
            ref.display();
        }
    }
}


