package principle.liskov;

/**
 * 里氏替换原则
 *
 * @author Chenyang
 * @create 2021-07-14-20:06
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.method1(12, 3));
        B b = new B();
        System.out.println(b.method1(12, 3));
        System.out.println(b.method2(12, 3));
        System.out.println(b.method3(12, 3));
    }
}

//更加通俗的父类
class Base {
}

class A extends Base {
    public int method1(int a, int b) {
        return a + b;
    }
}

class B extends Base {
    //使用组合关系
    private A a = new A();

    public int method1(int a, int b) {
        return a - b;
    }

    public int method2(int a, int b) {
        return method1(a, b) + 9;
    }

    public int method3(int a, int b) {
        return this.a.method1(a, b);
    }
}