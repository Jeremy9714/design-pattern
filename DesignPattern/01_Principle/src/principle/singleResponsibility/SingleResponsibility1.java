package principle.singleResponsibility;

/**
 * 单一职责原则
 *
 * @author Chenyang
 * @create 2021-07-14-14:50
 */
public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle car = new Vehicle();
        Vehicle plane = new Vehicle();
        Vehicle ship = new Vehicle();
        car.run("car");
        plane.fly("plane");
        ship.sail("ship");
    }
}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " is running");
    }

    public void fly(String vehicle) {
        System.out.println(vehicle + " is flying");
    }

    public void sail(String vehicle) {
        System.out.println(vehicle + " is sailing");
    }

}