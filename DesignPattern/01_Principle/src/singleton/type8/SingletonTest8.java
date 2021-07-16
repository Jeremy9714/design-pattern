package singleton.type8;

/**
 * 单例模式：枚举
 *
 * @author Chenyang
 * @create 2021-07-16-16:39
 */
public class SingletonTest8 {
    public static void main(String[] args) {
        Singleton instance1 = Enum.valueOf(Singleton.class, "INSTANCE");
        Singleton instance2 = Enum.valueOf(Singleton.class, "INSTANCE");
        System.out.println(instance1 == instance2);
        instance1.sayOk();
        instance2.sayOk();
    }
}

enum Singleton {
    INSTANCE;

    private Singleton() {
    }

    public void sayOk() {
        System.out.println("ok");
    }
}