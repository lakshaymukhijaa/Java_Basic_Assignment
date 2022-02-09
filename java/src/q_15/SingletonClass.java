//Q15. WAP to create a singleton class.
package q_15;
public class SingletonClass {
    public static void main(String[] args)
    {
        FormationOfSingletonClass value1= FormationOfSingletonClass.get();
        FormationOfSingletonClass value2= FormationOfSingletonClass.get();
        FormationOfSingletonClass value3= FormationOfSingletonClass.get();
        System.out.println("value1: "+ value1.str + "\nvalue2: "+ value2.str +"\nvalue3: "+ value3.str);
    }
}

class FormationOfSingletonClass {
    private static FormationOfSingletonClass single = null;
    public String str;

    private FormationOfSingletonClass() {
        str = "singleton class String";
    }

    public static FormationOfSingletonClass get() {
        if (single == null)
            single = new FormationOfSingletonClass();

        return single;
    }
}
