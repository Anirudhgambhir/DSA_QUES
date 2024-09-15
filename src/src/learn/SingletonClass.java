package learn;


public class SingletonClass {

    private static volatile SingletonClass singletonClass;

    public static SingletonClass returnInstance() {
        if (singletonClass == null) {
            synchronized (SingletonClass.class) {
                if (singletonClass == null)
                    singletonClass = new SingletonClass();
            }
        }
        return singletonClass;
    }
}
