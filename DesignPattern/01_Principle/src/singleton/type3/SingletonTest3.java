package singleton.type3;

/**
 * 单例模式：懒汉式(线程不安全)
 *
 * @author Chenyang
 * @create 2021-07-16-16:10
 */
public class SingletonTest3 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

class Singleton {
    private Singleton() {
    }

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
