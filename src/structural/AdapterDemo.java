package structural;

public class AdapterDemo {
    interface MyLog { void log(String m); }
    static class OldLogger { void write(String m){ System.out.println("Old:" + m); } }
    static class Adapter implements MyLog {
        OldLogger o = new OldLogger();
        public void log(String m){ o.write(m); }
    }

    public static void run() {
        MyLog log = new Adapter();
        log.log("Satellite started");
    }
}


