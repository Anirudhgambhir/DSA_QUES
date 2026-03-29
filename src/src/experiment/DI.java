package experiment;

public class DI {
    private static DI di;
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new DI().doSomething();
        }
    }


    public static DI getDI() {
        return new DI();
    }

    public static DI getSingletonDI() {
        synchronized (DI.class) {
            if (di == null) {
                synchronized (DI.class) {
                    di = new DI();
                }
            }
            return di;
        }
    }




    public void doSomething() {

    }
}
