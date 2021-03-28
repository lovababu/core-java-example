package org.avol.jdk9.accessmodifiers;

/**
 * Until JDK 8, we cannot declare a method as private in Interfaces.
 * In JDK 9, we can define method as private.
 *  - reusable code and code sharing withing interface.
 *  - same access modifier rules applicable to interface private methods too.
 */
public class InterfacePrivateMethods {


    interface Vehicle {
        void wheelCount();
        void fuelType();

        default void startMethod() {
            engineStartStop();
        }
        // private interface method.
        private static void engineStartStop() {
            System.out.println("Ignition on/off");
        }
    }

    static class Car implements Vehicle {
        @Override
        public void wheelCount() {
            System.out.println("4 wheels");
        }

        @Override
        public void fuelType() {
            System.out.println("Petrol");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.wheelCount();
        vehicle.fuelType();
        vehicle.startMethod();
    }
}
