//Q16. WAP to show object cloning in java using cloneable and copy constructor both.
package q_16;
import java.util.Scanner;

public class ObjectCloning implements Cloneable {
    String EmpName;
    int EmpSalary;
    ObjectCloning(String EmpName , int EmpSalary){
        this.EmpName = EmpName;
        this.EmpSalary = EmpSalary;
    }
    //copy Constructor
    ObjectCloning(ObjectCloning Emp){
        Emp.EmpName = EmpName;
        Emp.EmpSalary = EmpSalary;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public static void main(String[] args) {
        String EmppName;
        int EmppSal;
        Scanner ic = new Scanner(System.in);
        System.out.println("Enter Employee Name And his/her Salary:");
        try{
            EmppName = ic.nextLine();
            EmppSal = ic.nextInt();
        }
        finally{
            ic.close();
        }
        ObjectCloning ocl = new ObjectCloning(EmppName,EmppSal);
        System.out.println(ocl.EmpName + " " + ocl.EmpSalary);

        try {
            ObjectCloning ocl1 = (ObjectCloning)ocl.clone();
            System.out.println(ocl1.EmpName + " " + ocl1.EmpSalary);
        }catch (Exception e) {
            System.out.println(ocl.toString());
        }
    }
}