package singleton.type5;

/**
 * 单例模式：懒汉式(同步代码块)
 *
 * @author Chenyang
 * @create 2021-07-16-16:21
 */
public class SingletonTest5 {
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

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}