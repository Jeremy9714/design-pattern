package singleton.type7;

/**
 * 单例模式：静态内部类
 *
 * @author Chenyang
 * @create 2021-07-16-16:31
 */
public class SingletonTest7 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

class Singleton {
    private Singleton() {
    }

    private static class InnerClass {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerClass.INSTANCE;
    }
}