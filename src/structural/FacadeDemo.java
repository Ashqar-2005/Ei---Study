package structural;

public class FacadeDemo {
    static class MissionControl {
        void rotate(){ System.out.println("Satellite rotated"); }
        void panelsOn(){ System.out.println("Panels activated"); }
        void collect(){ System.out.println("Data collected"); }
    }

    public static void run() {
        MissionControl mc = new MissionControl();
        mc.rotate(); mc.panelsOn(); mc.collect();
    }
}

