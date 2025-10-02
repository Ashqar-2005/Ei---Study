package behavioral;

import java.util.*;

public class ObserverDemo {
    interface Observer { void update(String m); }
    static class Console implements Observer { public void update(String m){ System.out.println("Console: " + m); } }
    static class Subject {
        List<Observer> obs = new ArrayList<>();
        void add(Observer o){ obs.add(o); }
        void notifyAll(String m){ for(Observer o:obs) o.update(m); }
    }

    public static void run() {
        Subject s = new Subject();
        s.add(new Console());
        s.notifyAll("Satellite rotated");
    }
}


