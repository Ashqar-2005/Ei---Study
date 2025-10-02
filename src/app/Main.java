package app;

import behavioral.StrategyDemo;
import behavioral.ObserverDemo;
import creational.BuilderDemo;
import creational.FactoryDemo;
import structural.AdapterDemo;
import structural.FacadeDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Behavioral Patterns ===");
        StrategyDemo.run();
        ObserverDemo.run();

        System.out.println("\n=== Creational Patterns ===");
        BuilderDemo.run();
        FactoryDemo.run();

        System.out.println("\n=== Structural Patterns ===");
        AdapterDemo.run();
        FacadeDemo.run();
    }
}
