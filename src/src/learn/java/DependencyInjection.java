package learn.java;

import experiment.DI;

public class DependencyInjection {
    public static void main(String[] args) {
        for (double i = 0; i < 5; i++) {
            System.out.println(DI.getDI());
        }
        System.out.println("SINGLETON STARTED");
        for (double i = 0; i < 5; i++) {
            System.out.println(DI.getSingletonDI());
        }
    }
}
