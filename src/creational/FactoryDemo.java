package creational;

public class FactoryDemo {
    interface Command { void run(); }
    static class Rotate implements Command { public void run(){ System.out.println("Rotating..."); } }
    static class Activate implements Command { public void run(){ System.out.println("Panels on"); } }
    static class Factory {
        static Command get(String t){ return t.equals("rotate") ? new Rotate() : new Activate(); }
    }

    public static void run() {
        Command c1 = Factory.get("rotate"); c1.run();
        Command c2 = Factory.get("activate"); c2.run();
    }
}

