package creational;

public class BuilderDemo {
    static class Satellite {
        String dir; ;
        Satellite(String d, boolean p, int da){ dir=d; }
        static class Builder {
            String d="North"; boolean p=false; int da=0;
            Builder dir(String d){ this.d=d; return this; }
            Satellite build(){ return new Satellite(d,p,da); }
        }
    }

    public static void run() {
        Satellite s = new Satellite.Builder().dir("South").build();
        System.out.println("Built satellite facing " + s.dir);
    }
}

