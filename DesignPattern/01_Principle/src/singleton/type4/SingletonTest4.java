package singleton.type4;

/**
 * 单例模式：懒汉式(线程安全，同步方法)
 *
 * @author Chenyang
 * @create 2021-07-16-16:14
 */
public class SingletonTest4 {
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

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}