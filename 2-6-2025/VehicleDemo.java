// Abstract Vehicle class
abstract class Vehicle {
    protected String model;
    
    public Vehicle(String model) {
        this.model = model;
    }
    
    // Abstract methods
    public abstract void startEngine();
    public abstract void stopEngine();
}

// Car class implementation
class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }
    
    @Override
    public void startEngine() {
        System.out.println("Car " + model + ": Turning key in ignition. Engine starts with a smooth purr.");
    }
    
    @Override
    public void stopEngine() {
        System.out.println("Car " + model + ": Engine shutting down. Vehicle secured.");
    }
}

// Motorcycle class implementation
class Motorcycle extends Vehicle {
    public Motorcycle(String model) {
        super(model);
    }
    
    @Override
    public void startEngine() {
        System.out.println("Motorcycle " + model + ": Pressing starter button. Engine roars to life!");
    }
    
    @Override
    public void stopEngine() {
        System.out.println("Motorcycle " + model + ": Cutting power. Engine winds down.");
    }
}

// Main demo class
public class VehicleDemo {
    public static void main(String[] args) {
        // Create instances of Car and Motorcycle
        Vehicle car = new Car("Toyota Camry");
        Vehicle motorcycle = new Motorcycle("Harley Davidson");
        
        // Test starting engines
        System.out.println("Starting vehicles:");
        car.startEngine();
        motorcycle.startEngine();
        
        System.out.println("\nStopping vehicles:");
        car.stopEngine();
        motorcycle.stopEngine();
    }
} 