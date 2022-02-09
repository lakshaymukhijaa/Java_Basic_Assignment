package q_18.part_3;



public interface Vehicle {
    static void display(String name) {
        System.out.println("Vehicle Details :" +name);

    }
    default void run(){

        System.out.println("Vehicle is running");
    }
}
interface VehicleTest{
    public default void run(){

        System.out.println("From Vehicle Test Interface");
    }
}

class Bike implements Vehicle, VehicleTest{
    String name;
    Bike(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Bike is running.... from Vehicle interface");
        System.out.println("Bike is running.... from VehicleTest interface");
    }

    public static void display(String name){
        System.out.println("Bike name : "+name);
    }
}