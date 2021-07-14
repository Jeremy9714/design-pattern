package principle.singleResponsibility;

/**
 * @author Chenyang
 * @create 2021-07-14-15:31
 */
public class SingleResponsibility {

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
