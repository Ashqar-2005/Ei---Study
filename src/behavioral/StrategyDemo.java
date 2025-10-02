package behavioral;

public class StrategyDemo {
    interface Rotation { void rotate(); }
    static class Direct implements Rotation { public void rotate(){ System.out.println("Direct rotation"); } }
    static class FuelSave implements Rotation { public void rotate(){ System.out.println("Fuel saving rotation"); } }

    public static void run() {
        Rotation r = new Direct(); r.rotate();
        r = new FuelSave(); r.rotate();
    }
}
