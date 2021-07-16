package singleton.type1;

/**
 * 单例模式：饿汉式(静态常量)
 *
 * @author Chenyang
 * @create 2021-07-16-15:56
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

class Singleton {
    private Singleton() {
    }

    public final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}