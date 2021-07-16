package singleton.type2;

/**
 * @author Chenyang
 * @create 2021-07-16-16:02
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}