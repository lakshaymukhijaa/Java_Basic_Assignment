//Q8.Write a program to print your Firstname, LastName & age using static block, static method & static variable respectively
package q_8;
class Name {

    static int age = 21;


    static String lastName() {
        return "boss";
    }

    static {
        String firstname = "Alpha";
        System.out.println("Firstname is:" + firstname);
    }

    public class UseOfStatic {
        public static void main(String[] args) {
            System.out.println("Lastname is :" + Name.lastName() + "\nage is :" + Name.age);
        }
    }
}

